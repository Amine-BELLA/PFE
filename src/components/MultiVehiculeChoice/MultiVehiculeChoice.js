import React from "react";
import "./MultiVehiculeChoice.css";
import InputField from "../InputField/InputField";

function MultiVehiculeChoice() {
    return (
        <div className="vehicule">
            <div>
                <InputField description="ID" />
                <InputField description="Voie" />
                <InputField description="Classe" />
                <InputField description="Poids" />


            </div>

            <div>
                <InputField description="Vitesse Minimale" />
                <InputField description="Vitesse Maximale" />
                <InputField description="Longueur Minimale" />
                <InputField description="Longueur Maximale" />
            </div>
        </div>
    );
}

export default MultiVehiculeChoice;