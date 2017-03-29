package com.ynu.dinnerorder.databasemodel;

public class DishModel {
	/*
	 * @Author:��Ծ
	 * @Test:ͨ��
	 */
	private int dish_id;//��Ʒ��id
	private String dish_name;//��Ʒ������
	private  double dish_price;//��Ʒ�ļ۸�
	private String dish_description;//��Ʒ������
	private String dish_image;//��Ʒ��ͼƬ
	
	public DishModel(int dish_id, String dish_name, double dish_price, String dish_description, String dish_image) {
		super();
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_price = dish_price;
		this.dish_description = dish_description;
		this.dish_image = dish_image;
	}
	
	public DishModel(){
		
	}

	public int getDish_id() {
		return dish_id;
	}

	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public double getDish_price() {
		return dish_price;
	}

	public void setDish_price(double dish_price) {
		this.dish_price = dish_price;
	}

	public String getDish_description() {
		return dish_description;
	}

	public void setDish_description(String dish_description) {
		this.dish_description = dish_description;
	}

	public String getDish_image() {
		return dish_image;
	}

	public void setDish_image(String dish_image) {
		this.dish_image = dish_image;
	}

	
}
