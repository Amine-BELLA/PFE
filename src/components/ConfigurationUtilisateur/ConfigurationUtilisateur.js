import React, {useState} from "react";
import "./ConfigurationUtilisateur.css"
import InputField from "../InputField/InputField";

function ConfigurationUtilisateur() {
    const [user, setUser] = useState({
        firstName: '',
        lastName: '',
    });

    function handleChange(e) {
        e.preventDefault();
        console.log(e);
        const {name, value} = e.target;
        let _user = {
            ...user,
            [name]: value,
        }
        console.log(_user);
        setUser(_user);
    }
    return (
        <div className="config-container">
            <h5> Configuration > Utilisateurs</h5>
            <div className="input-layout">
                <div className="config-utilisateur-first-column">
                    <InputField description="Nom" name="firstName" onChange={handleChange}/>
                    <InputField description="Prénom" name="lastName" onChange={handleChange}/>
                    <InputField description="Service" />
                    <InputField description="Direction" />
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option >Type</option>
                        <option value="administrateur">Administrateur</option>
                        <option value="Utilisateur">Utilisateur</option>
                    </select>
                </div>
                <div>
                    <InputField description="Télephone" />
                    <InputField description="Email" />
                    <InputField description="Mot de passe" />
                    <InputField description="Confirmation du mot de passe" />
                </div>
            </div>
            <div className="add-user">
                <button type="button" class="btn btn-success btn-sm"><i class="far fa-user"></i> Ajouter</button>
                <button type="button" class="btn btn-primary btn-sm"><i class="fas fa-sync-alt"></i> Modifier</button>
                <button type="button" class="btn btn-danger btn-sm"><i class="fas fa-user-times"></i> Supprimer</button>
            </div>

        </div>
    );
}

export default ConfigurationUtilisateur;