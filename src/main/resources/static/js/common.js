$(".logout").on('click', function () {
    $.ajax({
        url: "/logout",
        type: "post",
        dateType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            alert(res.msg);
            if (res.status === 200) {
                location.href = '/toLogin';
            }
        }
    })
})

$(".address-book").on('click', function () {
    location.href = '/mail/addressBook';
})
$(".write").on('click', function () {
    location.href = '/mail/writeMessage'
})