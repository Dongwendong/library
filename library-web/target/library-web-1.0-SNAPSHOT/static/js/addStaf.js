$(function () {
    $("#btn").on("click",function () {
        var formData = new FormData(document.getElementById('for1'));
        alert("ok")
        $.ajax({
            url:'../addStaff',
            type:'post',
            data:formData,
            processData:false,
            contentType:false,
            success:function (res) {
                alert(res.message);
            }
        })
    })
})
