import React, { useState } from "react";
import "./TempsReel.css";
import InputField from "../InputField/InputField";
import ChoixVoie, { voieValues } from "../ChoixVoie/ChoixVoie";
import Pagination from "../../utils/Pagination.js";

function TempsReel() {

    const [chosenValues, setChosenValues] = useState({
        equipId: 0,
        resId: 0,
        modeUtil: ""
    });

    const [backEnd, setBackEnd] = useState({
        result: [],
        loading: true
    });
    var { result, loading } = backEnd;

    function handleChange(e) {
        e.preventDefault();
        const { name, value } = e.target;
        setChosenValues(previousValue => {
            return ({
                ...previousValue,
                [name]: value
            });
        })
    }

    function handleButtonClick() {
        chosenValues.voie = voieValues;
        fetch("http://localhost:8080/tempsReel", {
            method: "POST",
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
                    loading: false
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
        <div className="temps-reel">
            <p> Visualisation > Visualisation en temps réel</p>
            <div className="temps-reel-grid">
                <div>
                    <InputField onChange={handleChange} name="resId" description="ID-Réseau" />

                </div>
                <div>
                    <select onChange={handleChange} name="modeUtil" class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="CB">comptage</option>
                        <option value="PP">pesage</option>
                        <option value="CP">comptage et pesage</option>
                    </select>
                </div>
                <div>
                    <InputField onChange={handleChange} className="periode-input-field" name="equipId" description="ID-Equipement" />

                </div>
                <div className="temps-reel-voie">
                    <ChoixVoie />
                </div>
            </div>
            <button onClick={handleButtonClick} type="button" class="btn btn-outline-info btn-sm">Visualiser</button>
            {!loading && <div className="temps-reel-table">
                <table class="table table-striped table-md ">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Date</th>
                            <th scope="col">Temps</th>
                            <th scope="col">Longueur</th>
                            <th scope="col">Nombre Essieu</th>
                            <th scope="col">Poids Total</th>
                            <th scope="col">Gap</th>
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
                            <td>{JSON.stringify(donnee.poids_total)}</td>
                            <td>{JSON.stringify(donnee.gap)}</td>
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
        </div>
    );
}

export default TempsReel;