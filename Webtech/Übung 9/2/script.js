let daten = [
    { lang: "Python", rating: 9.704 },
    { lang: "JavaScript", rating: 2.451 },
    { lang: "C", rating: 15.773 },
    { lang: "Java", rating: 16.896 },
    { lang: "Visual Basic .NET", rating: 5.287 },
    { lang: "C++", rating: 5.574 },
];

    // Erstellt ein td-Element mit dem gegebenen
    // Textinhalt
let createTd = function(content) {
    let td = document.createElement("td");
    td.textContent = content;
    return td;
};
    daten.sort(function(a, b){return b.rating - a.rating})

    let body = document.getElementsByTagName("tbody");

    for (let i = 0; i < daten.length; i++) {
        let tr = document.createElement("tr");
        let td;

        td = createTd(i+1);
        tr.appendChild(td);
        td = createTd(daten[i].lang);
        tr.appendChild(td);
        td = createTd(daten[i].rating);
        tr.appendChild(td);
        body[0].appendChild(tr);
    }