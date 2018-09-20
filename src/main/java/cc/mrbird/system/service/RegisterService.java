package cc.mrbird.system.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.system.domain.ShopType;
import org.springframework.cache.annotation.CacheConfig;

/**
 * Created by WYZ on 2018/9/4.
 */
@CacheConfig(cacheNames = "RegisterService")
public interface RegisterService extends IService<ShopType> {

}
