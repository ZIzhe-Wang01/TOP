package com.top.utlis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResult<T> implements Serializable {
	
	private static final long serialVersionUID = 8800028898646527257L;
	
	private Long total;//总记录数
	private Integer totalPage;
	private Integer currentPage;//当前页
	private Integer rows;//每页显示条数
	private List<T> list;//当前页结果
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
	
}
