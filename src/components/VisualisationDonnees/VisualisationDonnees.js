import React from "react";
import "./VisualisationDonnees.css"
import { useState } from "react";
import MultiChoice from "../MultiChoice/MultiChoice.js";
import MultiVehiculeChoice from "../MultiVehiculeChoice/MultiVehiculeChoice";


function VisualisationDonnees() {

    const [verifyVolumeClick, setVerifyVolumeClick] = useState(false);
    const [verifyVitesseClick, setVerifyVitesseClick] = useState(false);
    const [verifyVehiculeClick, setVerifyVehiculeClick] = useState(false);


    function handleVolumeClick() {
        setVerifyVolumeClick(true);
        setVerifyVitesseClick(false);
        setVerifyVehiculeClick(false)
    }

    function handleVitesseClick() {
        setVerifyVitesseClick(true);
        setVerifyVolumeClick(false);
        setVerifyVehiculeClick(false);
    }

    function handleVehiculeClick() {
        setVerifyVehiculeClick(true);
        setVerifyVitesseClick(false);
        setVerifyVolumeClick(false);
    }



    return (
        <div className="donnees-container">
            <h5>Visualisation > Visualisation des données</h5>
            <div className="donnees-btn">
                <p> Choisir le paramètre à visualiser :</p>
                <button onClick = {handleVolumeClick} type="button" class="btn btn-outline-primary btn-md">Volume</button>
                <button onClick = {handleVitesseClick} type="button" class="btn btn-outline-primary btn-md">Vitesse</button>
                <button onClick = {handleVehiculeClick} type="button" class="btn btn-outline-primary btn-md">Véhicules</button>
            </div>

            {verifyVolumeClick && <MultiChoice />}
            {verifyVehiculeClick && <MultiVehiculeChoice />}
        </div>
    );
}

export default VisualisationDonnees;