$(function () {
    $.ajax({
        url: '../allStaff',
        type: 'post',
        data: {'pageNum': 1, 'pageSize': 6},
        success: function (res) {
            if (res.code == 200) {
                tad(res.data);
                page(res.data)
            }
        }
    })
    $("#btn").on("click", function () {
        if ($("#stafId").val() != null) {
            $.ajax({
                url: '../getId',
                type: 'get',
                data: {'id': $("#stafId").val()},
                success: function (res) {
                    if (res.code == 200) {
                        var staffStatic = "离职"
                        if (res.data.staffId == 1) {
                            staffStatic = "在职"
                        }
                        $("#tad").empty();
                        $("#tad").append("<tr>" +
                            "<td>" + res.data.staffId + "</td>" +
                            "<td>" + res.data.staffName + "</td>" +
                            "<td>" + res.data.duty + "</td>" +
                            "<td>" + res.data.staffSex + "</td>" +
                            "<td>" + res.data.staffCal + "</td>" +
                            "<td>" + staffStatic + "</td>" +
                            "<td><button type='button' class='btn btn-info' name='" + res.data.staffId + "'>详细信息</button>" +
                            "<button type='button' class='btn btn-danger'  name='" + res.data.staffId + "'>员工离职</button></td>" +
                            "</tr>")
                    }
                }
            })
        }
    })

    function tad(data) {
        var staffStatic = "离职"
        $('#tad').empty();
        $.each(data.list, function (i, obj) {
            if (obj.staffStatic == 1) {
                staffStatic = "在职"
            }
            $("#tad").append("<tr>" +
                "<td>" + obj.staffId + "</td>" +
                "<td>" + obj.staffName + "</td>" +
                "<td>" + obj.duty + "</td>" +
                "<td>" + obj.staffSex + "</td>" +
                "<td>" + obj.staffCal + "</td>" +
                "<td>" + staffStatic + "</td>" +
                "<td><button type='button' class='btn btn-info xx' name='" + obj.staffId + "'>详细信息</button>||" +
                "<button type='button' class='btn btn-danger lz' name='" + obj.staffId + "' >员工离职</button></td>" +
                "</tr>")
        })
    }

    $("#tad").on("click", ".xx", function () {
        var id = $(this).attr("name");
        $.ajax({
            url: '../id',
            type: 'post',
            data: {"id": id},
            success: function (res) {
                if (res.code == 200) {

                    window.location.href = res.message;
                }
            }
        })
    })

    //分页
    function page(pageInfo) {
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
                    url: '../allStaff',
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