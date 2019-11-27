$(function () {
    $.ajax({
        url: '../getIdMessage',
        type: 'get',
        success: function (res) {

            if (res.code == 200) {
                $("#staffId").val(res.data.staffId)
                $("#staffName").val(res.data.staffName)
                if (res.data.staffName == "男") {
                    $("#nan").prop("checked", true);
                    $("#nv").prop("checked", false);
                }
                if (res.data.staffName == "女") {
                    $("#nv").prop("checked", true);
                    $("#nan").prop("checked", false);
                }
                $("#img-1").attr("src", "../page/imges/" + res.data.staffImg)
                $("#staffAge").val(res.data.staffAge);
                $("#education").val(res.data.education);
                $("#staffCal").val(res.data.staffCal);
                $("#duty").val(res.data.duty);
                $("#staffIdcard").val(res.data.staffIdcard);
                $("#entryDate").val(res.data.entryDate);
                $("#staffAddress").val(res.data.staffAddress);
                $("#bankCard").val(res.data.bankCard);
                $("#linkmanName").val(res.data.linkmanName);
                $("#linkmanCall").val(res.data.linkmanCall);

            }
        }
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
                    $("#img-1").attr("src", "../page/imges/" + res.message)
                }
            }
        })
    })
    $("#close").on("click",function () {
        window.location.href = "suafMessage.html";
    })
    $("#btn").on("click", function () {
        var formData = new FormData(document.getElementById('for1'));
        var fileInput = $('#file').get(0).files[0];
        if (fileInput) {
            $.ajax({
                url:'../updateStaff',
                type:'post',
                data:formData,
                processData:false,
                contentType:false,
                success:function (res) {
                    alert(res.message);
                }
            })
        } else {
          $.ajax({
              url:'../updateStaff1',
              type:'post',
              data:$("#for1").serialize(),
              success:function (res) {
                  alert(res.message);
              }
          })
        }
    })
})