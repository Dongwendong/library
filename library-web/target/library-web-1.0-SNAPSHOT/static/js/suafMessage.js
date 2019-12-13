$(function () {
    $.ajax({
        url: '../allStaff',
        type: 'post',
        data: {'pageNum': 1, 'pageSize': 5},
        success: function (res) {
            if (res.code == 200) {
                tad(res.data);
                page(res.data,'allStaff')
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
                            "<td>" + res.data.staffAge + "</td>" +
                            "<td>" + res.data.education + "</td>" +
                            "<td>" + res.data.staffCal + "</td>" +
                            "<td>" + res.data.entryDate + "</td>" +
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
                "<td class='text'>" + obj.staffId + "</td>" +
                "<td class='text'>" + obj.staffName + "</td>" +
                "<td class='text' >" + obj.duty + "</td>" +
                "<td class='text'>" + obj.staffSex + "</td>" +
                "<td class='text'>" + obj.staffAge + "岁</td>" +
                "<td class='text'>" + obj.education + "</td>" +
                "<td class='text'>" + obj.staffCal + "</td>" +
                "<td class='text'>" + obj.entryDate + "</td>" +
                "<td class='text'>" + staffStatic + "</td>" +
                "<td><button type='button' class='btn btn-info xx' name='" + obj.staffId + "'>详细信息</button></td>" +
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
    function page(pageInfo ,url) {
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
                    url: '../'+url,
                    method: 'post',
                    data: {'pageNum': pageNum, 'pageSize': 5},
                    success: function (result) {
                        //渲染表格
                        tad(result.data);
                    }
                });
            }
        });
    }
    $("#btn-1").on("click",function () {
            if ($("#staffId").val()!=null && $("#staffId").val()!=''){
                $.ajax({
                    url:'../getIdMessage.do',
                    data:{'id':$("#staffId").val()},
                    type:'get',
                    success:function (res) {
                           if (res.code==200){
                               $("#tad").empty();
                               var staffStatic='离职';
                               if (res.data.staffStatic == 1) {
                                   staffStatic = "在职"
                               }
                               $("#tad").append("<tr>" +
                                   "<td class='text'>" + res.data.staffId + "</td>" +
                                   "<td class='text'>" + res.data.staffName + "</td>" +
                                   "<td class='text' >" + res.data.duty + "</td>" +
                                   "<td class='text'>" + res.data.staffSex + "</td>" +
                                   "<td class='text'>" + res.data.staffAge + "岁</td>" +
                                   "<td class='text'>" + res.data.education + "</td>" +
                                   "<td class='text'>" + res.data.staffCal + "</td>" +
                                   "<td class='text'>" + res.data.entryDate + "</td>" +
                                   "<td class='text'>" + staffStatic + "</td>" +
                                   "<td><button type='button' class='btn btn-info xx' name='" + res.data.staffId + "'>详细信息</button></td>" +
                                   "</tr>")
                           }
                           if (res.code==500){
                               alert(res.message);
                           }
                    }
                })
            }else{
                alert("请输入用户账号！");
            }
    })
    $("#btn").on('click',function () {
       var name= $("#stafName").val();
       var duty= $("#duty").val();
        $.ajax({
            url:'../likeName',
            type:'post',
            data:{'pageNum':1,'pageSize':6,'name':name,'duty':duty},
            success:function (res) {
               tad(res.data);
               page(res.data,'likeName');
            }
        })
    })
})