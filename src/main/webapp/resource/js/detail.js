let btn = document.querySelector(".bk_btn");
btn.addEventListener("click", function () {
    let id = document.querySelector("#displayInfoId").value;
    window.location.href = "http://127.0.0.1:8080/reservation?id=" + id;
});

let openButton = document.querySelector("._open");
let closeButton = document.querySelector("._close");

openButton.addEventListener("click", Element => {
    let btn = document.querySelector(".store_details");
    btn.className = "store_details";
    openButton.style.display = "none";
    closeButton.style.display = "";
});

closeButton.addEventListener("click", Element => {
    let btn = document.querySelector(".store_details");
    btn.className = "store_details close3";
    closeButton.style.display = "none";
    openButton.style.display = "";

});

let infoTab = document.querySelector(".info_tab_lst");
infoTab.addEventListener("click", function () {
    let area = document.querySelector(".detail_area_wrap");
    let location = document.querySelector(".detail_location");
    let detail = document.querySelector("._detail").firstElementChild;
    let path = document.querySelector("._path").firstElementChild;
    if (event.target.innerText === "상세정보") {
        area.className = "detail_area_wrap";
        location.className = "detail_location hide";
        detail.className = "anchor active";
        path.className = "anchor";
    } else if (event.target.innerText === "오시는길") {
        area.className = "detail_area_wrap hide";
        location.className = "detail_location";
        detail.className = "anchor";
        path.className = "anchor active";
    }
});
