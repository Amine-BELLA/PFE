import React, { useState } from "react";
import "./VolumeRoute.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { formatDate } from '../../utils/utils';
import ChoixIdEquipements, { IdEquipementsValues } from "../ChoixIdEquipements/ChoixIdEquipements";
import { Bar } from "react-chartjs-2";

// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

function VolumeRoute() {
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
        typePoid: "",
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
    const [backEndResponse, setBackEndResponse] = useState({
        volumeParRoute: [],
        loading: true
    });

    let { volumeParRoute, loading } = backEndResponse;

    const [backEnd, setBackEnd] = useState({
        result: {},
        isLoading: true
    });
    var { result, isLoading: loadingState } = backEnd;

    function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        chosenValues.equipIds = IdEquipementsValues;
        console.log(chosenValues);
        fetch('http://localhost:8080/volumeParRoute', {
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
                    volumeParRoute: body,
                    loading: false
                });
            })
        fetch('http://localhost:8080/grapheVolumeParRoute', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setBackEnd({
                    result: body,
                    isLoading: false
                });

            });

    }


    return (
        <div>
            <div className="volume-route">
                <div >
                    <InputField onChange={handleChange} name="resId" description="ID-Réseau" />
                    <select onChange={handleChange} name="typePoid" class="form-control" id="exampleFormControlSelect1">
                        <option >Type de véhicule</option>
                        <option value="PL">VL</option>
                        <option value="VL">PL</option>
                        <option value="Total">Total</option>
                    </select>
                    <select onChange={handleChange} name="sens" class="form-control" id="exampleFormControlSelect1">
                        <option >Sens</option>
                        <option value="AB">AB</option>
                        <option value="BA">BA</option>
                    </select>


                </div>
                <div>
                    <select onChange={handleChange} name="modeUtil" class="form-control" id="exampleFormControlSelect1">
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
                    <div className="choix-equip">
                        <ChoixIdEquipements />
                    </div>

                    <div className="end-date-style">
                        <DatePicker
                            name="endDate"
                            selected={endDate}
                            className="my-datePicker"
                            onChange={handleEndDateChange}
                        />
                    </div>
                    <div classNmae="end-hour-style">
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
                </div>
            </div>
            <button onClick={handleButtonClick} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>
            {!loading && <div className="volume-route-table">
                <table class="table table-striped table-md ">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Equipement Id</th>
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
                        {volumeParRoute.map(donnee => <tr>
                            <th scope="row">{JSON.stringify(donnee.id)}</th>
                            <th scope="row">{JSON.stringify(donnee.equipementId)}</th>
                            <td>{JSON.stringify(donnee.date)}</td>
                            <td>{JSON.stringify(donnee.time)}</td>
                            <td>{JSON.stringify(donnee.longueur)}</td>
                            <td>{JSON.stringify(donnee.nombreEssieu)}</td>
                            <td>{JSON.stringify(donnee.classe)}</td>
                            <td>{JSON.stringify(donnee.vitesse)}</td>
                            <td>{JSON.stringify(donnee.headway)}</td>
                            <td>{JSON.stringify(donnee.overloaded)}</td>
                            <td>{JSON.stringify(donnee.voie)}</td>
                            <td>{JSON.stringify(donnee.sens)}</td>

                        </tr>)}
                    </tbody>
                </table>
            </div>}

            {!loadingState && <Bar data={{
                labels: Object.keys(result),
                datasets: [
                    {
                        data: Object.values(result).map(s => s.length),
                        backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                    }
                ]
            }
            }
                options={{
                    legend: { display: false },
                    title: {
                        display: true,
                        text: 'Titre: Nombre de passage détecté sur chaque route par capteur',
                        fontSize: 12,
                        fontColor: 'rgba(136,225,242,1)'

                    }
                }} />}


        </div>
    );
}

export default VolumeRoute;