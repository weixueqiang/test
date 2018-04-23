package com.gray.user.entity;

public class SysPermission implements java.io.Serializable{
    /**
	 * @date 2018年4月20日 下午7:52:35
	 * @author 魏雪强
	 */
	private static final long serialVersionUID = 7736670293447488584L;

	private Integer id;
    private String name;
    private Long parentId;
    private String sort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


   
}
