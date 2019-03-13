/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.entity;

/**
 * 爱好实体类
 */
public class HobbyEntity extends BaseEntity {

    //名称
    private String name;

    //排序
    private Integer indexNo;

    public HobbyEntity() {
    }

    public HobbyEntity(String name, Integer indexNo, String language) {
        this.name = name;
        this.indexNo = indexNo;
        this.language = language;
    }

    public HobbyEntity(Long id, String name, Integer indexNo, String language) {
        this.id = id;
        this.name = name;
        this.indexNo = indexNo;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

}
