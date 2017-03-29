package com.ynu.dinnerorder.databasemodel;

import java.util.Date;

public class ItemModel {
	/*
	 * @Author:��Сѩ
	 * @Test:ͨ��
	 */
    
	/*
	 * �������ڴ�model�����ݽṹ
	 */
	private int Item_id;//�û��Ѿ���Ĳ�ƷƷ��id
	private int Item_state;//�û��Ѿ���Ĳ�Ʒ��״̬
	private Date Item_date;//�û����ʱ������
	private int Item_num;//�û��Ѿ���Ĳ�Ʒ������
	private double Item_totalprice;//�û��Ѿ���Ĳ�Ʒ���ܽ��
	private String OrderId;
	
	/*
	 * ����ԭ�����������model�����ݽṹ��������ͨ����һ����ѯ�õ���Ҫ�ĵ��ģ�����˵
	 * ���������������
	 */
	private DishModel dishm;//�����������Ʒid
	private DeskModel deskm;//�����������λid
	private NormalUserModel n_user_m;//�����������ͨ�û�id
	private WaiterModel waiterm;//�������������Աid
	
	public ItemModel(){
		
	}
	
	public ItemModel(int item_id, int item_state, Date item_date, int item_num, double item_totalprice, DishModel dishm,
			DeskModel deskm, NormalUserModel n_user_m, WaiterModel waiterm) {
		super();
		Item_id = item_id;
		Item_state = item_state;
		Item_date = item_date;
		Item_num = item_num;
		Item_totalprice = item_totalprice;
		this.dishm = dishm;
		this.deskm = deskm;
		this.n_user_m = n_user_m;
		
		this.waiterm = waiterm;
	}
	
	

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public int getItem_state() {
		return Item_state;
	}

	public void setItem_state(int item_state) {
		Item_state = item_state;
	}

	public Date getItem_date() {
		return Item_date;
	}

	public void setItem_date(Date item_date) {
		Item_date = item_date;
	}

	public int getItem_num() {
		return Item_num;
	}

	public void setItem_num(int item_num) {
		Item_num = item_num;
	}

	public double getItem_totalprice() {
		return Item_totalprice;
	}

	public void setItem_totalprice(double item_totalprice) {
		Item_totalprice = item_totalprice;
	}

	public DishModel getDishm() {
		return dishm;
	}

	public void setDishm(DishModel dishm) {
		this.dishm = dishm;
	}

	public DeskModel getDeskm() {
		return deskm;
	}

	public void setDeskm(DeskModel deskm) {
		this.deskm = deskm;
	}

	public NormalUserModel getN_user_m() {
		return n_user_m;
	}

	public void setN_user_m(NormalUserModel n_user_m) {
		this.n_user_m = n_user_m;
	}


	public WaiterModel getWaiterm() {
		return waiterm;
	}

	public void setWaiterm(WaiterModel waiterm) {
		this.waiterm = waiterm;
	}
	
	
	
	
}
