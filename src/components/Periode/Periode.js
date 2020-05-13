import React, { useState } from "react";
import "./Periode.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

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

    async function handleButtonClick() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        console.log(chosenValues);
        const response = await fetch('http://localhost:8080/volumeParRoute', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        });
        const body = await response.json();
        setBackEndResponse({
            volumeParPeriode: body,
            isLoading: false
        });
    }

    function test() {
        console.log(volumeParPeriode);
    }

    return (
        <div className="periode-container">
            <div className="periode">
                <div>
                    <InputField name="resId" onChange={handleChange} description="ID-Réseau" />
                    <select onChange={handleChange} name="typeVehicule" class="form-control" id="exampleFormControlSelect1">
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
            {test()}
            {
                volumeParPeriode.map(donnee => {
                    return ( 
                    <div>{JSON.stringify(donnee)}</div>
                        // <table class="table table-striped">
                        //     <thead>
                        //         <tr>
                        //             <th scope="col">Id</th>
                        //             <th scope="col">Longueur</th>
                        //             <th scope="col">Nombre Essieu</th>
                        //             <th scope="col">Date</th>
                        //             <th scope="col">Temps</th>
                        //             <th scope="col">Classe</th>
                        //             <th scope="col">Vitesse</th>
                        //             <th scope="col">Headway</th>
                        //             <th scope="col">Surcharge</th>
                        //             <th scope="col">Voie</th>
                        //             <th scope="col">Sens</th>
                        //         </tr>
                        //     </thead>
                        //     <tbody>
                        //         <tr>
                        //             <th scope="row">{JSON.stringify(donnee.id)}</th>
                        //             <td>Mark</td>
                        //             <td>Otto</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //             <td>@mdo</td>
                        //         </tr>
                        //     </tbody>
                        // </table>
                    );
                })
            }
        </div>
    );
}

export default Periode;