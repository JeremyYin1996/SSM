package com.sqc.bean;

public class Category {
    private String categId;

    private String categName;

    private String level;

    private String parentId;
    
    //与自身联合查询的需要
    Category parentCategory;

    private Boolean ifDeleted;

    private String deleteUser;

    
    
    
    public Category() {
		super();
	}

	public Category(String categId, String categName, String level, String parentId) {
		super();
		this.categId = categId;
		this.categName = categName;
		this.level = level;
		this.parentId = parentId;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getCategId() {
        return categId;
    }

    public void setCategId(String categId) {
        this.categId = categId == null ? null : categId.trim();
    }

    public String getCategName() {
        return categName;
    }

    public void setCategName(String categName) {
        this.categName = categName == null ? null : categName.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Boolean getIfDeleted() {
        return ifDeleted;
    }

    public void setIfDeleted(Boolean ifDeleted) {
        this.ifDeleted = ifDeleted;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }
}