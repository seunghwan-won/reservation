// let email;
//
// function isEmailValid(email) {
//     if (email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))
//         return true;
//     return false;
// }
//
// (function () {
//     let emailInput = document.querySelector(".login_input");
//     emailInput.addEventListener("change", function () {
//         email = emailInput.value;
//         if (!isEmailValid(email))
//             document.querySelector(".label_form").innerText = "이메일 형식이 올바르지 않습니다.";
//         else
//             document.querySelector(".label_form").innerText = "예약자 이메일 입력";
//
//     });
// }());
//
//
// (function () {
//     document.querySelector(".login_btn").addEventListener("click", function () {
//         event.preventDefault();
//         if (isEmailValid(email)) {
//             console.log("잠깐만");
//             document.querySelector("#form1").submit();
//         } else
//             document.querySelector(".label_form").innerText = "이메일 형식이 올바르지 않습니다.";
//     });
// }());

// const emailForm = {
//     emailElement: document.querySelector("#resrv_id"),
//     submitButton: document.querySelector(".login_btn"),
//     acticeSubmit: function () {
//         this.submitButton.addEventListener("click", function (event) {
//             event.preventDefault();
//             console.log(this.emailElement.value);
//         });
//     }
// }


function SubmitEmail(element) {
    this.emailElement = element;
    this.emailAddress = "";
    this.emailCheck();
    this.submit();
}

SubmitEmail.prototype = {
    emailRegex: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
    emailCheck: function () {
        const inputForm = this.emailElement.querySelector("#resrv_id");
        inputForm.addEventListener("change", function () {
            if (!this.emailValidCheck(inputForm.value))
                alert("이메일 양식이 올바르지 않습니다.");
            else
                this.emailAddress = inputForm.value;
        }.bind(this));
    },
    submit: function () {
        const submitButton = this.emailElement.querySelector(".login_btn");
        submitButton.addEventListener("click", function (event) {
            event.preventDefault();
            if (this.emailValidCheck(this.emailAddress)) {
                const oReq = new XMLHttpRequest();
                const url = "api/myReservation?resrv_email=" + this.emailAddress;
                oReq.open("GET", url, true);
                oReq.send();
                oReq.addEventListener("load", function () {
                    const reservationData = JSON.parse(this.responseText);
                    if(reservationData.size > 0)
                        document.querySelector("#form1").submit();
                    else
                        alert("예약된 상품이 없습니다.");
                });
            }
        }.bind(this));
    },
    emailValidCheck: function (inputValue) {
        if (inputValue.match(this.emailRegex) !== null)
            return true;
        return false;
    },
}

const emailForm = new SubmitEmail(document.querySelector("#form1"));