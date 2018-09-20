package cc.mrbird.shop.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.shop.domain.DpComment;

import java.util.List;
import java.util.Map;

public interface CommentMapper  {


    DpComment findById(DpComment dpComment);

    List<Map> findByComment(DpComment dpComment);
}
