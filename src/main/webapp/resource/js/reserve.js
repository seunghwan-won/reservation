let data;
let nameValid;
let telValid;
let emailValid;
// 예약 데이터 불러오기
(function () {
    var para = document.location.href.split("?");
    let ajax = new XMLHttpRequest();
    ajax.addEventListener("load", function () {
        data = JSON.parse(this.response);

    })
    ajax.open("GET", "http://localhost:8080/api/reservation/1")
    ajax.send();
}());

// 메인 이미지 멈춤기
(function () {
    document.querySelector(".visual_img > li").style.animation = "none";
}());

// 티켓 이벤트
(function () {
    document.querySelector(".ticket_body").addEventListener("click", function () {
        event.preventDefault();
        let target = event.target;
        if (target.className.indexOf("btn_plus_minus") !== -1) {

            if (target.title === "더하기") {
                // 더하기로 발생되는 이벤트 실행
                /*
                    카운트값을 1증가 시키기
                    금액 변화
                    처음에 값이 disable class들  없애기
                        금액 클래스 on_color주기
                 */
                // increaseCount(target);
                let presentValue = Number(target.previousSibling.previousSibling.value);
                let nextValue = presentValue += 1;

                let html = document.querySelector("#tiketCount").innerHTML;
                html = html.replace("{count}", nextValue);
                target.previousSibling.previousSibling.value = nextValue;
                let parent = target.parentNode
                let replaceNode = target.parentNode.children[1];
                let element = document.createElement("input");
                element.type = "tel";
                element.setAttribute("class", "count_control_input");
                element.setAttribute("value", nextValue);
                element.setAttribute("readonly", "");
                element.title = "수량";
                target.parentNode.replaceChild(element, replaceNode);


                let priceType = target.parentNode.parentNode.parentNode.querySelector(".product_amount").innerText;
                let price = decidePrice(priceType);
                let resultPrice = "" + nextValue * price;
                resultPrice = resultPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                target.parentNode.parentNode.parentNode.querySelector(".total_price").innerText = resultPrice;
                let color = target.parentNode.parentNode.parentNode.querySelector(".individual_price").className;

                let test = target.parentNode.querySelector(".count_control_input");
                if (test.value > 0) {
                    target.parentNode.querySelector(".ico_minus3").className = "btn_plus_minus spr_book2 ico_minus3";
                }

                if (color.indexOf("on_color") === -1)
                    target.parentNode.parentNode.parentNode.querySelector(".individual_price").className = "individual_price on_color"

            } else if (target.title === "빼기") {
                // 빼기로 발생되는 이벤트 실행
                /*
                    카운트값을 1증가 시키기
                    금액 변화
                    최종값이 0이 되면 disable class 추가하기
                        금액 클래스 on_color 빼기
                 */
                let presentValue = Number(target.nextSibling.nextSibling.value);
                if (presentValue > 0) {
                    let nextValue = presentValue -= 1;
                    target.nextSibling.nextSibling.value = nextValue;

                    let html = document.querySelector("#tiketCount").innerHTML;
                    html = html.replace("{count}", nextValue);
                    target.nextSibling.nextSibling.value = nextValue;
                    let parent = target.parentNode;
                    let replaceNode = target.parentNode.children[1];
                    let element = document.createElement("input");
                    element.type = "tel";
                    element.setAttribute("class", "count_control_input");
                    element.setAttribute("value", nextValue);
                    element.setAttribute("readonly", "");
                    element.title = "수량";
                    target.parentNode.replaceChild(element, replaceNode);

                    let priceType = target.parentNode.parentNode.parentNode.querySelector(".product_amount").innerText;
                    let price = decidePrice(priceType);
                    let resultPrice = "" + nextValue * price;
                    resultPrice = resultPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                    target.parentNode.parentNode.parentNode.querySelector(".total_price").innerText = resultPrice;

                    let test = target.parentNode.querySelector(".count_control_input");
                    if (Number(test.value) === 0) {
                        target.parentNode.querySelector(".ico_minus3").className = "btn_plus_minus spr_book2 ico_minus3 disabled";
                        target.parentNode.querySelector(".count_control_input").className = "count_control_input disabled";
                        target.parentNode.parentNode.parentNode.querySelector(".individual_price").className = "individual_price"
                    }


                }


            }
            ableReservation();
        }
        let ticketCountList = document.querySelectorAll(".count_control_input");
        let totalCount = 0;
        ticketCountList.forEach(Element => {
            totalCount += Number(Element.value);
        });
        document.querySelector("#totalCount").innerText = totalCount;
    });
}());

(function () {
    document.querySelector("#name").addEventListener("change", function () {
        let name = document.querySelector("#name").value;
        if (name.value !== '')
            nameValid = true;
        else nameValid = false;
        ableReservation();
    });
}());


(function () {
    document.querySelector("#tel").addEventListener("change", function () {
        let tel = document.querySelector("#tel").value;
        if (tel !== '')
            telValid = true;
        else telValid = false;
        if (!telReg(tel)) {
            telValid = telReg(tel);
            alert("전화번호 양식이 틀렸습니다.\n ex) 010-0000-0000");
        }
        ableReservation()
    });
}());

(function () {
    document.querySelector("#email").addEventListener("change", function () {
        let email = document.querySelector("#email").value;
        if (email != '')
            emailValid = true
        else emailValid = false;
        if (!emailReg(email)) {
            emailValid = emailReg(tel);
            alert("email 양식이 틀렸습니다.\n ex) id@domain.com");
        }
        ableReservation();
    });
}());

(function () {
    document.querySelector(".section_booking_agreement").addEventListener("click", function () {
        event.preventDefault();
        let target = event.target;
        if (target.innerText === "보기") {
            let agreement = target.parentNode.parentNode;
            agreement.className = "agreement open";
            agreement.querySelector(".btn_text").innerText = "접기";
        } else if (target.innerText === "접기") {
            let agreement = target.parentNode.parentNode;
            agreement.className = "agreement";
            agreement.querySelector(".btn_text").innerText = "보기";
        }

        if (target.className.indexOf("chk_txt_label") !== -1) {
            let checkbox = target.parentNode.querySelector("#chk3");
            if (checkbox.checked)
                checkbox.removeAttribute("checked");
            else {
                checkbox.setAttribute("checked", '');
            }
            ableReservation();
        }

    });
}());

function decidePrice(type) {
    switch (type) {
        case '성인':
            return 10200;
        case '유아':
            return 6800;
        case '세트1':
            return 20000;
        case '청소년':
            return 8500;

    }
}

function telReg(tel) {
    if (tel.match(/(\d{3})-(\d{3,4})-(\d{4})/))
        return true;
    return false;
}

function emailReg(email) {
    if (email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))
        return true;
    return false;
}

function ableReservation() {
    let totalCount = Number(document.querySelector("#totalCount").innerText);
    let checkbox = document.querySelector("#chk3");
    if ((totalCount > 0) && nameValid && emailValid && telValid && checkbox.checked)
        document.querySelector(".bk_btn_wrap").className = "bk_btn_wrap";
    else
        document.querySelector(".bk_btn_wrap").className = "bk_btn_wrap disable";

}
