import React from "react";
import "./Footer.css";
import Logo from "../../images/logo.png";

function Footer() {
    return (
        <div className="footer-container">
            <div className="my-footer">
                <text className="email">Email: info@infrasolutions.ma</text>
                <text className="telephone">Tél/Fax:  +212 5 37 61 85 43</text>
                <text className="adresse">Adresse: appartement n86 3ème étage avenue moulay idriss 1, Temara, Maroc</text>
            </div>
        </div>

    );
}

export default Footer;