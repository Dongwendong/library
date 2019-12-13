$(function () {
    $.ajax({
        url: '../listBorrowBook',
        data: {'pageNum': 1, 'pageSize': 6},
        type: 'post',
        success: function (res) {
            tad(res.data)
            page(res.data)
        }
    })
    var dataTime = '';

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
                    dataTime = obj.predictData;
                    if (checkEndTime(obj.predictData)) {
                        $("#tad").append("<tr class='tr-color'>" +
                            "<td>" + obj2.userName + "</td>" +
                            "<td>" + name + "</td>" +
                            "<td>" + obj2.userCall + "</td>" +
                            "<td>" + obj.borrowDate + "</td>" +
                            "<td>" + obj.predictData + "</td>" +
                            "<td>" + bookStatic + "</td>" +
                            "<td><button type='button' class='btn btn-success'>归还书籍</button>" +
                            " <button type='button' class='btn btn-danger'>书籍报损</button>" +
                            " <button type='button' class='btn btn-danger'>短信提醒</button>" +
                            "</td>" +
                            "</tr>")
                    } else {
                        $("#tad").append("<tr>" +
                            "<td>" + obj2.userName + "</td>" +
                            "<td>" + name + "</td>" +
                            "<td>" + obj2.userCall + "</td>" +
                            "<td>" + obj.borrowDate + "</td>" +
                            "<td>" + obj.predictData + "</td>" +
                            "<td>" + bookStatic + "</td>" +
                            "<td><button type='button' class='btn btn-success guiHuan' name='" + obj.userId + "'>归还书籍</button>" +
                            " <button type='button' class='btn btn-success xxxx'  name='" + obj.borrowId + "'>详细信息</button>" +
                            " <button type='button' class='btn btn-danger tiXin'  name='" + obj.borrowId + "'>短信提醒</button>" +
                            "</td>" +
                            "</tr>")
                    }
                })
            })
        })

    };

    function checkEndTime(startTime) {
        var myDate = new Date();
        var year = myDate.getFullYear();        //获取当前年
        var month = myDate.getMonth() + 1;   //获取当前月
        var date = myDate.getDate();
        var endTime = year + '-' + getNow(month) + "-" + getNow(date);
        var start = new Date(startTime.replace("-", "/").replace("-", "/"));
        var end = new Date(endTime.replace("-", "/").replace("-", "/"));
        if (end < start) {
            return false;
        }
        return true;
    }

    var id;
    var bookid;
    var borrowId;
    $("#tad").on("click", '.guiHuan', function () {
        id = $(this).attr("name");
        $('#myModal').modal('show')
    })
    $("#btn").on("click", function () {
        bookid = $("#bookId").val();
        $.ajax({
            url: '../returnBook',
            type: 'post',
            data: {"userId": id, "bookId": bookid},
            success: function (res) {
                if (res.code == 200) {
                    $("#myModal").modal('hide');
                    $("#myModal1").modal('show');
                    $.each(res.data.userMessages, function (i, obj) {
                        borrowId = res.data.borrowId;
                        $("#userName").html("用户姓名：" + obj.userName);
                        $("#phone").html("用户手机号：" + obj.userCall);

                    })
                }
                if (res.code == 500) {
                    alert(res.message);
                }
            }
        })
    })
    $("#bookIdcx").on("click", function () {
        $.ajax({
            url: '../returnBookMessage',
            data: {'pageNum': 1, 'pageSize': 6, 'bookId': $('#bookId-1').val()},
            type: 'post',
            success: function (res) {
                if (res.code == 200) {
                    var phone = '';
                    tad(res.data);
                    page1(res.data, $('#bookId-1').val(), phone);
                }
            }
        })
    })
    $("#phonecx").on("click", function () {
        $.ajax({
            url: '../returnBookMessage',
            data: {'pageNum': 1, 'pageSize': 6, 'phone': $('#phone-1').val()},
            type: 'post',
            success: function (res) {
                if (res.code == 200) {
                    var bookId = 0;
                    tad(res.data);
                    page1(res.data, bookId, $('#phone-1').val());
                }
            }
        })
    })
    $("#btn1").on("click", function () {
        update();
    })

    function update() {
        $.ajax({
            url: '../updateBorrow',
            type: 'post',
            data: {'userId': id, 'bookowId': bookid, 'borrowId': borrowId},
            success: function (res) {
                if (res.code == 200) {
                    alert(res.message);
                    window.location.reload();
                }
                if (res.code == 500) {
                    alert(res.message);
                }
            }
        })
    }

    $("#tad").on("click", '.xxxx', function () {
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
    $("#tad").on("click", '.tiXin', function () {
        var id = $(this).attr("name");
        $.ajax({
            url: '../getBorrowBookIdMessage',
            type: 'post',
            data: {"borrowId": id},
            success: function (res) {
                if (res.code == 200) {
                    var data = res.data.predictData;
                    if (checkEndTime(data)) {
                        alert("短信已发送")
                    } else {
                        alert("还没有还书时间，不能发送短信")
                    }

                }
                if (res.code == 500) {
                    alert(res.message);
                }
            }
        })
        });

        function getNow(s) {
            return s < 10 ? '0' + s : s;
        };

        //分页
        function page(pageInfo) {
            $("#page").pagination(pageInfo.total, { //第一个参数指定共多少条记录
                items_per_page: pageInfo.pageSize, // 每页显示多少条记录
                next_text: "下一页", //下一页按钮图标
                prev_text: "上一页", //上一页按钮图标
                num_display_entries: 5,//主体页数
                num_edge_entries: 2, //边缘页数
                callback: function (index) {//定义一个回调函数，用于每次点击页码发起分页查询请求
                    //index为当前页码，只不过下标是从0开始，因此需要+1操作
                    var pageNum = ++index;
                    $.ajax({
                        url: '../listBorrowBook',
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
        function page1(pageInfo, phone, bookId) {
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
                        url: '../returnBookMessage',
                        method: 'post',
                        data: {'pageNum': pageNum, 'pageSize': 6, 'phone': phone, 'bookId': bookId},
                        success: function (result) {
                            //渲染表格
                            tad(result.data)
                        }
                    });
                }
            });
        }
    })