(function () {
    document.querySelector(".rating").addEventListener("click", function () {
        let score = event.target.value;
        if (score !== undefined) {
            score = Number(score);
            init();
            document.querySelectorAll(".rating_rdo").forEach(Element => {
                if (Number(Element.value) <= score)
                    Element.className = "rating_rdo checked";
            });
            let rank = document.querySelector(".star_rank");
            rank.className = "star_rank";
            rank.innerText = score;
        }
    });
}());

function init() {
    document.querySelectorAll(".rating_rdo").forEach(Element => {
        Element.className = "rating_rdo";
    });
}

(function () {
    document.querySelector(".review_contents").addEventListener("click", function () {
        document.querySelector(".review_write_info").style.display = "none";
        document.querySelector(".review_textarea").focus();
    });
}());

(function () {
    document.querySelector(".review_textarea").addEventListener("keyup", countCharacters);

}());
(function () {
    document.querySelector(".review_textarea").addEventListener("focusout", myFocusFunction);
}());

function countCharacters() {
    var textEntered, countRemaining, counter;
    textEntered = document.querySelector(".review_textarea").value;
    var li_str_len = textEntered.length;
    var li_byte = 0;
    var li_len = 0;
    var ls_one_char = "";

    for (var i = 0; i < li_str_len; i++) {
        ls_one_char = textEntered.charAt(i);
        if (escape(ls_one_char).length > 4) {
            li_byte += 2;
        } else
            li_byte += 1;

        if (li_byte <= 400) {
            li_len = i + 1;
        }
    }
    document.querySelector(".guide_review").innerHTML = "<span>" + li_byte + "</span>/400<span>(최소5자이상)</span>"

}

function myFocusFunction() {
    var text = document.querySelector(".review_textarea").value;
    if (text === "") {
        document.querySelector(".review_write_info").style.display = "";
    }
}


(function () {
    const elImage = document.querySelector("#reviewImageFileOpenInput");
    elImage.addEventListener("change", (event) => {
        if (event.target.files.length > 1)
            return;
        const image = event.target.files[0];
        const elImage = document.querySelector(".item_thumb");
        elImage.src = window.URL.createObjectURL(image);
        document.querySelector(".item").style.display = "block";
    });
}());

function validImageType(image) {
    const result = ([
        'image/jpeg', 'image/png'
    ].indexOf(image.type) > -1);
    return result;
}

(function () {
    let deleteButton = document.querySelector(".ico_del");
    deleteButton.addEventListener("click", function (event) {
        event.preventDefault();
        event.target.parentNode.parentNode
    });
}());

// (function () {
//     document.querySelector(".bk_btn").addEventListener("click", function () {
//         let reviewImage = document.querySelector("#reviewImageFileOpenInput").files[0];
//         var formData = new FormData();
//         formData.append("reviewImage", reviewImage, true);
//         var ui = new XMLHttpRequest();
//         ui.open("POST", "/review/upload");
//         ui.setRequestHeader("content-type", "multipart/form-data");
//         console.log(formData)
//         ui.send(formData);
//     });
// }());

var sendButton = document.querySelector(".box_bk_btn");
sendButton.addEventListener("click", sendReview);
function sendReview() {
    let reviewImage = document.querySelector("#reviewImageFileOpenInput").files[0];
    console.log(reviewImage);
    var filedata = new FormData(); // FormData 인스턴스 생성
    filedata.append('reviewImage', reviewImage);
    console.log(filedata);

    var _xml = new XMLHttpRequest();
    _xml.open('POST', '/review/upload', true);
    // _xml.setRequestHeader("Content-Type", "multipart/form-data");
    _xml.send(filedata);
}