/*****************************************************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package online.shixun.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service 基类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public abstract class BaseService {

    //日志处理器
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据总记录数和每页显示记录数，计算总页数
     * @param totalCount
     * @param pageSize
     * @return
     */
    protected int countTotalPage(int totalCount, int pageSize) {
        int count = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            count++;
        }
        return count;
    }
}
