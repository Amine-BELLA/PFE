import React from "react";
import "./Header.css";
import { NavLink } from "react-router-dom";
import Logo from "./logo.png";

function Header() {
    return (
        <div className="top">
            <NavLink to="/" ><img src={Logo} alt="Infrasolutions Logo" /></NavLink>
            <div className="lines">
                <hr id="first" />
                <hr id="second"/>
                <hr id="third"/>
            </div>

            <p> Bienvenue sur cette plateforme développée par la société INFRASOLUTIONS, dédiée à la gestion et l'exploitation des données du trafic Marocain</p>
        </div>
    );
}

export default Header;