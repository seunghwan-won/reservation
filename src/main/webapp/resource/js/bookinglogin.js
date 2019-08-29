let email;

function isEmailValid(email) {
    if (email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))
        return true;
    return false;
}

(function () {
    let emailInput = document.querySelector(".login_input");
    emailInput.addEventListener("change", function () {
        email = emailInput.value;
        if (!isEmailValid(email))
            document.querySelector(".label_form").innerText = "이메일 형식이 올바르지 않습니다.";
        else
            document.querySelector(".label_form").innerText = "예약자 이메일 입력";

    });
}());


(function () {
    document.querySelector(".login_btn").addEventListener("click", function () {
        event.preventDefault();
        if (isEmailValid(email)) {
            console.log("잠깐만");
            document.querySelector("#form1").submit();
        } else
            document.querySelector(".label_form").innerText = "이메일 형식이 올바르지 않습니다.";
    });
}())