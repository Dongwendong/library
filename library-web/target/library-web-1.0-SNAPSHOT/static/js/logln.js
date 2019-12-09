$(function () {
    $("#forGet").on("click", function () {
        $("#myModal").modal("show")
    })
    $("#password").on("click", function () {
        $("#yzm").hide().prop('src', '../code.jpg?random=' + Math.random()).fadeIn();
    })
    $("#yzm").click(function () {
        $(this).hide().prop('src', '../code.jpg?random=' + Math.random()).fadeIn();
    });
    $("#staffLogin").on("click", function () {
        $.ajax({
            url: '../staffLogin',
            type: 'post',
            data: {"id": $("#id").val(), "password": $("#password").val(), "code": $("#code-1").val()},
            success: function (res) {
                if (res.code == 200) {
                    window.location.href = res.message;
                }
                if (res.code == 500) {
                    alert(res.message);
                }
            }
        })
    })
    $("#btn-2").on("click", function () {
        var a = '';
        for (var i = 0; i < 6; i++) {
            a += Math.ceil(Math.random() * 10) + '';
        }
        $("#f").attr('type', 'text');
        $("#f").val(a);
    })
    $("#btn-1").on("click", function () {
        var phoneForGet = $("#phoneForGet").val()
        var f = $("#f").val();
        var phone = $("#phone").val();
        var firstname = $("#firstname").val();
        if (phoneForGet != null && phoneForGet != "") {
            if (phoneForGet == f) {
                $.ajax({
                    url: '../forGet.do',
                    data: {"id": firstname, "phone": phone},
                    type: 'post',
                    success: function (res) {
                        if (res.code == 200) {
                            $("#myModal1").modal("show");
                        } else {
                            alert(res.message);
                        }

                    }
                })
            } else {
                alert("请输入正确的验证码");
            }
        } else {
            alert("请输入手机验证码");
        }
    })
    $("#updatePassword").on("click", function () {
        var id = $("#firstname").val();
        var password = $.trim($("#password-1").val());
        var password1 = $.trim($("#password-2").val());
        if (password != null) {
            if (password == password1) {
                $.ajax({
                    url: '../updatePassword',
                    data: {"id": id, "passwrod": password},
                    type: 'post',
                    success: function (res) {
                        if (res.code == 200) {
                            alert(res.message);
                            $("#myModal").modal("hide")
                            $("#myModal1").modal("hide")
                        } else {
                            alert(res.message);
                        }
                    }
                })
            } else {
                alert("两次密码不一致！请重新输入。")
            }
        } else {
            alert("请输入密码");
        }

    })
})