import React from "react";
import "./ExportationDonnees.css"
import InputField from "../InputField/InputField";

function ExportationDonnees() {
    return (
        <div className="exportation-donnees-container">
            <h5> Exportation > Exportation des données </h5>
            <div className="exportation-donnees">
                <div>
                    <InputField description="Date de début" />
                    <InputField description="Heure de début" />
                    <InputField description="Date de Fin" />
                    <InputField description="Heure de Fin" />
                </div>

                <div>
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Type de véhicule</option>
                        <option value="VL">VL</option>
                        <option value="PL">PL</option>
                        <option value="Total">Total</option>
                    </select>
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Choisir une période</option>
                        <option value="Jour">Jour</option>
                        <option value="Semaine">Semaine</option>
                        <option value="Mois">Mois</option>
                        <option value="Année">Année</option>
                        <option value="Libre">Libre</option>
                    </select>
                </div>
            </div>
            <button type="button" class="btn btn-success btn-md"><i class="fas fa-download"></i> Exporter</button>
        </div>


    );
}

export default ExportationDonnees;