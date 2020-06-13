import React, {useState} from "react";
import "./ConfigurationUtilisateur.css"
import InputField from "../InputField/InputField";

function ConfigurationUtilisateur() {
   
    const [alert, setAlert] = useState(false);
    const [chosenValues, setChosenValues] = useState({
        nom: "",
        prenom: "",
        service : "",
        direction : "",
        type: "",
        telephone : 0,
        email : "",
        mdp: "",
        cmdp : ""
    });

    function handleChange(e) {
        const {name ,value} = e.target;
        setChosenValues(previousValue => {
            return (
                {
                    ...previousValue,
                    [name] : value
                }
            );
        })
    }


    function handleButtonClick(e) {
        e.preventDefault();
        console.log(chosenValues);
    }

    return (
        <div className="config-container">
            <h5> Configuration > Utilisateurs</h5>
            <div className="input-layout">
                <div className="config-utilisateur-first-column">
                    <InputField description="Nom" name="nom" onChange={handleChange}/>
                    <InputField description="Prénom" name="prenom" onChange={handleChange}/>
                    <InputField description="Service" name="service" onChange={handleChange} />
                    <InputField description="Direction" name="direction" onChange={handleChange} />
                    <select name="type" onChange={handleChange} class="form-control" id="exampleFormControlSelect1">
                        <option >Type</option>
                        <option value="administrateur">Administrateur</option>
                        <option value="Utilisateur">Utilisateur</option>
                    </select>
                </div>
                <div>
                    <InputField name="telephone" onChange={handleChange} placeholder="06xxxxxxxx" description="Télephone" />
                    <input name="email" onChange={handleChange} placeholder="Email: exemple@email.com" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                    <input name="mdp" onChange={handleChange} placeholder="Mot de passe" type="password" class="form-control" id="exampleInputPassword1" />
                    <input name="cmdp" onChange={handleChange} placeholder="Confirmation du mot de passe" type="password" class="form-control" id="exampleInputPassword1" />
                </div>
            </div>
            <div className="add-user">
                <button onClick={handleButtonClick} type="button" class="btn btn-success btn-sm"><i class="far fa-user"></i> Ajouter</button>
                {/* <button type="button" class="btn btn-primary btn-sm"><i class="fas fa-sync-alt"></i> Modifier</button>
                <button type="button" class="btn btn-danger btn-sm"><i class="fas fa-user-times"></i> Supprimer</button> */}
            </div>

        </div>
    );
}

export default ConfigurationUtilisateur;