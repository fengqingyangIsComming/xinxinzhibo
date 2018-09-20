package cc.mrbird.common.cedatasource;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源上下文管理
 */
public class DynamicDataSourceContextHolder {


    private static Logger logger = Logger.getLogger(DynamicDataSourceContextHolder.class);
    /*
     * 存放当前线程使用的数据源类型信息
     * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /*
     * 管理所有的数据源id;
     * 主要是为了判断数据源是否存在;
     */
    public static List<String> dataSourceIds = new ArrayList<>();


    /**
     * 设置数据源
     * 使用setDataSourceType设置当前的
     */
    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }


    /**
     * 获取数据源
     * 获取当前线程中的数据源
     */
    public static String getDataSourceType(){
        return contextHolder.get();
    }

    /**
     * 清除数据源
     * 删除当前线程池中的数据源
     */
    public static void clearDataSourceType(){
        contextHolder.remove();
    }

    /**
     * 判断当前数据源是否存在
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}