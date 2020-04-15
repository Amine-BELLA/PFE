import React from 'react';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import "./components/Header/Header";
import Header from './components/Header/Header';
import SideBar from "./components/SideBar/SideBar";
import Footer from "./components/Footer/Footer";
import ConfigurationUtilisateur from "./components/ConfigurationUtilisateur/ConfigurationUtilisateur";
import ConfigurationReseau from "./components/ConfigurationReseau/ConfigurationReseau";
import ConfiguratinEquipements from "./components/ConfiguratinEquipements/ConfiguratinEquipements";
import VisualisationDonnees from "./components/VisualisationDonnees/VisualisationDonnees";
import EtatChaussee from "./components/EtatChaussee/EtatChaussee";
import ExportationRapports from "./components/ExportationRapports/ExportationRapports";
import ExportationDonnees from "./components/ExportationDonnees/ExportationDonnees";
import Maintenance from "./components/Maintenance/Maintenance";

function App() {
  return (
    <Router className="my-app">
      <Header />
      <div className="layout">
      <SideBar />
      <Route path="/configuration-utilisateurs" exact component={ConfigurationUtilisateur} />
      <Route path="/configuration-reseau" exact component={ConfigurationReseau} />
      <Route path="/configuration-equipements" exact component={ConfiguratinEquipements} />
      <Route path="/visualisation-donnees" component={VisualisationDonnees} />
      <Route path="/suivi-etat-chaussee" component={EtatChaussee} />
      <Route path="/generation-rapport" component={ExportationRapports} />
      <Route path="/exportation-donnees" component={ExportationDonnees} />
      <Route path="/liste-etat-equipements" component={Maintenance} />
      </div>
      <Footer />
    </Router>
  );
}

export default App;
