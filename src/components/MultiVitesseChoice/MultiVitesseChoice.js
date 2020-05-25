import React, { useState } from "react";
import "./MultiVitesseChoice.css";
import VitessePeriode from "../VitessePeriode/VitessePeriode";
import VitesseClasse from "../VitesseClasse/VitesseClasse";
import VitesseRoute from "../VitesseRoute/VitesseRoute";

function MultiVitesseChoice() {

    const [selection, setSelection] = useState();
    function handle(e) {
        e.preventDefault();
        const v = e.target.value;
        setSelection(v);
    }

    function renderFilter() {
        switch (selection) {
            case 'Vitesse par période': {
                return (<VitessePeriode />);
            }

            case 'Vitesse par classe': {
                return (<VitesseClasse />);
            }


            case 'Vitesse par route': {
                return (<VitesseRoute />);
            }

            default: return null;
        }
    }
    return (
        <div className="vitesse-filter">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Choisir un filtre</label>
                <select onClick={handle} class="form-control" id="exampleFormControlSelect1">
                    <option></option>
                    <option value="Vitesse par période">Vitesse par période</option>
                    <option value="Vitesse par classe">Vitesse par classe</option>
                    <option value="Vitesse par route">Vitesse par route</option>

                </select>
            </div>
            <div>
                {renderFilter()}
            </div>
        </div>
    );
}

export default MultiVitesseChoice;