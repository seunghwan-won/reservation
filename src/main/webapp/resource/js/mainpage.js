let template = {
    createPromotionItemTemplate() {
        let template = document.querySelector("#promotionItem").innerText;
        return Handlebars.compile(template);
    },
    createItemListTemplate() {
        let template = document.querySelector("#itemList").innerText;
        return Handlebars.compile(template);
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const oReq = new XMLHttpRequest();

    oReq.open("get", "http://localhost:8080/api/products");
    oReq.send();
    oReq.onload = function () {
        if (oReq.status == 200) {
            const data = JSON.parse(this.response);
            makeProductImage(data, true);
        } else alert("전송 실패");

    }
});

document.addEventListener("DOMContentLoaded", () => {
    const oReq = new XMLHttpRequest();

    oReq.open("get", "http://localhost:8080/api/promotions");
    oReq.send();
    oReq.onload = function () {
        if (oReq.status == 200) {
            const data = JSON.parse(this.response);
            makePromotionImage(data.items);
        } else alert("전송 실패");
    }
});

function makePromotionImage(data) {
    let promotionImageTemplate = template.createPromotionItemTemplate();
    let promotionList = document.querySelector(".visual_img");
    let result = "";
    data.forEach(Element => {
        result += promotionImageTemplate(Element);
    })
    promotionList.innerHTML = result;
}

function makeProductImage(data, initialize) {
    let ProductImageTemplate = template.createItemListTemplate();
    let itemList = document.querySelectorAll(".lst_event_box");
    let leftSide = "";
    let rightSide = "";
    if(!initialize) {
        leftSide = itemList[0].innerHTML;
        rightSide = itemList[1].innerHTML;
    }
    let totalCount = data.totalCount;
    document.querySelector(".pink").innerHTML = data.totalCount + "개";
    data.items.forEach(function (v, i) {
        if (i % 2 == 0) {
            leftSide += ProductImageTemplate(v);
        } else {
            rightSide += ProductImageTemplate(v);
        }
    });
    itemList[0].innerHTML = leftSide;
    itemList[1].innerHTML = rightSide;
    if (presentProductCount(itemList) === totalCount)
        btn.style.display = "none";
}


const tab = document.querySelector(".section_event_tab");
tab.addEventListener("click", function (v) {
    let categoryList = ["전체리스트", "전시", "뮤지컬", "콘서트", "클래식", "연극"];
    let categoryId;
    if (event.target.tagName === "SPAN") {
        document.querySelector(".active").className = "anchor";
        categoryId = categoryList.indexOf(event.target.innerHTML);
        const active = event.target.parentNode.className;
        if (active === "anchor")
            event.target.parentNode.className = "anchor active"
    }
    const oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
        const data = JSON.parse(this.response);
        makeProductImage(data, true);
    });
    oReq.open("get", "http://localhost:8080/api/products" + "?categoryId=" + categoryId);
    oReq.send();
    btn.style.display = "inline-block";
})

const btn = document.querySelector(".btn");
btn.addEventListener("click", function (v) {
    let categoryId = document.querySelector(".active").parentElement.getAttribute("data-categoryJoinProduct");
    let itemList = document.querySelectorAll(".item_book");
    let start = itemList.length;
    const oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function (v) {
        const data = JSON.parse(this.response);
        makeProductImage(data, false);
    });
    oReq.open("GET", "http://localhost:8080/api/products?start=" + start + "&categoryId=" + categoryId);
    oReq.send();
});


function presentProductCount(node) {
    let count = 0;
    node.forEach(Element => {
        count += Element.childElementCount
    });
    return count;
}
