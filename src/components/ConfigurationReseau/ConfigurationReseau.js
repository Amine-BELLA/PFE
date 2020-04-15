import React from "react";
import "./ConfigurationReseau.css"
import InputField from "../InputField/InputField";

function ConfigurationReseau() {
    return (
        <div className="reseau-container">
            <h5> Configuration > Réseau</h5>
            <div className="reseau-layout">
                <div className="config-reseau-first-column">
                    <InputField description="Région" />
                    <InputField description="Province" />
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Route</option>
                        <option value="route-nationale">Nationale</option>
                        <option value="route-regionale">Régionale</option>
                        <option value="route-provinciale">Provinciale</option>
                    </select>
                </div>
                <div>
                    <InputField description="Référence PK" />
                    <InputField description="Référence Ab S" />
                    <InputField description="Coordonnées GPS" />
                </div>
            </div>
            <div className="ajouter-reseau">
                <button type="button" class="btn btn-success btn-sm"><i class="fas fa-project-diagram"></i> Ajouter Réseau</button>
                <button type="button" class="btn btn-primary btn-sm"><i class="fas fa-sync-alt"></i> Modifier</button>
                <button type="button" class="btn btn-danger btn-sm"><i class="fas fa-minus"></i> Supprimer</button>
            </div>
        </div>

    );
}

export default ConfigurationReseau;