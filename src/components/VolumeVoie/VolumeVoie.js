import React from "react";
import "./VolumeVoie.css";
import InputField from "../InputField/InputField";

function VolumeVoie() {
    return (
        <div className="volume-voie">
            <div>
                <InputField description="ID" />
                <InputField description="Classe" />
                <InputField description="Groupement" />
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

export default VolumeVoie;