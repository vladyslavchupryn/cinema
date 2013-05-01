function peekValidators() {
    $('.date-in-milli').datepicker({
        dateFormat: '@',
        showAnim: 'slideDown',
        changeMonth: true,
        changeYear: true
    });

    $(".decimal").numeric();
    $(".positive-decimal").numeric({
        negative: false
    }, function () {
        alert("No negative values");
        this.value = "";
        this.focus();
    });

    $(".integer").numeric(false, function () {
        alert("Integers only");
        this.value = "";
        this.focus();
    });
    $(".positive-integer").numeric({
        decimal: false,
        negative: false
    }, function () {
        alert("Positive integers only");
        this.value = "";
        this.focus();
    });
}
