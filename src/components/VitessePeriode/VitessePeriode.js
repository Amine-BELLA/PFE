import React, { useState } from "react";
import "./VitessePeriode.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Line } from "react-chartjs-2";

// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

import { formatDate } from '../../utils/utils';

function VitessePeriode() {

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

    const [chartData, setChartData] = useState({
        data: {},
        loading: true
    });

    var { data, loading } = chartData;

    const [secondChartData, setSecondChartData] = useState({
        secondData: {},
        isLoading: true
    });

    var { secondData, isLoading } = secondChartData;
    function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        fetch('http://localhost:8080/vitesseParPeriodeHoraire', {
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
        fetch('http://localhost:8080/vitesseParPeriodeJournaliere', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setSecondChartData({
                    secondData: body,
                    isLoading: false
                });
            })

    }

    return (
        <div className="vitesse-periode-container">
            <div className="vitesse-periode">
                <div>
                    <InputField name="resId" onChange={handleChange} description="ID-Réseau" />
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



                </div>
                <div>
                    <InputField className="periode-input-field" name="equipId" onChange={handleChange} description="ID-Equipement" />
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
            </div>

            <button onClick={handleButtonClick} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>
            {!loading &&
                <div className="chart-horaire">
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
                                data: data["Véhicule leger"],
                                label: "Véhicule leger",
                                borderColor: "#8e5ea2",
                                fill: false
                            }]
                        }
                        }
                        options={
                            {
                                title: {
                                    display: true,
                                    text: 'Titre: Répartition Horaire de la vitesse'
                                }
                            }
                        }
                    />
                </div>}
            {!isLoading &&
                <div className="chart-horaire">
                    <Line
                        data={{
                            labels: ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"],
                            datasets: [{
                                data: secondData["Poids Lourd"],
                                label: "Poids lourd",
                                borderColor: "#3e95cd",
                                fill: false
                            }, {
                                data: secondData["Poids Leger"],
                                label: "Véhicule leger",
                                borderColor: "#8e5ea2",
                                fill: false
                            }]
                        }
                        }
                        options={
                            {
                                title: {
                                    display: true,
                                    text: 'Titre: Répartition Journalière de la vitesse'
                                }
                            }
                        }
                    />
                </div>}
        </div>
    );
}

export default VitessePeriode; 