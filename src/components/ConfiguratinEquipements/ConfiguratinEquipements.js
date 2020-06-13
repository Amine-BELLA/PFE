import React, { useState } from "react";
import "./ConfiguratinEquipements.css";
import InputField from "../InputField/InputField";

function ConfiguratinEquipements() {

    const [chosenValues, setChosenValues] = useState({
        modele: "",
        serie: "",
        modeUtil: "",
        fournisseur: "",
        lat: 0,
        lng: 0,
        pk: "",
        numbreSite: "",
        serialNumber: "",
        resId: ""
    });

    function handleChange(e) {
        const { name, value } = e.target;
        setChosenValues(previousValue => {
            return (
                {
                    ...previousValue,
                    [name]: value
                }
            );
        })
    }


    function handleButtonClick(e) {
        e.preventDefault();
        console.log(chosenValues);
    }

    return (
        <div className="equipements-container">
            <h5> Configuration > Equipements</h5>
            <div className="equipements-layout">
                <div>
                    <InputField name="resId" onChange={handleChange} description="ID Réseau" />
                    <InputField name="serie" onChange={handleChange} description="NR série" />
                    <select name="modeUtil" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="CB">Comptage par Boucle</option>
                        <option value="CP">Classification Piézo</option>
                        <option value="PP">Pesage Piézo</option>
                    </select>
                </div>

                <div>
                    <InputField name="fournissuer" onChange={handleChange} description="Fournisseur" />
                    <InputField name="numbreSite" onChange={handleChange} description="Nombre du Site" />
                    <InputField name="serialNumber" onChange={handleChange} description="Serial Number" />
                    <select name="modele" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Modèle</option>
                        <option value="UTC-L">UTC-L</option>
                        <option value="EMU3">EMU3</option>
                        <option value="TMU4">TMU4</option>
                    </select>
                    <div className="ajouter-equipement">
                        <button onClick={handleButtonClick} type="button" class="btn btn-success btn-sm"><i class="fas fa-server"></i> Ajouter Equipement</button>
                    </div>
                </div>

                <div>
                    <InputField name="lat" onChange={handleChange} description="Latitude" />
                    <InputField name="lng" onChange={handleChange} description="Longitude" />
                    <InputField name="pk" onChange={handleChange} description="PK" />

                </div>

            </div>

        </div>
    );
}

export default ConfiguratinEquipements;