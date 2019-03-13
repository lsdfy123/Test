/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.entity;

/**
 * 工作状态实体类
 */
public class WorkingStatusEntity extends BaseEntity {

	private static final long serialVersionUID = -2091795612582005466L;
	
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
