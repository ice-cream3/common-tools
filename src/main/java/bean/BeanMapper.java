package bean;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.*;

/**
 * @Description: BeanMapper
 * @author: ice
 * @Date: 2020/4/13 19:10
 *
 *
 * <dependency>
 *             <groupId>net.sf.dozer</groupId>
 *             <artifactId>dozer</artifactId>
 *             <version>5.5.1</version>
 *         </dependency>
 * dozer进行bean拷贝时很消耗性能,
 * 建议使用BeanCopierUtils拷贝,
 * BeanCopierUtils拷贝需要注意:
 *     当使bean使用(@Accessors(chain = true))
       lombok.experimental.Accessors的链式set值时无法进行数据的拷贝,
       如:
            @Data
            @Accessors(chain = true)
            public class AgentRule{}
            Rule a = new Rule().setId(1).setName("a").setCreateTime(new Date());
       解决办法:使用hutool的bean拷贝,dozen拷贝,springbean拷贝工具
 */ 
public class BeanMapper {
    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static final DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source==null){
            return null;
        }
        return dozer.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        Map map = new LinkedHashMap(6);
        map.put(1,1);
        List<T> destinationList = Lists.newArrayList();
        if (sourceList==null||sourceList.isEmpty()){
            return destinationList;
        }
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }
}
