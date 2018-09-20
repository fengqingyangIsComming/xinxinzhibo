package cc.mrbird.shop.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.shop.domain.DpComment;

import java.util.List;
import java.util.Map;

public interface CommentService  {
    List<Map> findByComment(DpComment dpComment);

    DpComment findById(DpComment dpComment);
}
