let ajax;

window.addEventListener("load", function () {
    ajax = new XMLHttpRequest();
    ajax.addEventListener("load", function () {
        let data = JSON.parse(this.response);
        makeProductImage(data);
    });
    ajax.open("get", "http://localhost:8080/api/products");
    ajax.send();
});

window.addEventListener("load", () => {
    ajax = new XMLHttpRequest();

    ajax.addEventListener("load", function () {
        let data = JSON.parse(this.response);
        makePromotionImage(data.items);
    });
    ajax.open("get", "http://localhost:8080/api/promotions");
    ajax.send();
})

function makePromotionImage(data) {
    let template = document.querySelector("#promotionItem").innerHTML;
    let promotionList = document.querySelector(".visual_img");
    let result = "";
    let keys = Object.keys(data);
    keys.forEach(element => {
        result += template.replace("{productId}", data[element].productId)
            .replace("{productImageId}", data[element].promotionId);
    });
    promotionList.innerHTML = result;
}

function makeProductImage(data) {
    let template = document.querySelector("#itemList").innerHTML;
    let itemList = document.querySelectorAll(".lst_event_box");
    let result1 = "";
    let result2 = "";
    document.querySelector(".pink").innerHTML = data.totalCount;
    data.items.forEach(function (v, i) {
        if (i % 2 == 0) {
            result1 += template.replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{placeName}", v.placeName)
                .replace("{content}", v.productContent);
        } else {
            result2 += template.replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{placeName}", v.placeName)
                .replace("{content}", v.productContent);
        }

    });

    itemList[0].innerHTML = result1;
    itemList[1].innerHTML = result2;
}

let tab = document.querySelector(".section_event_tab");
tab.addEventListener("click", function (v) {
    let categoryId;
    if (event.target.tagName === "SPAN") {
        document.querySelector(".active").className = "anchor";
        categoryId = getCategotyId(event.target.innerHTML);
        let active = event.target.parentNode.className;
        if (active === "anchor")
            event.target.parentNode.className = "anchor active"
    }
    ajax = new XMLHttpRequest();
    ajax.addEventListener("load", function () {
        let data = JSON.parse(this.response);
        makeProductImage(data);
    });
    ajax.open("get", "http://localhost:8080/api/products" + "?categoryId=" + categoryId);
    ajax.send();
})

function getCategotyId(event) {
    switch (event) {
        case "전체리스트":
            return 0;
        case "전시":
            return 1;
        case "뮤지컬":
            return 2;
        case "콘서트":
            return 3;
        case "클래식":
            return 4;
        case "연극":
            return 5;
    }
}

var btn = document.querySelector(".btn");
btn.addEventListener("click", function (v) {
    let categoryId = document.querySelector(".active").parentElement.getAttribute("data-categoryJoinProduct");
    let itemList = document.querySelectorAll(".item_book");
    let start = itemList.length;
    ajax = new XMLHttpRequest();
    ajax.addEventListener("load", function (v) {
        let data = JSON.parse(this.response);
        moreProduct(data);
    });
    ajax.open("GET", "http://localhost:8080/api/products?start=" + start + "&categoryId=" + categoryId);
    ajax.send();
});

function moreProduct(data) {
    let template = document.querySelector("#itemList").innerHTML;
    let itemList = document.querySelectorAll(".lst_event_box");
    let result1 = "";
    let result2 = "";
    document.querySelector(".pink").innerHTML = data.totalCount;
    data.items.forEach(function (v, i) {
        if (i % 2 == 0) {
            result1 += template.replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{placeName}", v.placeName)
                .replace("{content}", v.productContent);
        } else {
            result2 += template.replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{id}", v.productId)
                .replace("{description}", v.productDescription)
                .replace("{placeName}", v.placeName)
                .replace("{content}", v.productContent);
        }

    });
    itemList[0].innerHTML += result1;
    itemList[1].innerHTML += result2;
}