import React, { useState } from 'react';
import "./EtatChaussee.css";
import InputField from "../InputField/InputField";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Pagination from "../../utils/Pagination.js";
import { formatDate } from '../../utils/utils';
import { Line } from "react-chartjs-2";

// Time Picker imports
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';


function EtatChaussee() {

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

    const [chosenValues, setChosenValues] = useState({
        equipId: 0,
        resId: 0,
        modeUtil: "",
        alpha: 0,
        i: 0,
        n: 0,
        c: 0,
        yearD: 0
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
        setChosenValues(previousValue => {
            return (
                {
                    ...previousValue,
                    [name]: value
                }
            );
        })
    }

    //surcharge Horaire
    const [surchargeH, setSurchargeH] = useState({
        resultSurchargeH: [],
        loadingSurchargeH: true
    });
    let { resultSurchargeH, loadingSurchargeH } = surchargeH;

    //surcharge Journaliere
    const [surchargeJ, setSurchargeJ] = useState({
        resultSurchargeJ: [],
        loadingSurchargeJ: true
    });
    let { resultSurchargeJ, loadingSurchargeJ } = surchargeJ;

    //Pourcentage PL
    const [pourcentagePl, setPourcentagePl] = useState({
        resultPourcentagePl: [],
        loadingPourcentagePl: true
    });
    let { resultPourcentagePl, loadingPourcentagePl } = pourcentagePl;

    //CAM
    const [cam, setCam] = useState({
        resultCam: 0,
        loadingCam: true
    });
    let { resultCam, loadingCam } = cam;

    //Ne
    const [Ne, setNe] = useState({
        resultNe: 0,
        loadingNe: true
    });
    let { resultNe, loadingNe } = Ne;

    //Aggressivite
    const [aggressivite, setAggressivite] = useState({
        resultAggressivite: {},
        loadingAggressivite: true
    });
    let { resultAggressivite, loadingAggressivite } = aggressivite;

    //taux d'Occupation
    const [tauxOccupation, setTauxOccupation] = useState({
        resultTauxOccupation: [],
        loadingTauxOccupation: true
    });
    let { resultTauxOccupation, loadingTauxOccupation } = tauxOccupation;

    function handleButtonChange() {
        chosenValues.debutTime = `${formatDate(startDate)}T${heureDebut}:00`;
        chosenValues.finTime = `${formatDate(endDate)}T${heureFin}:00`;
        console.log(chosenValues);
        //surcharge Horaire
        fetch("http://localhost:8080/surchargeH", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setSurchargeH({
                    resultSurchargeH: body,
                    loadingSurchargeH: false
                });
            })

        //surcharge Horaire
        fetch("http://localhost:8080/surchargeJ", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setSurchargeJ({
                    resultSurchargeJ: body,
                    loadingSurchargeJ: false
                });
            })

        //Pourcentage Pl
        fetch("http://localhost:8080/pourcentagePl", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setPourcentagePl({
                    resultPourcentagePl: body,
                    loadingPourcentagePl: false
                });
            })

        //CAM
        fetch("http://localhost:8080/cam", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setCam({
                    resultCam: body,
                    loadingCam: false
                });
            })

        //Ne
        fetch("http://localhost:8080/ne", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setNe({
                    resultNe: body,
                    loadingNe: false
                });
            })

        //Aggressivite
        fetch("http://localhost:8080/aggressivite", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setAggressivite({
                    resultAggressivite: body,
                    loadingAggressivite: false
                });
            })

        //taux Occupation
        fetch("http://localhost:8080/tauxOccup1", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setTauxOccupation({
                    resultTauxOccupation: body,
                    loadingTauxOccupation: false
                });
            })
    }


    //Pagination 
    const [currentPage, setCurrentPage] = useState(1);
    const [elementsPerPage, setElementsPerPage] = useState(20);
    const indexOfLastElement = currentPage * elementsPerPage;
    const indexOfFirstElement = indexOfLastElement - elementsPerPage;
    const totalElements = Object.keys(resultAggressivite).length;
    const visibleElements = Object.keys(resultAggressivite).slice(indexOfFirstElement, indexOfLastElement);

    function paginate(pageNumber) {
        setCurrentPage(pageNumber);
    }

    return (
        <div className="etat-chaussee">
            <h5>Visualisation > Suivi de l'état de chaussée</h5>
            <div className="etat-chaussee-grid">
                <div>
                    <InputField onChange={handleChange} name="resId" description="ID-Réseau" />
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

                    <InputField name="equipId" onChange={handleChange} description="ID-Equipement" />
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
                    <select name="modeUtil" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="CB">comptage</option>
                        <option value="PP">pesage</option>
                        <option value="CP">comptage et pesage</option>
                    </select>

                    <select name="alpha" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Coefficient ⍺</option>
                        <option value="4" >4</option>
                        <option value="8" >8</option>
                        <option value="12" >12</option>
                    </select>
                    <select name="c" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Coefficient c</option>
                        <option value="1">1</option>
                        <option value="1.5">1.5</option>
                        <option value="2">2</option>
                    </select>

                </div>
            </div>

            <div className="second-grid">
                <InputField onChange={handleChange} name="i" description="taux de progression du trafic" />
                <InputField onChange={handleChange} name="n" description="Durée de vie" />
                <InputField onChange={handleChange} name="yearD" description="année de mise en service" />
            </div>

            <button onClick={handleButtonChange} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>

            {!loadingSurchargeH && <div className="vehicule-chart">
                <Line
                    data={{
                        labels: ["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                            "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
                            "23:00"],
                        datasets: [{
                            data: resultSurchargeH,
                            label: "Surcharge Horaire",
                            borderColor: "#3e95cd",
                            fill: false
                        }]
                    }
                    }
                    options={
                        {
                            title: {
                                display: true,
                                text: 'Titre : Surcharge Horaire'
                            }
                        }
                    }
                />

            </div>}

            {!loadingSurchargeJ &&
                <div className="chart-horaire">
                    <Line
                        data={{
                            labels: ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"],
                            datasets: [{
                                data: resultSurchargeJ,
                                label: "Surcharge Journalière",
                                borderColor: "#3e95cd",
                                fill: false
                            }]
                        }
                        }
                        options={
                            {
                                title: {
                                    display: true,
                                    text: 'Titre: Surcharge Journalière'
                                }
                            }
                        }
                    />
                </div>}

            {!loadingPourcentagePl && <div className="vehicule-chart">
                <Line
                    data={{
                        labels: ["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                            "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
                            "23:00"],
                        datasets: [{
                            data: resultPourcentagePl,
                            label: "Pourcentage des poids lourds",
                            borderColor: "#3e95cd",
                            fill: false
                        }]
                    }
                    }
                    options={
                        {
                            title: {
                                display: true,
                                text: 'Titre : Répartition Horaire de la valeur moyenne du pourcentage des poids lourds'
                            }
                        }
                    }
                />

            </div>}

            {!(loadingCam && loadingNe) && <div className="result-grid">
                <div className="cam">CAM :{JSON.stringify(resultCam)}</div>
                <div className="cam">Ne : {JSON.stringify(resultNe)} </div>
                <div className="cam"> {resultTauxOccupation[0]} </div>
            </div>}

            {!loadingAggressivite && <div className="etat-chaussee-table">
                <table class="table table-dark table-md ">
                    <thead>
                        <tr>
                            <th scope="col">Date et Heure du passage</th>
                            <th scope="col">Agréssivité du passage</th>
                        </tr>
                    </thead>
                    <tbody>
                        {visibleElements.map(key => <tr>
                            <th scope="row">{JSON.stringify(key)}</th>
                            <td>{JSON.stringify(resultAggressivite[key])}</td>
                        </tr>)}
                    </tbody>
                </table>
                <Pagination
                    elementsPerPage={elementsPerPage}
                    totalElements={Object.keys(resultAggressivite).length}
                    paginate={paginate}
                />
            </div>}
        </div>
    );
}

export default EtatChaussee;