function getByteLength(s, b, i, c) {
    // for (bit = index = 0; content.charCodeAt(index++); bit += count >> 11 ? 3 : count >> 7 ? 2 : 1);
    for (b = i = 0; c = s.charCodeAt(i++); b += (c == 10) ? 2 : ((c >> 7) ? 2 : 1)) ;
    document.querySelector(".guide_review").innerHTML = "<span>" + b + "</span>/400<span>(최소5자이상)</span>"
}

function validImageType(image) {
    const result = ([
        'image/jpeg', 'image/png'
    ].indexOf(image.type) > -1);
    return result;
}

function sendReview() {
    let reviewImage = document.querySelector("#reviewImageFileOpenInput").files[0];
    var urlAdd = decodeURIComponent(location.href);
    // url이 encodeURIComponent 로 인코딩 되었을때는 다시 디코딩 해준다.
    urlAdd = decodeURIComponent(urlAdd);
    const test = urlAdd.split("/");
    console.log(urlAdd);
    console.log(test


        .length);
    test.forEach(Element => {
        console.log(Element);
    });
    const data = new FormData();
    data.append('reviewImage', reviewImage);

    const xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    const productId = Number(test[5]);
    const reservationInfoId = Number(test[4]);
    const score = Number(document.querySelector(".star_rank").innerText);
    const comment = document.querySelector(".review_textarea").value;
    let url = "http://localhost:8080/review/upload?" + "comment=" + comment + "&productId=" + productId + "&score=" + score + "&reservationInfoId=" + reservationInfoId;
    xhr.addEventListener("readystatechange", function () {
        // if (this.readyState === 4) {
        //     window.location.href = 'http://localhost:8080/myReservation';
        // }
    });

    xhr.open('POST', url);
    xhr.send(data);
}

function Rating(element) {
    this.element = element;
    this.currentScore = 0;
    this.getScore();
}

Rating.prototype = {
    getScore() {
        this.element.addEventListener("click", function (event) {
            const score = Number(event.target.value);
            if ((score >= 0) && (score <= 5)) {
                this.currentScore = score;
                this.test();
                this.star();
                this.score();
            }
        }.bind(this));
    },
    test() {
        this.element.querySelectorAll(".rating_rdo").forEach(element => {
            if (Number(element.value) <= this.currentScore)
                element.checked = "checked";
            else if (Number(element.value) > this.currentScore)
                element.checked = "";
        });
    },
    star() {
        const rank = this.element.querySelector(".star_rank");
        if (this.currentScore !== 0) {
            rank.className = "star_rank";
        } else {
            rank.className = "star_rank gray_star";
        }
    },
    score() {
        this.element.querySelector(".star_rank").innerText = this.currentScore;
    }
}

const rate = new Rating(document.querySelector(".rating"));

function Write(element) {
    this.element = element;
    this.focusEvent();
    this.blurEvent();
    this.typing();
}

Write.prototype = {
    focusEvent() {
        this.element.addEventListener("click", function (event) {
            this.element.querySelector(".review_write_info").style.display = "none";
            this.element.querySelector(".review_textarea").focus();
        }.bind(this));
    },
    blurEvent() {
        this.element.querySelector(".review_textarea").addEventListener("blur", function () {
            const text = document.querySelector(".review_textarea").value;
            if (text === "") {
                document.querySelector(".review_write_info").style.display = "";
            }
        }.bind(this));
    },
    typing() {
        this.element.querySelector(".review_textarea").addEventListener("keyup", function () {
            getByteLength(this.element.querySelector(".review_textarea").value);
        }.bind(this));
    }
}

const reviewWrite = new Write(document.querySelector(".review_contents"));

function FileThumbnail(element) {
    this.element = element;
    this.createThumbnail();
}

FileThumbnail.prototype = {
    createThumbnail: function () {
        this.element.addEventListener("change", function (event) {
            if (event.target.files.length > 1)
                return;
            let image = 0;
            if (validImageType(event.target.files[0]))
                image = event.target.files[0];
            const elImage = document.querySelector(".item_thumb");
            elImage.src = window.URL.createObjectURL(image);
            document.querySelector(".item").style.display = "block";
        }.bind(this));
    }
}

const thumbnail = new FileThumbnail(document.querySelector("#reviewImageFileOpenInput"));

function SendReview(element) {
    this.element = element;
    this.count;
    this.image;
    this.send();
}

SendReview.prototype = {
    send: function () {
        this.element.addEventListener("click", function () {
            sendReview();
        }.bind(this));
    }
}

const button = new SendReview(document.querySelector(".box_bk_btn"));