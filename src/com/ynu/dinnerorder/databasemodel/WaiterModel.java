package com.ynu.dinnerorder.databasemodel;


public class WaiterModel {
	/*
	 * @Author:��Сѩ
	 */
	private int w_id;
	//����Աid
	private String w_name;
	//����Ա����
	private String w_password;
	//����Աû����
	private String w_telephone;
	//����Ա�绰
	private String w_actor;
	//����Ա��ɫ
	private String w_sex;
	//����Ա�Ա�
	
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_password() {
		return w_password;
	}
	public void setW_password(String w_password) {
		this.w_password = w_password;
	}
	public String getW_telephone() {
		return w_telephone;
	}
	public void setW_telephone(String w_telephone) {
		this.w_telephone = w_telephone;
	}
	public String getW_actor() {
		return w_actor;
	}
	public void setW_actor(String w_actor) {
		this.w_actor = w_actor;
	}
	public String getW_sex() {
		return w_sex;
	}
	public void setW_sex(String w_sex) {
		this.w_sex = w_sex;
	}
	public WaiterModel(int w_id, String w_name, String w_password, String w_telephone, String w_actor, String w_sex) {
		
		this.w_id = w_id;
		this.w_name = w_name;
		this.w_password = w_password;
		this.w_telephone = w_telephone;
		this.w_actor = w_actor;
		this.w_sex = w_sex;
	}
	
	public WaiterModel(){
		
	}

}
