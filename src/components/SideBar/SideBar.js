import React from "react";
import "./SideBar.css";
import { NavLink } from "react-router-dom";

function SideBar() {
    return (
        <div className="my-sidebar">

            <div className="item">
                <NavLink to="/cartographie" className="my-label"><i class="fas fa-map-marked-alt"></i> <label className="my-label">Cartographie</label></NavLink>
            </div>


            <div className="item">
                <input type="checkbox" id="A" />
                <label className="my-label" for="A"><i class="fas fa-user-cog"></i> Configuration <i id="arrow" class="fas fa-caret-right"></i></label>
                <ul>
                    <li><NavLink to="/configuration-utilisateurs" className="my-link" >  Utilisateurs</NavLink> </li>
                    <li><NavLink to="/configuration-reseau" className="my-link">  Réseau</NavLink> </li>
                    <li><NavLink to="/configuration-equipements" className="my-link">  Equipements</NavLink> </li>
                </ul>
            </div>

            <div className="item">
                <input type="checkbox" id="B" />
                <label className="my-label" for="B"><i class="fas fa-eye"></i> Visualisation <i class="fas fa-caret-right"></i></label>
                <ul>
                    <li><NavLink to="/visualisation-temps-reel" className="my-link">  Visualisation en temps réel</NavLink> </li>
                    <li><NavLink to="/visualisation-donnees" className="my-link">  Visualisation des données</NavLink> </li>
                    <li><NavLink to="/suivi-etat-chaussee" className="my-link">  Suivi de l'état de chaussée</NavLink> </li>
                </ul>
            </div>

            <div className="item">
                <input type="checkbox" id="C" />
                <label className="my-label" for="C"><i class="fas fa-share-square"></i> Exportation <i class="fas fa-caret-right"></i></label>
                <ul>
                    <li><NavLink to="/generation-rapport" className="my-link">  Génération des rapports</NavLink> </li>
                    <li><NavLink to="/exportation-donnees" className="my-link">  Exportation des données</NavLink> </li>
                </ul>
            </div>

            <div className="item">
                <input type="checkbox" id="D" />
                <label className="my-label" for="D"><i class="fas fa-cogs"></i> Maintenance <i class="fas fa-caret-right"></i></label>
                <ul>
                    <li><NavLink to="/liste-etat-equipements" className="my-link" >  Liste et état des équipements</NavLink> </li>
                </ul>
            </div>

        </div>
    );
}

export default SideBar;