package model;

import java.io.Serializable;

public class UserInfoBeans implements Serializable{
   
	//ユーザの情報を格納する
	
	/**
	 * @code 従業員番号
	 * @name　従業員名
	 * @post　役職
	 * @department　部署
	 * @authority　権限
	 */
	private int code;
	private String name;
	private String post;
	private String department;
	private String authority;
	
	public UserInfoBeans() {
		
	}
	
	public UserInfoBeans(int code,String name,String post,String department) {
		this.setCode(code);
		this.setName(name);
		this.setPost(post);
		this.setDepartment(department);
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
