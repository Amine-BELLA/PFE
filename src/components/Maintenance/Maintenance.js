import React from "react";
import "./Maintenance.css";

function Maintenance() {
    return (
        <div className="maintenance">
            <h5> Maintenance > Liste et état des équipements</h5>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Site</th>
                        <th scope="col">Model</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Localisation</th>
                        <th scope="col">Type d'equipement</th>
                        <th scope="col">Dernier Actif</th>
                        <th scope="col">Etat</th>
                    </tr>
                </thead>
            </table>
        </div>
    );


}

export default Maintenance;