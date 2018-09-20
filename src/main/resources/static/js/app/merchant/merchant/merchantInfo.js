$(function () {
    var $merchantTableForm = $(".merchant-table-form");
    var settings = {
        url: ctx + "merchantInfo/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                name: $merchantTableForm.find("input[name='name']").val().trim(),
                status: $merchantTableForm.find("select[name='status']").val(),
                //reviewType: $merchantTableForm.find("select[name='reviewType']").val(),
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            visible: false
        },{
            field: 'shopId',
            visible: false
        }, {
            field: 'useridx',
            visible: false
        }, {
            field: 'name',
            title: '店铺名称',
        }, {
            field: 'username',
            title: '店长姓名',
        },{
            field: 'typeName',
            title: '经营品类',
        }, {
            field: 'created',
            title: '创建时间'
        }, {
            field: 'phone',
            title: '联系方式',
        }, {
            field: 'telephone',
            title: '在线客服',
        }, {
            field: 'email',
            title: '邮箱'
        }, {
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                if (value === 1) return '<span class="badge badge-default">待审核</span>';
                if (value === 2) return '<span class="badge badge-success">审核通过</span>';
                if (value === 3) return '<span class="badge badge-warning">审核未通过</span>';
                else '<span class="badge badge-default">待审核</span>';
            }
        }, {
            title: '操作',
            formatter: function (value, row, index) {
                return "<a href='#' onclick='viewMerchant(\"" + row.id + "\")'>查看详情</a>";
            }
        }

        ]
    };

    $MB.initTable('merchantInfoTable', settings);
});

function search() {
    $MB.refreshTable('merchantInfoTable');
}

function refresh() {
    $(".merchant-table-form")[0].reset();
    $MB.refreshTable('merchantInfoTable');
}


//根据dp_shop_review id 查看每个商家的详情
function viewMerchant(id) {

    $.post(ctx + "merchant/getMerchantInfo", {"id":id}, function (r) {
        if (r.code === 0) {
            $('#merchant-review').modal();
            var $form = $('#merchant-review-form');
            var merchant = r.msg;
            $form.find("input[name='name']").val(merchant.name).attr("readonly", true);
            $form.find("input[name='typeName']").val(merchant.typeName).attr("readonly", true);
            $form.find("input[name='typeId']").val(merchant.typeId).attr("readonly", true);
            $form.find("input[name='username']").val(merchant.username).attr("readonly", true);
            $form.find("input[name='useridx']").val(merchant.useridx).attr("readonly", true);
            $form.find("input[name='phone']").val(merchant.phone).attr("readonly", true);
            $form.find("input[name='email']").val(merchant.email).attr("readonly", true);
            $form.find("input[name='telephone']").val(merchant.telephone).attr("readonly", true);
            $form.find("input[name='invitedCode']").val(merchant.invitedCode).attr("readonly", true);
            $form.find("input[name='country']").val(merchant.country).attr("readonly", true);
            $form.find("input[name='pCDistrict']").val(merchant.pCDistrict).attr("readonly", true);
            $form.find("input[name='address']").val(merchant.address).attr("readonly", true);
            /*$form.find("input[name='paymentType']").val(merchant.paymentType).attr("readonly", true);
            $form.find("input[name='businessTime']").val(merchant.businessTime).attr("readonly", true);
            $form.find("input[name='product']").val(merchant.product).attr("readonly", true);
            $form.find("input[name='avgPrice']").val(merchant.avgPrice).attr("readonly", true);
            $form.find("input[name='impressions']").val(merchant.impressions).attr("readonly", true);
            $form.find("input[name='attach']").val(merchant.attach).attr("readonly", true);*/
            $form.find("input[name='registrationNumber']").val(merchant.registrationNumber).attr("readonly", true);
            $form.find("input[name='status']").val(merchant.status);
            $form.find("input[name='id']").val(merchant.id);
            $form.find("input[name='shopId']").val(merchant.shopId);
            $form.find("input[name='businessProof']").val(merchant.businessProof);
            $form.find("input[name='storeImage']").val(merchant.storeImage);
            $form.find("input[name='images']").val(merchant.images);
            var businessProof = merchant.businessProof;
            var businessProofs = new Array();
            businessProofs = businessProof.split(",");
            for (var i=0;i<businessProofs.length;i++){
                var img = $("<img />")
                img.attr("id","businessProofImg");
                img.attr("src",businessProofs[i]);
                //img.width("100px");
                img.height("100px");
                $("#businessProofDiv").append(img);
            }
            var storeImage = merchant.storeImage;
            var storeImages = new Array();
            storeImages = storeImage.split(",");
            for (var i=0;i<storeImages.length;i++){
                var img = $("<img />");
                var storeImageImgId = "storeImageImgId";
                img.attr("id",'storeImageImg');
                img.attr("src",storeImages[i]);
                img.attr("onclick","deleteImg(this)");
                // img.width("100px");
                img.height("100px");
                $("#baseInfoStoreDiv").append(img);
            }
            var product = merchant.images;
            var products = new Array();
            products = product.split(",");
            for (var i=0;i<products.length;i++){
                var img = $("<img />");
                var productImgId = "productImgId";
                img.attr("id",'productImg');
                img.attr("src",products[i]);
                img.attr("onclick","deleteImg(this)");
                // img.width("100px");
                img.height("100px");
                $("#baseInfoProductDiv").append(img);
            }
            if (merchant.status === 2 || merchant.status === 3) {
                $form.find("input[name='reason']").val(merchant.reason).attr("readonly", true);
                $("#merchant-review-passed").attr("style","display:none;");
                $("#merchant-review-failed").attr("style","display:none;");
            }else {
                $form.find("input[name='reason']").attr("readonly", false);
                $("#merchant-review-passed").attr("style","display:block;");
                $("#merchant-review-failed").attr("style","display:block;");
            }
        } else {
            $MB.n_danger(r.msg);
        }
    });
}