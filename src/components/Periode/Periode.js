import React, { useState } from "react";
import "./Periode.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Bar } from 'react-chartjs-2';
import Pagination from "../../utils/Pagination.js";
// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

import { formatDate } from '../../utils/utils';
function Periode() {



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
        typePoid: "",
    });

    const [backEndResponse, setBackEndResponse] = useState({
        volumeParPeriode: [],
        isLoading: true
    });



    let { volumeParPeriode, isLoading: loadingState } = backEndResponse;

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

    const [chartData, setChartData] = useState({
        data: [],
        loading: true
    });

    var { data, loading } = chartData;

    function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        fetch('http://localhost:8080/volumeParPeriode', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setBackEndResponse({
                    volumeParPeriode: body,
                    isLoading: false
                });
            })
        fetch('http://localhost:8080/grapheVolumeParPeriode', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setChartData({
                    data: body,
                    loading: false
                });
            })


    }
    //Pagination 
    const [currentPage, setCurrentPage] = useState(1);
    const [elementsPerPage, setElementsPerPage] = useState(20);
    const indexOfLastElement = currentPage * elementsPerPage;
    const indexOfFirstElement = indexOfLastElement - elementsPerPage;
    const totalElements = volumeParPeriode.length;
    const visibleElements = volumeParPeriode.slice(indexOfFirstElement, indexOfLastElement);

    function paginate(pageNumber) {
        setCurrentPage(pageNumber);
        
    }


    return (
        <div className="periode-container">
            <div className="periode">
                <div>
                    <InputField name="resId" onChange={handleChange} description="ID-Réseau" />
                    <select onChange={handleChange} name="typePoid" class="form-control" id="exampleFormControlSelect1">
                        <option >Type de véhicule</option>
                        <option value="PL">VL</option>
                        <option value="VL">PL</option>
                        <option value="Total">Total</option>
                    </select>
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

                    <DatePicker
                        className="my-datePicker"
                        selected={startDate}
                        onChange={handleStartDateChange}
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
                    <InputField className="periode-input-field" name="equipId" onChange={handleChange} description="ID-Equipement" />
                    <DatePicker
                        name="endDate"
                        selected={endDate}
                        className="my-datePicker"
                        onChange={handleEndDateChange}
                    />
                </div>
            </div>

            <button onClick={handleButtonClick} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>

            {!loadingState && <div className="periode-table">
                <table class="table table-striped table-md ">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Longueur</th>
                            <th scope="col">Nombre Essieu</th>
                            <th scope="col">Date</th>
                            <th scope="col">Temps</th>
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
                            <td>{JSON.stringify(donnee.longueur)}</td>
                            <td>{JSON.stringify(donnee.nombreEssieu)}</td>
                            <td>{JSON.stringify(donnee.date)}</td>
                            <td>{JSON.stringify(donnee.time)}</td>
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
                    totalElements={volumeParPeriode.length}
                    paginate={paginate}
                />
            </div>}

            {!loading && <Bar data={{
                labels: data.map(d => d[0]),
                datasets: [{
                    data: data.map(d => d[1]),
                    backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                }],
            }}
                options={{
                    legend: { display: false },
                    title: {
                        display: true,
                        text: 'Titre: Nombre de Passage par periode',
                        fontSize: 12,
                        fontColor: 'rgba(136,225,242,1)'

                    }
                }} />}



        </div>
    );
}

export default Periode;