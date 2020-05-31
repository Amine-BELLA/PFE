import React, { useState } from "react";
import L from 'leaflet';
import { Map, TileLayer, Marker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import data from "./CapteurData";
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

    return (
            <Map style={{position: "relative", top : "4rem"}} center={center} zoom={zoom}>
                <TileLayer
                    attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />

                {data.map(capteur => {
                    const capteurPosition = [capteur.lat, capteur.lng];
                    return (
                        <Marker key={capteur.id} position={capteurPosition} icon={icon}>
                            <Popup>
                                <text> Latitude : {capteur.lat}</text>
                                <br />
                                <text> Longitude : {capteur.lng}</text>
                            </Popup>
                        </Marker>

                    );
                })}

            </Map>

    );
}

export default Cartographie;