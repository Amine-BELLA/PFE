import React, { useState } from "react";
import "./VitesseClasse.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import ChoixVoie, { voieValues } from "../ChoixVoie/ChoixVoie";
import CBChoixClasses, { CBClassesValues } from "../CBChoixClasses/CBChoixClasses";
import PPChoixClasses, { PPClassesValues } from "../PPChoixClasses/PPChoixClasses";
import CPChoixClasses, { CPClassesValues } from "../CPChoixClasses/CPChoixClasses";
import { Bar } from "react-chartjs-2";
// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

import { formatDate } from '../../utils/utils';

function VitesseClasse() {

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
    const [modeUtilisation, setModeUtilisation] = useState("");
    function displayClasses(e) {
        const value = e.target.value;
        setModeUtilisation(value);
    }

    function renderClasses() {
        switch (modeUtilisation) {
            case 'CB': {
                return (<CBChoixClasses />);
            }
            case 'PP': {
                return (<PPChoixClasses />);
            } case 'CP': {
                return (<CPChoixClasses />);
            }
            default: return null;
        }
    }

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

    function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        chosenValues.voie = voieValues;
        chosenValues.modeUtil = modeUtilisation;
        if (modeUtilisation == "CB") { chosenValues.classes = CBClassesValues }
        else if (modeUtilisation == "PP") { chosenValues.classes = PPClassesValues }
        else if (modeUtilisation == "CP") { chosenValues.classes = CPClassesValues }
        console.log(chosenValues);
        fetch('http://localhost:8080/vitesseParClasse', {
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
                    <ChoixVoie />

                </div>
                <div>
                    <select name="modeUtil" onChange={displayClasses} class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="CB">comptage</option>
                        <option value="PP">pesage</option>
                        <option value="CP">comptage et pesage</option>
                    </select>
                    <DatePicker
                        name="endDate"
                        selected={endDate}
                        className="my-datePicker"
                        onChange={handleEndDateChange}
                    />
                    {renderClasses()}
                </div>
                <div>
                    <InputField className="periode-input-field" name="equipId" onChange={handleChange} description="ID-Equipement" />
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
                <div>
                    {JSON.stringify(data)}
                    <br />
                    {JSON.stringify(Object.keys(data))}
                    <br />
                    <br />
                    {JSON.stringify(Object.values(data).map( v => Object.values(v)))}
                </div>}
            {/* {!loading &&
                <div>
                    <Bar data={{
                        labels: `${Object.keys(data)}-${Object.keys(Object.keys(data))}` ,
                        datasets: [{
                            data: Object.values(data).map( v => {
                                for (var i=0 ; i<100 ; i++) {
                                    return(v[i][0]);
                                }
                            }),
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
                        }} />
                </div>} */}
        </div>
    );
}

export default VitesseClasse; 