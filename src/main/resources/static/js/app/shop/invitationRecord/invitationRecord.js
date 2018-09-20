$(function () {
    var $invitationRecordTableForm = $(".invitationRecord-table-form");
    var settings = {
        url: ctx + "invitationRecord/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                // timeField: $commentTableForm.find("input[name='timeField']").val().trim(),
                useridx: $invitationRecordTableForm.find("input[name='useridx']").val(),
            };
        },
        columns: [{
            checkbox: true
        },
            {
                field: 'id',
                visible: false
            }, {
                field: 'invitee',
                title: '被邀请者'
            }, {
                field: 'name',
                title: '店铺名称'
            }, {
                field: 'creatTime',
                title: '被邀请者注册时间'
            }
        ]
    };
    $MB.initTable('invitationRecordTable', settings);
});

function search() {
    $MB.refreshTable('invitationRecordTable');
}

function refresh() {
    $(".invitationRecord-table-form")[0].reset();
    search();
}

//查看详情
function viewDetail(username,id) {
    /*$('#comment-detail').modal();
    var $form = $('#comment-detail-form');
    $form.find("input[name='name']").val(username).attr("readonly", true);
    $form.find("input[name='levelcontent']").val(id).attr("readonly", true);
    $form.find("input[name='content']").val(content).attr("readonly", true);
   if (isImage===1){
       var productImgs = new Array();
       productImgs = image.split(",");
       console.log(image);
       console.log(productImgs);
       for (var i=0;i<productImgs.length;i++){
           var img = $("<img />")
           img.attr("id","commentDetailProductImg");
           img.attr("src",productImgs[i]);
           img.width("120px");
           img.height("120px");
           $("#productDiv").append(img);
       }
   }*/

    $.post(ctx + "comment/viewDetail", {"id":id}, function (r) {
        if (r.code === 0) {
            var comment = r.msg;
            $('#comment-detail').modal();
            var $form = $('#comment-detail-form');
            $form.find("input[name='name']").val(username).attr("readonly", true);
            $form.find("input[name='levelcontent']").val(comment.levelcontent).attr("readonly", true);
            $form.find("input[name='content']").val(comment.content).attr("readonly", true);


            var image = comment.iamge;
            if (comment.iamge===""){

            }else {
                var productImgs = new Array();
                productImgs = image.split(",");
                console.log(image);
                console.log(productImgs);
                for (var i=0;i<productImgs.length;i++){
                    var img = $("<img />")
                    img.attr("id","commentDetailProductImg");
                    img.attr("src",productImgs[i]);
                    img.width("120px");
                    img.height("120px");
                    $("#productDiv").append(img);
                }
            }
        }
    });

}