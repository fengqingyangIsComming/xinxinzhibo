$(function () {
    var $offerInfoTableForm = $(".offerInfo-table-form");
    var settings = {
        url: ctx + "offerInfo/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                //name: $merchantTableForm.find("input[name='name']").val().trim(),
                status: $offerInfoTableForm.find("select[name='status']").val(),
            };
        },
        columns: [{
            checkbox: true
        },{
            field: 'id',
            visible: false
        },{
            field: 'shopId',
            visible: false
        },{
            field: 'name',
            title: '店铺名称',
        },{
            field: 'typeName',
            title: '经营品类',
        },{
            field: 'man',
            title: '满',
        },{
            field: 'jian',
            title: '减'
        }, {
            field: 'sale',
            title: '折扣',
        }, {
            title: '操作',
            formatter: function (value, row, index) {
                if (row.status===1){
                    return "<a href='#' onclick='offerReview(\"" + row.id + "\",\"" + 2 + "\")'>通过</a>"+"|"+
                        "<a href='#' onclick='offerReview(\"" + row.id + "\",\"" + 3 + "\")'>不通过</a>";
                }else if (row.status===3) {
                    return '<span class="badge badge-warning">审核未通过</span>';
                }else if (row.status===2){
                    return '<span class="badge badge-success">审核通过</span>';
                }

            }
        }

        ]
    };

    $MB.initTable('offerInfoTable', settings);
});

function search() {
    $MB.refreshTable('offerInfoTable');
}

function offerInfoRefresh() {
    $MB.refreshTable('offerInfoTable');
}
/*, {
    field: 'status',
        title: '状态',
        formatter: function (value, row, index) {
        if (value === 1) return '<span class="badge badge-default">审核中</span>';
        if (value === 2) return '<span class="badge badge-success">审核通过</span>';
        if (value === 3) return '<span class="badge badge-warning">审核未通过</span>';
    }
}*/


//审核方法
function offerReview(id,status) {
    var operator = userName;

    // if (sale=='undefined' || sale == null ||sale === "" ){
        $.post(ctx + "offerInfo/review", {"id":id,"status":status,"operator":operator}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
            }else {
                $MB.n_danger(r.msg);
            }
        });
    // }else {
    //     $.post(ctx + "offerInfo/review", {"id":id,"shopId":shopId,"status":status,"man":"","jian":"","sale":sale,"operator":operator}, function (r) {
    //         if (r.code === 0) {
    //             $MB.n_success(r.msg);
    //         }else {
    //             $MB.n_danger(r.msg);
    //         }
    //     });
    // }

    $MB.refreshTable('offerInfoTable');
}

/*
function refresh() {
    $MB.refreshTable('offerInfoTable');
}*/
