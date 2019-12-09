$(function () {
    $.ajax({
        url: '../listBook',
        type: 'post',
        data: {'pageNum': 1, 'pageSize': 6},
        success: function (res) {
            if (res.code == 200) {
                tad(res.data);
                page(res.data,listBook);
            }
        }
    })
    $("#select-1").change(function () {
        $("#tad-1").empty();
        var num = $("#select-1").val();
        $.ajax({
            url: '../listBookType',
            type: 'post',
            data: {'num': num},
            success: function (res) {
                if (res.code == 200) {
                    $.each(res.data, function (i, obj) {
                        $("#tad-1").append("<option>" + obj.t_classify + "</option>")
                    })
                }
            }

        })
    })
    var num1 = $("#select-1").val();
    $.ajax({
        url: '../listBookType',
        type: 'post',
        data: {'num': num1},
        success: function (res) {
            if (res.code == 200) {
                $.each(res.data, function (i, obj) {
                    $("#tad-1").append("<option>" + obj.t_classify + "</option>")
                })
            }
        }
    })

    function tad(data) {
        $('#tab').empty();
        $.each(data.list, function (i, obj) {
            var bookStatic = "告竭"
            if (obj.bookStatic == 1) {
                bookStatic = "充足"
            }
            var name = obj.bookName;
            if (obj.bookName.length > 7) {
                name=obj.bookName.substr(0, 7)+"....";
            }
            $("#tab").append("<tr>" +
                "<td class='text'>" + obj.bookId + "</td>" +
                "<td class='text'>" + name + "</td>" +
                "<td class='text' >" + obj.bookPrice + "</td>" +
                "<td class='text'>" + obj.bookType + "</td>" +
                "<td class='text'>" + obj.publishing + "岁</td>" +
                "<td class='text'>" + obj.bookDate + "</td>" +
                "<td class='text'>" + obj.author + "</td>" +
                "<td class='text'>" + bookStatic + "</td>" +
                "<td><button type='button' class='btn btn-info xx' name='" + obj.bookId + "'>详细信息</button></td>" +
                "</tr>")
        })
    }
    $("#select").on('click' ,function () {
       var name= $("#name").val();
        var static = $("input[name='bookStatic']:checked").val();
        var type=$("#tad-1").val();
            $.ajax({
                url:'../detail',
                type:'post',
                data:{'pageNum':1,'pageSize':6,'bookName':name,'bookStatic':static,'bookType':type},
                success:function (res) {
                    if (res.code==200){
                        tad(res.data);
                        page(res.data,detail);
                    }
                    if (res.code==500){
                        alert(res.message);
                    }
                }
            })
    })
    $("#tab").on("click", ".xx", function (){
        var id = $(this).attr("name");
        $.ajax({
            url:'../bookId',
            type:'post',
            data: {"id": id},
            success:function (res) {
                if(res.code==200){
                    window.location.href="bookIdMessage.html";
                }
            }
        })
  })
    //分页
    function page(pageInfo,url) {
        $("#page").pagination(pageInfo.total, { //第一个参数指定共多少条记录
            items_per_page: pageInfo.pageSize, // 每页显示多少条记录
            next_text: ">", //下一页按钮图标
            prev_text: "<", //上一页按钮图标
            num_display_entries: 5,//主体页数
            num_edge_entries: 2, //边缘页数
            callback: function (index) {//定义一个回调函数，用于每次点击页码发起分页查询请求
                //index为当前页码，只不过下标是从0开始，因此需要+1操作
                var pageNum = ++index;
                $.ajax({
                    url: '../'+url,
                    method: 'post',
                    data: {'pageNum': pageNum, 'pageSize': 6},
                    success: function (result) {
                        //渲染表格
                        tad(result.data);
                    }
                });
            }
        });
    }

})