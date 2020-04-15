import React from "react";
import "./ConfiguratinEquipements.css";
import InputField from "../InputField/InputField";

function ConfiguratinEquipements() {
    return (
        <div className="equipements-container">
            <h5> Configuration > Equipements</h5>
            <div className="equipements-layout">
                <div>
                    <InputField description="ID" />
                    <InputField description="NR série" />
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Mode d'utilisation</option>
                        <option value="comptage-boucle">Comptage par Boucle</option>
                        <option value="classification-piezo">Classification Piézo</option>
                        <option value="pesage-piezo">Pesage Piézo</option>
                    </select>
                </div>

                <div>
                    <InputField description="Fournisseur" />
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Modèle</option>
                        <option value="UTC-L">UTC-L</option>
                        <option value="EMU3">EMU3</option>
                        <option value="TMU4">TMU4</option>
                    </select>
                </div>

            </div>
            <div className="ajouter-equipement">
                <button type="button" class="btn btn-success btn-sm"><i class="fas fa-server"></i> Ajouter Equipement</button>
                <button type="button" class="btn btn-primary btn-sm"><i class="fas fa-sync-alt"></i> Modifier</button>
                <button type="button" class="btn btn-danger btn-sm"><i class="fas fa-minus"></i> Supprimer</button>
            </div>
        </div>
    );
}

export default ConfiguratinEquipements;