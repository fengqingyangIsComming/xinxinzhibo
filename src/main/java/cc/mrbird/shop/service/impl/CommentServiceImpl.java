package cc.mrbird.shop.service.impl;

import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.shop.dao.CommentMapper;
import cc.mrbird.shop.domain.DpComment;
import cc.mrbird.shop.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/5 13:57
 */
@Service("commentService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
//extends BaseService<DpComment>
public class CommentServiceImpl  implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    ObjectMapper objectMapper;*/

    /*@Override
    public List<DpComment> findByComment(DpComment dpComment) {
        try {
            Example example = new Example(DpComment.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(dpComment.getLevelcontent())) {
                criteria.andCondition("levelcontent like", "%" +dpComment.getLevelcontent()+ "%");
            }
//            if (StringUtils.isNotBlank(dpComment.getShopId()+"")) {
//                criteria.andCondition("shop_id =", dpComment.getShopId());
//            }
            if (StringUtils.isNotBlank(dpComment.getTimeField())) {
                String[] timeArr = dpComment.getTimeField().split("~");
                criteria.andCondition("date_format(created,'%Y-%m-%d') >=", timeArr[0]);
                criteria.andCondition("date_format(created,'%Y-%m-%d') <=", timeArr[1]);
            }
            example.setOrderByClause("created desc");
            return this.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取评论列表失败", e);
            return new ArrayList<>();
        }
    }*/

    @Override
    public List<Map> findByComment(DpComment dpComment) {
        try {

            return this.commentMapper.findByComment(dpComment);
        } catch (Exception e) {
            logger.error("获取评论列表失败", e);
            return new ArrayList<>();
        }
    }

    /**
     * 根据id查询评论信息
     * @param dpComment
     * @return
     */
    @Override
    public DpComment findById(DpComment dpComment) {
        return this.commentMapper.findById(dpComment);
    }


}
