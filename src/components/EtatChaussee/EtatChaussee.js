import React from 'react';
import "./EtatChaussee.css";
import InputField from "../InputField/InputField";

function EtatChaussee() {
    return (
        <div className="etat-chaussee">
            <h5>Visualisation > Suivi de l'état de chaussée</h5>
            <select class="form-control" id="exampleFormControlSelect1">
                    <option >Choisir un paramètre</option>
                    <option value="agressivite">Agréssivité</option>
                    <option value="CAM">CAM</option>
                    <option value="TMJA">TMJA</option>
                    <option value="duree de vie">Durée de Vie</option>
                    <option value="taux-occupation">Taux d'occupation</option>
                    <option value="pourcentage-PL">Pourcentage de PL</option>
                    <option value="surcharge">Surcharge</option>
                    <option value="temperature">Température</option>
                </select>
        </div>
    );
}

export default EtatChaussee;