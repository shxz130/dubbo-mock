package com.github.dumock.dubbo.reference;

/**
 * Created by jetty on 18/6/29.
 */
public interface DubboReferenceService {

    /**
     * 引用下游系统dubbo服务
     *
     * @param intefaceName
     * @param group
     * @param version
     * @param isGeneric
     * @return
     */
    public Object reference(String intefaceName,String group,String version,boolean isGeneric);

}
