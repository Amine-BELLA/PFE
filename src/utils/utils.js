export const formatDate = (date) => {
    const year = date.getFullYear();
    let mm = `${date.getMonth()+1}`;
    mm = mm.length == 1 ? '0'+mm : mm;
    let dd = `${date.getDate()}`;
    dd = dd.length == 1 ? '0'+dd : dd;
    return  `${year}-${mm}-${dd}`
}