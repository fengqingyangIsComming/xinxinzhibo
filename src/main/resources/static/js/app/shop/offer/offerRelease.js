//优惠发布
function offerRelease() {

    if($("input[name='type']:checked").val()==2){
        if($("input[name='sale']").val().length==0){
            $MB.n_danger("折扣券优惠必填！！！");
            return;
        }
    }else{
        if($("input[name='man']").val().length==0 || $("input[name='jian']").val().length==0){
            $MB.n_danger("满减券满减必填！！！");
            return;
        }
    }
    var $form = $(".offerRelease-table-form");
    $.post(ctx + "offerRelease/review",$form.serialize(), function (r) {

        if (r.code===0){
            $MB.n_success(r.msg);
        }else {
            $MB.n_danger(r.msg);
        }
    })
}