import React, { useState } from "react";
import "./MultiVehiculeChoice.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Line } from 'react-chartjs-2';
import Pagination from "../../utils/Pagination.js";

// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

import { formatDate } from '../../utils/utils';

function MultiVehiculeChoice() {
    //Time Picker config Start
    const useStyles = makeStyles((theme) => ({
        container: {
            display: 'flex',
            flexWrap: 'wrap',
        },
        textField: {
            marginLeft: theme.spacing(4),
            marginRight: theme.spacing(1),
            width: 150,
            marginBottom: theme.spacing(2),
        },
    }));
    const classes = useStyles();
    //Time Picker config End

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date());
    const [heureDebut, setHeureDebut] = useState(new Date());
    const [heureFin, setHeureFin] = useState(new Date());
    //chosenValues is an object containing all the values to be sent to the back end
    const [chosenValues, setChosenValues] = useState({
        resId: 0,
        modeUtil: "",
        equipId: 0,
        speed1: 0,
        speed2: 0,
        long1: 0,
        long2: 0,
    });


    function handleStartDateChange(date) {
        setStartDate(date);
    }

    function handleEndDateChange(date) {
        setEndDate(date);
    }

    function handleHeureDebut(e) {
        const value = e.target.value;
        setHeureDebut(value);
    }

    function handleHeureFin(e) {
        const value = e.target.value;
        setHeureFin(value);
    }

    function handleChange(e) {
        const { name, value } = e.target;
        setChosenValues(prevState => {
            return ({
                ...prevState,
                [name]: value
            });
        })

    }

    const [backEnd, setBackEnd] = useState({
        result: [],
        loading: true
    });
    var { result, loading } = backEnd;

    const [chartData, setChartData] = useState({
        data: {},
        isloading: true
    });

    var { data, isloading: loadingState } = chartData;

    function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        console.log(chosenValues);
        fetch("http://localhost:8080/vehiculeTable", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues)
        })
            .then(response => response.json())
            .then(response => {
                const body = response
                setBackEnd({
                    result: body,
                    loading: false
                });
            })
        fetch("http://localhost:8080/graphePlPt", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues)
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setChartData({
                    data: body,
                    isloading: false
                });
            })

    }

    //Pagination 
    const [currentPage, setCurrentPage] = useState(1);
    const [elementsPerPage, setElementsPerPage] = useState(20);
    const indexOfLastElement = currentPage * elementsPerPage;
    const indexOfFirstElement = indexOfLastElement - elementsPerPage;
    const totalElements = result.length;
    const visibleElements = result.slice(indexOfFirstElement, indexOfLastElement);

    function paginate(pageNumber) {
        setCurrentPage(pageNumber);

    }


    return (
        <div className="vehicule-container" >
            <div className="vehicule">
                <div>
                    <InputField name="resId" onChange={handleChange} description="ID-Réseau" />
                    <InputField name="long1" onChange={handleChange} description="Longueur Minimale" />
                    <DatePicker
                        className="my-datePicker"
                        selected={startDate}
                        onChange={handleStartDateChange}
                    />
                    <form className={classes.container} noValidate>
                        <TextField
                            name="heureDebut"
                            onChange={handleHeureDebut}
                            id="time"
                            label="Heure de début"
                            type="time"
                            // defaultValue="00:00"
                            className={classes.textField}
                            InputLabelProps={{
                                shrink: true,
                            }}
                            inputProps={{
                                step: 300, // 5 min
                            }}
                        />
                    </form>
                </div>

                <div>
                    <select name="modeUtil" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="CB">comptage</option>
                        <option value="PP">pesage</option>
                        <option value="CP">comptage et pesage</option>
                    </select>
                    <InputField name="long2" onChange={handleChange} description="Longueur Maximale" />
                    <DatePicker
                        name="endDate"
                        selected={endDate}
                        className="my-datePicker"
                        onChange={handleEndDateChange}
                    />
                    <form className={classes.container} noValidate>
                        <TextField
                            name="heureFin"
                            onChange={handleHeureFin}
                            id="time"
                            label="Heure de fin"
                            type="time"
                            // defaultValue="00:00"
                            className={classes.textField}
                            InputLabelProps={{
                                shrink: true,
                            }}
                            inputProps={{
                                step: 300, // 5 min
                            }}
                        />
                    </form>

                </div>

                <div>
                    <InputField name="equipId" onChange={handleChange} description="ID-Equipement" />
                    <InputField name="speed1" onChange={handleChange} description="Vitesse Minimale" />
                    <InputField name="speed2" onChange={handleChange} description="Vitesse Maximale" />

                </div>
            </div>
            <button onClick={handleButtonClick} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>
            {!loading && <div className="vehicule-table">
                <table class="table table-striped table-md ">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Date</th>
                            <th scope="col">Temps</th>
                            <th scope="col">Longueur</th>
                            <th scope="col">Nombre Essieu</th>
                            <th scope="col">Classe</th>
                            <th scope="col">Vitesse</th>
                            <th scope="col">Headway</th>
                            <th scope="col">Surcharge</th>
                            <th scope="col">Voie</th>
                            <th scope="col">Sens</th>
                        </tr>
                    </thead>
                    <tbody>
                        {visibleElements.map(donnee => <tr>
                            <th scope="row">{JSON.stringify(donnee.id)}</th>
                            <td>{JSON.stringify(donnee.date)}</td>
                            <td>{JSON.stringify(donnee.time)}</td>
                            <td>{JSON.stringify(donnee.longueur)}</td>
                            <td>{JSON.stringify(donnee.nombreEssieu)}</td>
                            <td>{JSON.stringify(donnee.classe)}</td>
                            <td>{JSON.stringify(donnee.vitesse)}</td>
                            <td>{JSON.stringify(donnee.headway)}</td>
                            <td>{JSON.stringify(donnee.surcharge)}</td>
                            <td>{JSON.stringify(donnee.voie)}</td>
                            <td>{JSON.stringify(donnee.sens)}</td>

                        </tr>)}
                    </tbody>
                </table>
                <Pagination
                    elementsPerPage={elementsPerPage}
                    totalElements={result.length}
                    paginate={paginate}
                />
            </div>}

            {!loadingState && <div className="vehicule-chart">
                <Line
                    data={{
                        labels: ["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                            "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
                            "23:00"],
                        datasets: [{
                            data: data["Poids Lourd"],
                            label: "Poids lourd",
                            borderColor: "#3e95cd",
                            fill: false
                        }, {
                            data: data["Poids Total"],
                            label: "Poids total",
                            borderColor: "#8e5ea2",
                            fill: false
                        }]
                    }
                    }
                    options={
                        {
                            title: {
                                display: true,
                                text: 'Titre: Répartition Horaire du nombre de passage selon le type du véhicule'
                            }
                        }
                    }
                />
            </div>}
        </div>
    );
}

export default MultiVehiculeChoice;