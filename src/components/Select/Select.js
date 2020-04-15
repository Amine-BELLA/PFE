import React from "react";
import "./Select.css";

function Select(props) {
    return (
        <div className="my-selection">
            <select class="form-control" id="exampleFormControlSelect1">
                <option value={props.first}>{props.first}</option>
                <option value={props.second}>{props.second}</option>
                <option value={props.third}>{props.third}</option>
                <option value={props.fourth}>{props.fourth}</option>
                <option value={props.fifth}>{props.fifth}</option>
                <option value={props.fifth}>{props.sixth}</option>
            </select>
        </div>

    );
}

export default Select;