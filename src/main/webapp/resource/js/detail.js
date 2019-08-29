// 예매하기
document.querySelector(".bk_btn").addEventListener("click", function () {
    const id = document.querySelector("#displayInfoId").value;
    window.location.href = "http://127.0.0.1:8080/reservation?id=" + id;
});

const sectionOnAndOff = {
    openButton: document.querySelector("._open"),
    closeButton: document.querySelector("._close"),
    section: document.querySelector(".section_store_details"),
    onAndOff: function () {
        this.openButton.addEventListener("click", function () {
            this.openSection(this.section);
        }.bind(this));
        this.closeButton.addEventListener("click", function () {
            this.closeSection(this.section);
        }.bind(this));
    },
    openSection: function (section) {
        section.querySelector(".store_details").className = "store_details";
        this.openButton.style.display = "none";
        this.closeButton.style.display = "";
    },
    closeSection: function (section) {
        section.querySelector(".store_details").className = "store_details close3";
        this.openButton.style.display = "";
        this.closeButton.style.display = "none";
    }
}

const infoTab = {
    detailArea: document.querySelector(".detail_area_wrap"),
    detailLocation: document.querySelector(".detail_location"),
    detail: document.querySelector("._detail"),
    path: document.querySelector("._path"),
    detailWrap: document.querySelector(".detail_area_wrap"),
    pathWrap: document.querySelector(".detail_location"),
    showArea: function () {
        this.detail.addEventListener("click", function () {
            this.detail.className = "item active _detail";
            this.detail.firstElementChild.className = "anchor active";
            this.path.className = "item _path";
            this.path.firstElementChild.className = "anchor";
            this.detailWrap.className = "detail_area_wrap";
            this.pathWrap.className = "detail_location hide";
        }.bind(this));
    },
    showLocation: function () {
        this.path.addEventListener("click", function () {
            this.path.className = "item active _path";
            this.path.firstElementChild.className = "anchor active";
            this.detail.className = "item _detail";
            this.detail.firstElementChild.className = "anchor";
            this.detailWrap.className = "detail_area_wrap hide";
            this.pathWrap.className = "detail_location";
        }.bind(this));
    }
}

sectionOnAndOff.onAndOff();
infoTab.showArea();
infoTab.showLocation();