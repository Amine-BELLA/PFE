import React from "react";
import "./MultiChoice.css"
import { NavLink } from "react-router-dom";
import { useState } from "react";
import Periode from "../Periode/Periode";
import Select from "../Select/Select";
import VolumeClasse from "../VolumeClasse/VolumeClasse";
import VolumeVitesse from "../VolumeVitesse/VolumeVitesse";
import VolumeRoute from "../VolumeRoute/VolumeRoute";
import VolumeVoie from "../VolumeVoie/VolumeVoie";
import VolumeSens from "../VolumeSens/VolumeSens";

function MultiChoice() {
    const [selection, setSelection] = useState();   
    function handle(e) {
        e.preventDefault();
        var v = e.target.value;
        setSelection(v);
    } 

    function renderFilter() {
        switch(selection) {
            case 'Volume par période' : {
                return (<Periode />);
            }

            case 'Volume par classe' : {
                return (<VolumeClasse />);
            }

            case 'Volume par vitesse' : {
                return ( <VolumeVitesse />);
            }

            case 'Volume par route' : {
                return ( <VolumeRoute />);
            }

            case 'Volume par voie' : {
                return ( <VolumeVoie />);
            }

            case 'Volume par sens' : {
                return ( <VolumeSens />);
            }

            default : return null;
        }
    }

    return (
        <div className="choose">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Choisir un filtre</label>
                <select onClick = {handle} class="form-control" id="exampleFormControlSelect1">
                    <option></option>
                    <option value="Volume par période">Volume par période</option>
                    <option value="Volume par classe">Volume par classe</option>
                    <option value="Volume par vitesse">Volume par vitesse</option>
                    <option value="Volume par route">Volume par route</option>
                    <option value="Volume par voie">Volume par voie</option>
                    <option value="Volume par sens">Volume par sens</option>
                </select>
            </div>
            <div>
                {renderFilter()}
            </div>
        </div>
    );
}

export default MultiChoice;