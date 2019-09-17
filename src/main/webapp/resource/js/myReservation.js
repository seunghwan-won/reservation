// (function () {
//     let userEmail = location.href;
//     console.log(userEmail);
//     document.querySelector(".viewReservation").innerText = userEmail;
// }());

// function f() {
//     let userEmail = location.href;
//     console.log(userEmail);
//     document.querySelector(".viewReservation").innerText = userEmail;
// }
//
// f();
const template = {
    createConfirmedTemplate() {
        let template = document.querySelector("#confirmed").innerText;
        return Handlebars.compile(template);
    },
    createUsedTemplate() {
        let template = document.querySelector("#used").innerText;
        return Handlebars.compile(template);
    },
    createCancelTemplate() {
        let template = document.querySelector("#cancel").innerText;
        return Handlebars.compile(template);
    }
}
function Summary(element) {
    this.element = element;
    this.reserveData;
    this.load();
    this.getReserveData();
}

Summary.prototype = {
    load() {
        let date = new Date();
        let cancelCount = 0;
        let ingCount = 0;
        let doneCount = 0;
        let cancelResult = "";
        let confirmResult = "";
        let usedResult = "";
        const cancelRoot = document.querySelector(".cancel");
        const usedRoot = document.querySelector("#card_used");
        const data = null;
        const email = document.querySelector(".viewReservation");
        const xhr = new XMLHttpRequest();
        xhr.withCredentials = true;
        const url = "http://localhost:8080/api/myReservation?resrv_email=" + email.innerText;
        xhr.open("GET", url);
        xhr.send(data);
        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                this.reserveData = JSON.parse(this.responseText);
                Object.values(this.reserveData).forEach(Element => {
                    Object.values(Element).forEach(Element2 => {
                        if (Element2.cancelYn === true){
                            cancelCount += 1;
                            const cancelTemplate = template.createCancelTemplate();
                            cancelResult += cancelTemplate(Element2);
                        }
                        else {
                            const reserveDate = new Date(Element2.reservationDate);
                            const diffDay = (reserveDate.getTime() - date.getTime()) / (1000 * 60 * 60 * 24);
                            if(diffDay < 0){
                                doneCount +=1;
                                const usedTemplate = template.createUsedTemplate();
                                usedResult += usedTemplate(Element2);
                            }
                            else {
                                ingCount +=1;
                            }
                        }
                    });
                });
                cancelRoot.innerHTML += cancelResult;
                usedRoot.innerHTML += usedResult;
                const figures = document.querySelectorAll(".figure");
                figures[0].innerText = this.reserveData.size;
                figures[1].innerText = ingCount;
                figures[2].innerText = doneCount;
                figures[3].innerText = cancelCount;

            }
        });
    },
    getReserveData() {
        return this.reserveData;
    }
}

const summary = new Summary(document.querySelector(".my_summary"));