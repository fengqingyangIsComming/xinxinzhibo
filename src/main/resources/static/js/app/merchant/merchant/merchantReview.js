//审核通过方法
function reviewPassed() {
    //获取用户id方法
    var $form = $('#merchant-review-form');
    /*var shopUserId = $form.find("input[name='shopUserId']").val();
    var useridx = $form.find("input[name='useridx']").val();
    var reason = $form.find("input[name='reason']").val();
    var reviewType = $form.find("input[name='reviewType']").val();
    var inviteCode = $form.find("input[name='inviteCode']").val();*/
    $form.find("input[name='status']").val(2);
    var operator = userName;
    $form.find("input[name='operator']").val(operator);
    $.post(ctx + "merchant/review", $('#merchant-review-form').serialize(), function (r) {
        if (r.code === 0) {
            $MB.n_success(r.msg);
        }else {
            $MB.n_danger(r.msg);
        }
    });
    reviewClose();
}

//审核未通过方法
function reviewFailed() {
    //获取用户id方法
    var $form = $('#merchant-review-form');
   /* var shopUserId = $form.find("input[name='shopUserId']").val();
    var useridx = $form.find("input[name='useridx']").val();
    var reason = $form.find("input[name='reason']").val();
    var reviewType = $form.find("input[name='reviewType']").val();
    var inviteCode = $form.find("input[name='inviteCode']").val();*/
    $form.find("input[name='status']").val(3);
    var operator = userName;
    $form.find("input[name='operator']").val(operator);
    $.post(ctx + "merchant/review",  $('#merchant-review-form').serialize(), function (r) {
        if (r.code === 0) {
            $MB.n_success(r.msg);
        }else {
            $MB.n_danger(r.msg);
        }
    });
    reviewClose();
}

//关闭弹框方法
function reviewClose() {
    var $form = $('#merchant-review-form');
    $form.find("input[name='name']").val("");
    $form.find("input[name='typeName']").val("");
    $form.find("input[name='username']").val("");
    $form.find("input[name='useridx']").val("");
    $form.find("input[name='phone']").val("");
    $form.find("input[name='email']").val("");
    $form.find("input[name='telephone']").val("");
    $form.find("input[name='inviteCode']").val("");
    $form.find("input[name='country']").val("");
    $form.find("input[name='pCDistrict']").val("");
    $form.find("input[name='address']").val("");
    /*$form.find("input[name='paymentType']").val("");
    $form.find("input[name='businessTime']").val("");
    $form.find("input[name='product']").val("");
    $form.find("input[name='avgPrice']").val("");
    $form.find("input[name='impressions']").val("");
    $form.find("input[name='attach']").val("");*/
    $form.find("input[name='registrationNumber']").val("");
    $form.find("input[name='status']").val("");
    $form.find("input[name='shopUserId']").val("");
    $form.find("input[name='businessProof']").val("");
    $form.find("input[name='storeImage']").val("");
    $form.find("input[name='images']").val("");
    //清空Div中的img

    $("#businessProofDiv").html('');
    $("#baseInfoStoreDiv").html('');
    $("#baseInfoProductDiv").html('');
    $MB.closeAndRestModal("merchant-review");
    // $(".merchant-table-form")[0].reset();
    // $MB.refreshTable('merchantInfoTable');
}