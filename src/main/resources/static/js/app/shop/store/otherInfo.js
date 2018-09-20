
$(function () {

    $.ajax({
        type: "POST",
        url: "shop/getMerchantOtherInfo",
        data: {useridx:userName},
        dataType: "json",
        success: function(r){
            if (r.code === 0) {

                var $form = $('.otherInfo-table-form');
                var merchant = r.msg;

                $form.find("input[name='paymentType']").val(merchant.paymentType);
                $form.find("input[name='businessTime']").val(merchant.businessTime);
                $form.find("input[name='product']").val(merchant.product);
                $form.find("input[name='avgPrice']").val(merchant.avgPrice);
                $form.find("input[name='impressions']").val(merchant.impressions);
                $form.find("input[name='attach']").val(merchant.attach);

                $form.find("input[name='shopId']").val(merchant.shopId);

            } else {
                $MB.n_danger(r.msg);
            }
        }
    });
    // $.post(ctx + "shop/getMerchantInfo", {"useridx":useridx}, function (r) {
    //
    // });
})


//提交修改
function otherInfoSubmit() {

    var $form = $(".otherInfo-table-form");
    $.post(ctx + "otherInfo/save",$form.serialize(), function (r) {

        if (r.code===0){
            var $form = $('.otherInfo-table-form');
            $form.find("input[name='paymentType']").attr("readonly", true);;
            $form.find("input[name='businessTime']").attr("readonly", true);
            $form.find("input[name='product']").attr("readonly", true);
            $form.find("input[name='avgPrice']").attr("readonly", true);
            $form.find("input[name='impressions']").attr("readonly", true);
            $form.find("input[name='attach']").attr("readonly", true);

            $MB.n_success("信息已修改成功！");

        }else {
            $MB.n_danger(r.msg);
        }
    })


    $("#otherInfoSubDiv").html('');
    $("#otherInfoSubDiv").append('<span>'+"信息已经修改！"+'</span>');
}

