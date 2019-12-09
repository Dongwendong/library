$(function () {
    $.ajax({
        url: '../listBorrowBook',
        type: 'post',
        data: {'pageNum': 1, 'pageSize': 6},
        success: function (res) {
            tad(res.data);
            page(res.data, '../listBorrowBook');
        }
    })

    function tad(data) {
        $("#tad").empty();
        $.each(data.list, function (i, obj) {
            $.each(obj.books, function (o, obj1) {
                $.each(obj.userMessages, function (a, obj2) {

                    var bookStatic = '未归还'
                    if (obj.returnDate != null) {
                        bookStatic = '已归还'
                    }
                    var name = obj1.bookName;
                    if (obj1.bookName.length > 7) {
                        name = obj1.bookName.substr(0, 7) + "....";
                    }
                    $("#tad").append("<tr>" +
                        "<td>" + obj.bookId + "</td>" +
                        "<td>" + name + "</td>" +
                        "<td>" + obj2.userName + "</td>" +
                        "<td>" + obj2.userCall + "</td>" +
                        "<td>" + obj.borrowDate + "</td>" +
                        "<td>" + bookStatic + "</td>" +
                        "<td>" + obj1.bookType + "</td>" +
                        " <td><button type='button' class='btn btn-success xxxx'  name='" + obj.borrowId + "'>详细信息</button>" +
                        "</td>" +
                        "</tr>")
                })
            })
        })
    };
    $("#tad").on('click', '.xxxx', function () {
        $("#myModal2").modal('show');
        var id = $(this).attr("name");
        $('#myModal2').modal('show')
        $.ajax({
            url: '../getBorrowBookIdMessage',
            type: 'post',
            data: {"borrowId": id},
            success: function (res) {
                if (res.code == 200) {
                    $.each(res.data.books, function (i, obj) {
                        $.each(res.data.userMessages, function (o, object) {
                            $("#userName-1").val(object.userName);
                            $("#userPhone").val(object.userCall);
                            $("#bookName").val(obj.bookName);
                            $("#bookId-2").val(obj.bookId);
                            $("#integral").val(object.integral);
                            $("#cash").val(object.cash);
                            $("#bookPrice").val(obj.bookPrice);
                            $("#bookType").val(obj.bookType);
                            $("#borrowDate").val(res.data.borrowDate);
                            $("#predictData").val(res.data.predictData);
                        })
                    })
                }
                if (res.code == 500) {
                    alert(res.message);
                }
            }
        })

    })
    function page(pageInfo, url) {
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
                    url:url,
                    method: 'post',
                    data: {'pageNum': pageNum, 'pageSize': 6},
                    success: function (result) {
                        //渲染表格
                        tad(result.data)
                    }
                });
            }
        });
    };
    $.ajax({
        url: '../list',
        type: 'post',
        success: function (res) {
            if (res.code == 200) {
                $.each(res.data, function (i, obj) {
                    $("#select-1").append(" <option>" + obj.t_sum + "</option>")
                })
                $.ajax({
                    url: '../listBookType',
                    type: 'post',
                    data: {'num': $("#select-1").val()},
                    success: function (res) {
                        if (res.code == 200) {
                            $.each(res.data, function (i, obj) {
                                $("#select-2").append("<option>" + obj.t_classify + "</option>")
                            })
                        }
                    }
                })
            }
        }
    });
    $("#select-1").change(function () {
        $("#select-2").empty();
        var num = $("#select-1").val();
        $.ajax({
            url: '../listBookType',
            type: 'post',
            data: {'num': num},
            success: function (res) {
                if (res.code == 200) {
                    $.each(res.data, function (i, obj) {
                        $("#select-2").append("<option>" + obj.t_classify + "</option>")
                    })
                }
            }

        })
    });
    $("#btn1").on("click", function () {
        var data = $("#data").val();
        var static = $("input[name='static']:checked").val();
        var type = $("#select-2").val();
        $.ajax({
            url: '../getStatic.do',
            type: 'post',
            data: {'pageNum': 1, 'pageSize': 6, 'bookStatic': static, 'bookData': data, 'bookType': type},
            success: function (res) {
                if (res.code == 200) {
                    tad(res.data);
                    page(res.data, '../getStatic.do');
                }
                if (res.code == 500) {
                    alert(res.message);
                }

            }
        })
    });
})