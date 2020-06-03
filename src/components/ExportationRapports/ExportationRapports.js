import React, { useState } from "react";
import "./ExportationRapports.css";
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';

function ExportationRapports() {

    const [backEnd, setBackEnd] = useState({
        result: [],
        loading: true
    });
    var { result, loading } = backEnd;
    const chosenValues = {
        equipId: 4,
        resId: 3,
        modeUtil: "CB",
        voie: [1, 2]
    }

    function handle() {
        fetch('http://localhost:8080/tempsReel', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(chosenValues),
        })
            .then(response => response.json())
            .then(response => {
                const body = response;
                setBackEnd({
                    result: body,
                    loading: false
                });
            })

        if (!loading) {
            const doc = new jsPDF();
            doc.autoTable({
                theme: 'grid',
                head: [['Id', 'Longueur', 'Nombre Essieu', 'date', 'time', 'poids total', 'gap', 'classe', 'vitesse', 'headway', 'surcharge', 'voie', 'sens']],
                body: result.map(donnee => [donnee.id, donnee.longueur, donnee.nombreEssieu]),
            });

            doc.save('table.pdf');
        }
    }

    return (
        <div className="exportation-rapports">

            <h5>Exportation > Génération des Rapports</h5>
            <button onClick={handle}>generate</button>

        </div>
    );
}

export default ExportationRapports;