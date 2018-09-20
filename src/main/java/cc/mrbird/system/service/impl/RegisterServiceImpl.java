package cc.mrbird.system.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.system.domain.ShopType;
import cc.mrbird.system.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WYZ on 2018/9/4.
 */
@Service("registerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RegisterServiceImpl extends BaseService<ShopType> implements RegisterService {


}
