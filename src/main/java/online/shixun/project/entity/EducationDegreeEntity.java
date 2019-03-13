/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.entity;

/**
 * 教育程度实体类
 */
public class EducationDegreeEntity extends BaseEntity {

	private static final long serialVersionUID = -3861565861976644526L;
	
	private String name;

    public EducationDegreeEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
