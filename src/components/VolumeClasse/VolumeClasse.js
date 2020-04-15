import React from "react";
import "./VolumeClasse.css";
import InputField from "../InputField/InputField";

function VolumeClasse() {
    return (
        <div className="volume-classe">
            <div>
                <InputField description="ID" />
                <InputField description="Classe" />
                <InputField description="Date de début" />
                <InputField description="Date de Fin" />
                <InputField description="Heure de début" />
                <InputField description="Heure de Fin" />

            </div>
            <div>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option >Voie</option>
                    <option value="voie1">1</option>
                    <option value="voie2">2</option>
                    <option value="voie3">3</option>
                    <option value="voie4">4</option>
                    <option value="voie5">5</option>
                    <option value="voie6">6</option>
                </select>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option >Sens</option>
                    <option value="sens1">1</option>
                    <option value="sens2">2</option>
                </select>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option >Type de véhicule</option>
                    <option value="VL">VL</option>
                    <option value="PL">PL</option>
                    <option value="Total">Total</option>
                </select>
            </div>
        </div>
    );
}

export default VolumeClasse;