import React, { useState } from "react";

function Pagination(props) {
    var pageNumbers = [];

    for (var i = 1; i <= Math.ceil(props.totalElements / props.elementsPerPage); i++) {
        pageNumbers.push(i);
    }

   

    return (
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                {pageNumbers.map(number => (
                    <li key={number} class="page-item">
                        <a onClick={() => props.paginate(number)} href='#' class="page-link">
                            {number}
                        </a>
                    </li>
                ))}
            </ul>
        </nav>
    );
}

export default Pagination;