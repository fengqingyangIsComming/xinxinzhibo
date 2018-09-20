

//关闭弹框方法
function commentDetailClose() {
    var $form = $('#comment-detail-form');
    $form.find("input[name='name']").val("");
    $form.find("input[name='levelcontent']").val("");
    $form.find("input[name='content']").val("");
    //清空Div中的img
    $("#productDiv").find("img[id='commentDetailProductImg']").remove();

    $MB.closeAndRestModal("comment-detail");
    //$(".comment-table-form")[0].reset();
    //$MB.refreshTable('commentTable');
}