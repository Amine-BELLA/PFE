import React from "react";
import "./ExportationRapports.css";

function ExportationRapports() {
    return (
        <div className="exportation-rapports">
            <div>
                <h5>Exportation > Génération des Rapports</h5>
                <button type="button" class="btn btn-outline-primary btn-md">Volume Horaire par date</button>
                <button type="button" class="btn btn-outline-primary btn-md">Volume journalier par date </button>
                <button type="button" class="btn btn-outline-primary btn-md">Vitesse par Sens</button>
                <button type="button" class="btn btn-outline-primary btn-md">Vitesse par voie</button>
                <button type="button" class="btn btn-outline-primary btn-md">Pesée</button>
            </div>

            <div className="exporter-btn">
                <button type="button" class="btn btn-success btn-md"><i class="fas fa-download"></i> Exporter</button>
            </div>

        </div>
    );
}

export default ExportationRapports;