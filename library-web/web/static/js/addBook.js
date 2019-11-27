$(function () {
    $("#addType").on("click",function () {
            $("#myModal").modal("show");
    })
    //添加书籍信息
    $("#btn-1").on("click",function () {
        var formData = new FormData(document.getElementById('for1'));
        alert($("#tad-1").val())
        $.ajax({
            url:'../addBook',
            type:'post',
            data:formData,
            processData:false,
            contentType:false,
            success:function (res) {
                alert(res.message);
            }
        })
    })
    var num1= $("#select-1").val();
    $.ajax({
        url:'../listBookType',
        type:'post',
        data:{'num':num1},
        success:function (res) {
            if(res.code==200){
                $.each(res.data,function (i,obj) {
                    $("#tad-1").append("<option>"+obj.t_classify+"</option>")
                })
            }
        }
    })
    $("#select-1").change(function () {
        $("#tad-1").empty();
       var num= $("#select-1").val();
        $.ajax({
            url:'../listBookType',
            type:'post',
            data:{'num':num},
            success:function (res) {
                if(res.code==200){
                    $.each(res.data,function (i,obj) {
                        $("#tad-1").append("<option>"+obj.t_classify+"</option>")
                    })
                }
            }

        })
    })
    $("#btn").on("click" ,function () {
        $.ajax({
            url:'../addBookType',
            type:'post',
            data:$("#for").serialize(),
            success:function (res) {
                if(res.code==200){
                    alert(res.message);
                    $("#zilei").val("");
                }else {
                    alert(res.message);
                }
            }
        })
    })
})