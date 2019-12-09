$(function () {
    $.ajax({
        url: '../staffMessage.do',
        type: 'get',
        success: function (res) {
            $("#img").attr("src", "../page/imges/" + res.data.staffImg);
            $("#img-2").attr("src", "../page/imges/" + res.data.staffImg);
            $("#staffName1").html(res.data.staffName)
            $("#staffName").val(res.data.staffName)
            $("#staffAge").val(res.data.staffAge);
            $("#education").val(res.data.education);
            $("#staffCal").val(res.data.staffCal);
            $("#id").val(res.data.staffId);
            $("#staffId").val(res.data.staffId)
            $("#duty").val(res.data.duty);
            $("#staffIdcard").val(res.data.staffIdcard);
            $("#entryDate").val(res.data.entryDate);
            $("#staffAddress").val(res.data.staffAddress);
            $("#bankCard").val(res.data.bankCard);
            $("#linkmanName").val(res.data.linkmanName);
            $("#linkmanCall").val(res.data.linkmanCall);
            $("#data").val(res.data.entryDate)
        }
    })
    $("#message").on("click", function () {
        $('#myModal').modal('show');
    })
    $("#updatePassword").on("click", function () {
        $('#myModal1').modal('show');
    })
    $("#file").change(function () {
        var formData = new FormData();
        formData.append('file', $('#file')[0].files[0]);
        $.ajax({
            url: '../test',
            type: 'post',
            data: formData,
            processData: false,
            contentType: false,
            success: function (res) {
                if (res.code == 200) {
                    $("#img-2").attr("src", "../page/imges/" + res.message)
                }
            }
        })
    })
    $("#btn").on("click", function () {
        var formData = new FormData(document.getElementById('for'));
        var fileInput = $('#file').get(0).files[0];
        if (fileInput) {
            $.ajax({
                url: '../updateStaff',
                type: 'post',
                data: formData,
                processData: false,
                contentType: false,
                success: function (res) {
                    alert(res.message);
                }
            })

        } else {
            $.ajax({
                url: '../updateStaff1',
                type: 'post',
                data: $("#for").serialize(),
                success: function (res) {
                    alert(res.message);
                }
            })
        }
    })
    $("#updatePasswordbtn").on("click", function () {
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
    $("#tc").on("click", function () {
        var myDate = new Date();
        var h = myDate.getHours();
        var data = 18;

        if (parseInt(h) >= parseInt(data)) {
            $("#myModal2").modal('show');
            $("#tishi").html('确定退出');
        } else {
            $("#myModal2").modal('show');
            $("#tishi").html('还没到下班时间,你确定你要退出登录吗？');
        }
    })
    $("#close").on("click",function () {
            $.ajax({
                url:'../close',
                type:'get',
                success:function(res){
                    window.location.reload();
                }
            })
    })
})