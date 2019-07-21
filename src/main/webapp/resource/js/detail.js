let btn = document.querySelector(".bk_btn");
btn.addEventListener("click", function () {
    let ajax = new XMLHttpRequest();
    ajax.open("GET", "http://localhost:8080/reservation");
    ajax.send();
});

let openButton = document.querySelector("._open");
let closeButton = document.querySelector("._close");

openButton.addEventListener("click", Element => {
    console.log("click");
    let btn = document.querySelector(".store_details");
    btn.className = "store_details";
    openButton.style.display = "none";
    closeButton.style.display = "";
})

closeButton.addEventListener("click", Element => {
    let btn = document.querySelector(".store_details");
    btn.className = "store_details close3";
    closeButton.style.display = "none";
    openButton.style.display = "";

})