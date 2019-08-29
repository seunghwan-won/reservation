let data;
let nameValid;
let telValid;
let emailValid;
// 예약 데이터 불러오기
(function () {
    const url = new URLSearchParams(document.location.href);
    // const displayInfoId = url.get("http://127.0.0.1:8080/reservation?id");
    const displayInfoId = url.get("reservation?id");
    let ajax = new XMLHttpRequest();
    ajax.addEventListener("load", function () {
        data = JSON.parse(this.response);
    })
    ajax.open("GET", "/api/reservation/" + displayInfoId, true);
    ajax.send();
}());

// 메인 이미지 멈춤기
(function () {
    document.querySelector(".visual_img > li").style.animation = "none";
}());


// #1 설명UI

// #2 티켓선택UI
function Ticket(ticketElement) {
    this.ticketElement = ticketElement;
    this.ticketCount = 0;
    this.maxTicketCount = 4;
    this.minTicketCount = 0;
    this.totalTicketPrice = 0;
    this.ui();
}

Ticket.prototype = {
    increaseTicketCount: function () {
        this.ticketCount = this.ticketCount + 1;
        if (this.ticketCount > this.maxTicketCount)
            return this.ticketCount = this.maxTicketCount;
        else
            return this.ticketCount;
        return this.ticketCount += 1;
    },
    decreaseTicketCount: function () {
        this.ticketCount = this.ticketCount - 1;
        if (this.ticketCount < this.minTicketCount) {
            return this.ticketCount = this.minTicketCount;
        } else
            return this.ticketCount;
    },
    ui: function () {
        this.ticketElement.addEventListener("click", function (event) {
            event.preventDefault();
            const className = event.target.className;
            if (this.isMinus(className))
                this.countControl(this.decreaseTicketCount());
            else if (this.isPlus(className))
                this.countControl(this.increaseTicketCount());
        }.bind(this));
    },
    isMinus: function (className) {
        return className.indexOf("ico_minus3") !== -1;
    },
    isPlus: function (className) {
        return className.indexOf("ico_plus3") !== -1;
    },
    getTicketCount: function () {
        return this.ticketCount;
    },
    countControl: function () {
        const minusButton = this.ticketElement.querySelector(".ico_minus3");
        const input = this.ticketElement.querySelector(".count_control_input");
        const plusButton = this.ticketElement.querySelector(".ico_plus3");
        if (this.getTicketCount() > 0) {
            minusButton.className = "btn_plus_minus spr_book2 ico_minus3";
            input.className = "count_control_input";
        } else if (this.getTicketCount() === 0) {
            minusButton.className = "btn_plus_minus spr_book2 ico_minus3 disabled";
            input.className = "count_control_input disabled";
        }
        this.countControlTemplate();
    },
    countControlTemplate: function () {
        const price = Number(this.ticketElement.querySelector(".price").innerText
            .replace(",", ""));
        this.ticketElement.querySelector(".count_control_input").value = this.getTicketCount();
        let totalPrice = price * this.getTicketCount();
        this.totalTicketPrice = totalPrice;
        if (totalPrice > 0) {
            totalPrice = totalPrice + "";
            totalPrice = totalPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
            this.ticketElement.querySelector(".total_price").innerText = totalPrice;
            this.ticketElement.querySelector(".individual_price").className = "individual_price on_color";
        } else if (totalPrice === 0) {
            this.ticketElement.querySelector(".total_price").innerText = 0;
            this.ticketElement.querySelector(".individual_price").className = "individual_price";
        }
        document.querySelector("#totalCount").innerText = adultTicket.getTicketCount() + babyTicket.getTicketCount() +
            youngTicket.getTicketCount() + setOneTicket.getTicketCount();
    },
    getTotalTicketPrice: function () {
        return this.totalTicketPrice;
    }
}

const ticketElement = document.querySelectorAll(".qty");
const adultTicket = new Ticket(ticketElement[0]);
const babyTicket = new Ticket(ticketElement[1]);
const youngTicket = new Ticket(ticketElement[2]);
const setOneTicket = new Ticket(ticketElement[3]);

// #3 예매자정보UI
function Valid(inputElement) {
    this.reserveValue = "";
    this.inputElment = inputElement;
    this.check();
}

Valid.prototype = {
    check: function () {
        const input = this.inputElment.querySelector("input");
        input.addEventListener("change", function () {
            const flag = this.inputElment.querySelector(".input_name").innerText;
            this.validCheck(flag, input.value);
        }.bind(this));
    },
    validCheck: function (flag, inputValue) {
        switch (flag) {
            case '예매자':
                // if (!this.nameValidCheck(inputValue)) {
                //     this.inputElment.querySelector("#name").value = "";
                //     this.inputElment.querySelector("#name").value = "이름이 너무 길거나 특스문자가 입력되어 있습니다.";
                //
                // }
                this.reserveValue = inputValue;
                break;
            case '연락처':
                if (!this.telNumberValidCheck(inputValue)) {
                    // this.inputElment.querySelector("#tel").value = "";
                    this.inputElment.querySelector("#tel").value = "전화번호 양식이 일치하지 않습니다. 예)010-1234-1234";
                } else
                    this.reserveValue = inputValue;
                break;
            case '이메일':
                if (!this.emailValidCheck(inputValue)) {
                    // this.inputElment.querySelector("#email"). = "";
                    this.inputElment.querySelector("#email").value = "email 양식이 일치하지 않습니다. 예)seunghwan@naver.com";
                } else
                    this.reserveValue = inputValue;
                break;
        }
    },
    nameValidCheck(inputValue) {
        return inputValue.length > 10;
    },
    telNumberValidCheck(inputValue) {
        return inputValue.match(/(\d{3})-(\d{3,4})-(\d{4})/);
    },
    emailValidCheck(inputValue) {
        return inputValue.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    },
    getReserveValue: function () {
        return this.reserveValue;
    }
}

const inputFormElements = document.querySelectorAll(".inline_form");
const reservationNameForm = new Valid(inputFormElements[0]);
const reservationTelNumberForm = new Valid(inputFormElements[1]);
const reservationEmailForm = new Valid(inputFormElements[2]);

// #4 약관UI
function Agreement(agreementElement) {
    this.element = agreementElement;
    this.show();
}

Agreement.prototype = {
    show: function () {
        this.element.querySelector(".btn_agreement").addEventListener("click", function (event) {
            event.preventDefault();
            const text = this.element.querySelector(".btn_text");
            if (text.innerText === "보기") {
                this.element.className = "agreement open";
                text.innerText = "접기";
            } else if (text.innerText === "접기") {
                this.element.className = "agreement";
                text.innerText = "보기";
            }
        }.bind(this));
    }
}
const checkBoxes = document.querySelectorAll(".agreement");
const agreement1 = new Agreement(checkBoxes[1]);
const agreement2 = new Agreement(checkBoxes[2]);

// #5 버튼
function Submit(element) {
    this.element = element;
    this.submitCheck();
    this.submit();
}

Submit.prototype = {
    submitCheck: function () {
        const input = document.querySelector("#chk3");
        input.addEventListener("change", function () {
            if (input.checked)
                this.element.className = "bk_btn_wrap";
            else
                this.element.className = "bk_btn_wrap disable";
        }.bind(this));
    },
    submit: function () {
        this.element.addEventListener("click", function (event) {
            event.preventDefault();
            const ticketData = {};
            ticketData.adultTicketCount = adultTicket.getTicketCount();
            ticketData.babyTicketCount = babyTicket.getTicketCount();
            ticketData.youngTicketCount = youngTicket.getTicketCount();
            ticketData.setTicketCount = setOneTicket.getTicketCount();
            ticketData.totalTicketCount = Number(document.querySelector("#totalCount").innerText);
            ticketData.totalTicketPrice = adultTicket.getTotalTicketPrice() + babyTicket.getTotalTicketPrice()
                + youngTicket.getTotalTicketPrice() + setOneTicket.getTotalTicketPrice();
            ticketData.reservationName = reservationNameForm.getReserveValue();
            ticketData.reservationTelNumber = reservationTelNumberForm.getReserveValue();
            ticketData.reservationEmail = reservationEmailForm.getReserveValue();
            console.table(ticketData);
        }.bind(this));
    }
}
const submitButton = new Submit(document.querySelector(".bk_btn_wrap"));