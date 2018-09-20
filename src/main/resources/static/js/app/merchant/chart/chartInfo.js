$(function () {
    var $merchantTableForm = $(".merchant-table-form");
    var settings = {
        url: ctx + "chartInfo/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
            };
        },
        columns: [{
            checkbox: true,
            /*visiable: false,*/
        },
            {
                field: 'name',
                title: '商家名称',
            }, {
                field: 'shopPrice',
                title: '销售总额(MYR)',
            }, {
                field: 'created',
                title: '注册时间',
            }, {
                field: 'popularity',
                title: '评价分数',
            }, {
                title: '操作',
                formatter: function (value, row, index) {

                    return "<a href='#' onclick='viewMerchant(\"" + row.id + "\")'>查看详情</a>";
                }
            },

        ]
    };

    $MB.initTable('chartInfoTable', settings);
});

function search() {
    $MB.refreshTable('chartInfoTable');
}

function refresh() {
    $(".merchant-table-form")[0].reset();
    $MB.refreshTable('chartInfoTable');
}

function exportChartExcel() {
    $.post(ctx + "chart/excel", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportChartCsv() {
    $.post(ctx + "chart/csv", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

//财务详情
function viewMerchant(id) {
    $.post(ctx + "finance/getChartInfo", {"shopUserId": id}, function (r) {
        if (r.code === 0) {
            $('#merchant-review').modal();
            var $form = $('#merchant-review-form');
            var merchant = r.msg;
            $form.find("input[name='name']").val(merchant.name).attr("readonly", true);
            $form.find("input[name='username']").val(merchant.username).attr("readonly", true);
            $form.find("input[name='phone']").val(merchant.phone).attr("readonly", true);
            $form.find("input[name='created']").val(merchant.created).attr("readonly", true);
            $form.find("input[name='shopPrice']").val(merchant.shopPrice).attr("readonly", true);
            $form.find("input[name='totalNum']").val(merchant.totalNum).attr("readonly", true);
        } else {
            $MB.n_danger(r.msg);
        }
    });
}


//关闭弹框方法
function reviewClose() {
    var $form = $('#merchant-review-form');
    $form.find("input[name='name']").val("");
    $form.find("input[name='username']").val("");
    $form.find("input[name='phone']").val("");
    $form.find("input[name='created']").val("");
    $form.find("input[name='shopPrice']").val("");
    $form.find("input[name='totalNum']").val("");
    /*//清空Div中的img
     $("#businessProofDiv").find("img[id='businessProofImg']").remove();*/
    $MB.closeAndRestModal("merchant-review");
    $(".merchant-table-form")[0].reset();
    $MB.refreshTable('merchantInfoTable');
}


