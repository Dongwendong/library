$(function () {
    $.ajax({
        url:'../idBookMessage',
        type:'get',
        success:function (res) {
            $("#select-1").val(res.data.kind.t_sum);
            $("#bookId").val(res.data.bookId);
            $("#id").val(res.data.bookId)
            $("#bookName").val(res.data.bookName);
            $("#bookPrice").val(res.data.bookPrice);
            $("#bookId").val(res.data.bookId);
            $("#bookType").append("<option selected>"+res.data.kind.t_classify+"</option>")
            type(res.data.kind.t_classify)
            $("#publishing").val(res.data.publishing);
            $("#suitable").append("<option selected>"+res.data.suitable+"</option>")
            $("#buyingDate").val(res.data.buyingDate);
            $("#author").val(res.data.author);
            $("#bookResidue").val(res.data.bookResidue);
            $("#bookDate").val(res.data.bookDate);
            $("#bookBrief").val(res.data.bookBrief);
            $("#img-1").attr("src", "../page/imges/" + res.data.bookImg)
            $("#img-1").error(function() {
                $(this).attr("src", "../page/imges/default.jpg");
            });
            if(res.data.bookStatic==1){
                $('input:radio').eq(1).attr('checked', 'true');
            }else{
                $('input:radio').eq(2).attr('checked', 'true');
            }
        }
    })

    function type(type){
        $.ajax({
            url:'../listBookType',
            type:'post',
            data:{'num':type},
            success:function (res) {
                if(res.code==200){
                    $.each(res.data,function (i,obj) {
                        $("#bookType").append("<option>"+obj.t_classify+"</option>")
                    })
                }
            }
        })
    }
    $("#select-1").change(function () {
        $("#bookType").empty();
        var num= $("#select-1").val();
        $.ajax({
            url:'../listBookType',
            type:'post',
            data:{'num':num},
            success:function (res) {
                if(res.code==200){
                    $.each(res.data,function (i,obj) {
                        $("#bookType").append("<option>"+obj.t_classify+"</option>")
                    })
                }
            }
        })
    })
$("#btn-2").on("click",function () {
    window.location.href = "bookMessage.html";
})
$("#btn").on("click",function () {
        var formData = new FormData(document.getElementById('for1'));
        var fileInput = $('#img').get(0).files[0];
        if (fileInput) {
            $.ajax({
                url:'../updateBook1',
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
                url:'../updateBook',
                type:'post',
                data:$("#for1").serialize(),
                success:function (res) {
                    alert(res.message);
                }
            })
        }
    })

    $("#img").change(function () {
        var formData = new FormData();
        formData.append('file', $('#img')[0].files[0]);
        $.ajax({
            url: '../bookImg',
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

})