package com.ynu.dinnerorder.databasemodel;

public class NormalUserModel {
	/*
	 * @Author:��Сѩ
	 */
	private int nu_id;
	//��ͨ�û���id
	private String nu_name;
	//��ͨ�û����û���
	private String nu_password;
	//��ͨ�û�������
	private String nu_telephone;
	//��ͨ�û��ĵ绰
	private String nu_address;
	//��ͨ�û��ĵ�ַ
	
	public NormalUserModel(){
		
	}
	
	
	public NormalUserModel(int nu_id, String nu_name, String nu_password, String nu_telephone, String nu_address) {
		super();
		this.nu_id = nu_id;
		this.nu_name = nu_name;
		this.nu_password = nu_password;
		this.nu_telephone = nu_telephone;
		this.nu_address = nu_address;
	}
	
	public int getNu_id() {
		return nu_id;
	}
	public void setNu_id(int nu_id) {
		this.nu_id = nu_id;
	}
	public String getNu_name() {
		return nu_name;
	}
	public void setNu_name(String nu_name) {
		this.nu_name = nu_name;
	}
	public String getNu_password() {
		return nu_password;
	}
	public void setNu_password(String nu_password) {
		this.nu_password = nu_password;
	}
	public String getNu_telephone() {
		return nu_telephone;
	}
	public void setNu_telephone(String nu_telephone) {
		this.nu_telephone = nu_telephone;
	}
	public String getNu_address() {
		return nu_address;
	}
	public void setNu_address(String nu_address) {
		this.nu_address = nu_address;
	}
	

}
