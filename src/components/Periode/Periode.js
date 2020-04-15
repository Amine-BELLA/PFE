import React from "react";
import "./Periode.css";
import InputField from "../InputField/InputField";

function Periode() {
    return (
        <div className="periode">
            <div>
                <InputField description="ID" />
                <select class="form-control" id="exampleFormControlSelect1">
                    <option >Choisir une période</option>
                    <option value="Jour">Jour</option>
                    <option value="Semaine">Semaine</option>
                    <option value="Mois">Mois</option>
                    <option value="Année">Année</option>
                    <option value="Libre">Libre</option>
                </select>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option >Type de véhicule</option>
                    <option value="VL">VL</option>
                    <option value="PL">PL</option>
                    <option value="Total">Total</option>
                </select>
            </div>
            <div>
                <InputField description="Date de début" />
                <InputField description="Date de Fin" />
                <InputField description="Heure de début" />
                <InputField description="Heure de Fin" />

            </div>

        </div>
    );
}

export default Periode;