import React, { useState } from "react";
import "./ExportationRapports.css";
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';
import { Line } from "react-chartjs-2";
import html2canvas from "html2canvas";
const pdfConverter = require("jspdf");


function ExportationRapports() {

    const [backEnd, setBackEnd] = useState({
        result: [],
        loading: true
    });

    let { result, loading } = backEnd;

    function handle() {
        fetch('http://localhost:8080/tempsReel', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({}),
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

            doc.addPage();
            doc.text(20, 20, 'Do you like that?');
            doc.text(20, 30, 'Hello world!');
            doc.text(20, 40, 'This is client-side Javascript, pumping out a PDF.');
            doc.save('table.pdf');
        }
    }

    return (
        <div>
            <button> generate </button>
        </div>
    )

}

export default ExportationRapports;









 // function handle() {
    //     fetch('http://localhost:8080/tempsReel', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(chosenValues),
    //     })
    //         .then(response => response.json())
    //         .then(response => {
    //             const body = response;
    //             setBackEnd({
    //                 result: body,
    //                 loading: false
    //             });
    //         })

    //     if (!loading) {
    //         const doc = new jsPDF();
    //         doc.autoTable({
    //             theme: 'grid',
    //             head: [['Id', 'Longueur', 'Nombre Essieu', 'date', 'time', 'poids total', 'gap', 'classe', 'vitesse', 'headway', 'surcharge', 'voie', 'sens']],
    //             body: result.map(donnee => [donnee.id, donnee.longueur, donnee.nombreEssieu]),
    //         });

    //         doc.addPage();
    //         doc.text(20, 20, 'Do you like that?');
    //         doc.text(20, 30, 'Hello world!');
    //         doc.text(20, 40, 'This is client-side Javascript, pumping out a PDF.');
    //         doc.save('table.pdf');
    //     }
    // }




    // Include Graphs into PDF Trial


    // function ExportationRapports() {

    //     const myData = {
    //         alpha: 4,
    //         c: 1.5,
    //         debutTime: "1999-06-03T00:22:00",
    //         equipId: 4,
    //         finTime: "2030-06-03T05:22:00",
    //         i: 0.04,
    //         modeUtil: "CB",
    //         n: 10,
    //         resId: 3,
    //         yearD: 2011
    //     }
    //     //Pourcentage PL
    //     const [pourcentagePl, setPourcentagePl] = useState({
    //         resultPourcentagePl: [],
    //         loadingPourcentagePl: true
    //     });
    //     let { resultPourcentagePl, loadingPourcentagePl } = pourcentagePl;


    //     //Pourcentage Pl
    //     fetch("http://localhost:8080/pourcentagePl", {
    //         method: "POST",
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(myData),
    //     })
    //         .then(response => response.json())
    //         .then(response => {
    //             const body = response;
    //             setPourcentagePl({
    //                 resultPourcentagePl: body,
    //                 loadingPourcentagePl: false
    //             });
    //         })

    //     function div2PDF(e) {
    //         const but = e.target;
    //         but.style.display = "none";
    //         let input = window.document.getElementsByClassName("div2PDF")[0];
    //         html2canvas(input).then(canvas => {
    //             var img = canvas.toDataURL("image/jpeg");
    //             var doc = new jsPDF();
    //             doc.setFontSize(100);
    //             doc.addImage(img, "jpeg", 10, 0, 100, 60);
    //             doc.save("chart.pdf");
    //             but.style.display = "block";

    //             // var img = new Image();
    //             // img.src = canvas.toDataURL("image/jpeg");
    //             // var width = doc.internal.pageSize.getWidth();
    //             // var height = doc.internal.pageSize.getHeight();
    //         });
    //     };


    //     return (
    //         <div>
    //             {!loadingPourcentagePl && <div className="div2PDF">
    //                 <Line
    //                     data={{
    //                         labels: ["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
    //                             "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
    //                             "23:00"],
    //                         datasets: [{
    //                             data: resultPourcentagePl,
    //                             label: "Pourcentage des poids lourds",
    //                             borderColor: "#3e95cd",
    //                             fill: false
    //                         }]
    //                     }
    //                     }
    //                     options={
    //                         {
    //                             title: {
    //                                 display: true,
    //                                 text: 'Titre : Répartition Horaire de la valeur moyenne du pourcentage des poids lourds'
    //                             }
    //                         }
    //                     }
    //                 />

    //             </div>}

    //             <div>
    //                 <button onClick={div2PDF}>Export 2 PDF</button>
    //             </div>
    //         </div>
    //     );
    // }

    // export default ExportationRapports;