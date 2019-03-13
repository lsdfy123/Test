/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.entity;

/**
 * 专业技能实体类
 */
public class SkillEntity extends BaseEntity {

    //名称
    private String name;

    //掌握程度
    private Integer level = 50;

    //排序
    private Integer indexNo;

    public SkillEntity() {
    }

    public SkillEntity(String name, Integer level, Integer indexNo, String language) {
        this.name = name;
        this.level = level;
        this.indexNo = indexNo;
        this.language = language;
    }

    public SkillEntity(Long id, String name, Integer level, Integer indexNo, String language) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.indexNo = indexNo;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

}
