(function () {
    let userEmail = location.href;
    console.log(userEmail);
    document.querySelector(".viewReservation").innerText = userEmail;
}());