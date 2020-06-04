import React, { useState } from "react";
import L from 'leaflet';
import { Map, TileLayer, Marker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import pinIcon from "../../images/pin.png";

function Cartographie() {

    const zoom = 8;
    const center = {
        lat: 33.971588,
        lng: -6.849813
    }
    const icon = L.icon({
        iconUrl: pinIcon,
        iconSize: [20, 20],

    });

    const [data, setData] = useState([]);
    fetch("http://localhost:8080/carte", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => response.json())
        .then(response => {
            const body = response;
            setData(body);
        });

    return (
        <Map style={{ position: "relative", top: "4rem" }} center={center} zoom={zoom}>
            <TileLayer
                attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />

            {data.map(capteur => {
                const capteurPosition = [capteur.lat, capteur.lng];
                return (
                    <Marker key={capteur.coordonneePK} position={capteurPosition} icon={icon}>
                        <Popup>
                            <h6> Informations correspondantes</h6> <br />
                            <text> Latitude : {capteur.lat}</text> <br />
                            <text> Longitude : {capteur.lng}</text> <br />
                            <text> Point Kilométrique : {capteur.coordonneePK}</text> <br />
                            <text> Model : {capteur.model}</text> <br />
                            <text> Mode d'utilisation : {capteur.mode}</text> <br />
                            <text> Numérode de Série : {capteur.numeroSerie}</text> <br />
                            <text> Région : {capteur.region}</text> <br />
                            <text> Province : {capteur.province}</text> <br />
                            <text> Route : {capteur.route}</text> <br />
                        </Popup>
                    </Marker>

                );
            })}

        </Map>

    );
}

export default Cartographie;