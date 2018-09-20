$(function () {
    var $integralTableForm = $(".integral-table-form");
    var settings = {
        url: ctx + "integralInfo/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                invitedCode: $integralTableForm.find("input[name='invitedCode']").val().trim(),
                manager: $integralTableForm.find("input[name='manager']").val().trim(),
            };
        },
        columns: [{
            checkbox: true
        },{
            field: 'id',
            visible: false,
        },{
            field: 'inviter',
            title: '邀请者',
        }, {
            field: 'invitee',
            title: '被邀请者',
        }, {
                field: 'creatTime',
                title: '被邀请者时间',
            }/*, {
            title: '操作',
            formatter: function (value, row, index) {
                if (row.status===1){
                    return "<a href='#' onclick='integralReviewPassed(\""+row.invitee+"\")'>通过</a>"+"|"+
                        "<a href='#' onclick='integralReviewFiled(\""+row.invitee+"\")'>不通过</a>";
                }else if (row.status===3) {
                    return '<span class="badge badge-warning">审核未通过</span>';
                }else if (row.status===2){
                    return '<span class="badge badge-success">审核通过</span>';
                }

            }
        }*/

        ]
    };

    $MB.initTable('integralInfoTable', settings);
});

function search() {
    $MB.refreshTable('integralInfoTable');
}

function refresh() {
    $(".integral-table-form")[0].reset();
    $MB.refreshTable('integralInfoTable');
}



//审核通过
function integralReviewPassed(invitee) {

   /* $.post(ctx + "integral/review", {"invitee": invitee,"status":3}, function (r) {
        if (r.code === 0) {
            $MB.n_success(r.msg);
        }else {
            $MB.n_danger(r.msg);
        }
    });*/
    refresh();
}

//审核未通过
function integralReviewFiled(invitee) {
    /*$.post(ctx + "integral/review", {"invitee": invitee,"status":2}, function (r) {
        if (r.code === 0) {
            $MB.n_success(r.msg);
        }else {
            $MB.n_danger(r.msg);
        }
    });*/
    refresh();
}