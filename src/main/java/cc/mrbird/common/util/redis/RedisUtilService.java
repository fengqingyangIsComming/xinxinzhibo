package cc.mrbird.common.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service("redisUtilService")
public class RedisUtilService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOps;

    /**
     * 根据指定key获取String
     *
     * @param key
     * @return
     */
    public String getStr(String key) {
        return valOpsStr.get(key);
    }

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     */
    public void setStr(String key, String val) {
        valOpsStr.set(key, val);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    public Object getObj(Object o) {
        return valOpsObj.get(o);
    }

    /**
     * 设置obj缓存
     *
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2) {
        valOpsObj.set(o1, o2);
    }

    /**
     * 设置obj缓存
     *
     * @param o1
     * @param o2
     */
    public void setMap(String o1, Map<String, String> o2) {
        hashOps.putAll(o1, o2);
    }

    /**
     * 根据指定o1获取Map
     *
     * @param o1
     */
    public Map<String, String> getMap(String o1) {
        Map<String, String> map = new HashMap<String, String>();
        Set set = hashOps.keys(o1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            Object value = hashOps.get(o1, key);
            map.put(key, value.toString());
        }
        return map;
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    public void delObj(Object o) {
        redisTemplate.delete(o);
    }
}
