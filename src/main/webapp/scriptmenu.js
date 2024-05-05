document.querySelector(".main").addEventListener("click", function() {
    var buttonContainer = document.querySelector(".button-container");
    var sortIcons = document.querySelectorAll(".fa-sort-down, .fa-sort-up");

    buttonContainer.classList.toggle("hide");

    sortIcons.forEach(function(icon) {
        if (icon.classList.contains("fa-sort-down")) {
            icon.classList.remove("fa-sort-down");
            icon.classList.add("fa-sort-up");
        } else {
            icon.classList.remove("fa-sort-up");
            icon.classList.add("fa-sort-down");
        }
    });
});
