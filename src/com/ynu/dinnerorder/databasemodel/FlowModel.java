package com.ynu.dinnerorder.databasemodel;

public class FlowModel {
	/*
	 * @Author:��Ծ
	 * @Test:ͨ��
	 */
	
	private int Flow_id;//��ˮ��id,û������Ĺ���
	
	private OrderModel orderM;//�������������,����������id,�Ͷ���������
	
	public FlowModel(){
		
	}

	public FlowModel(int flow_id, OrderModel orderM) {
		super();
		Flow_id = flow_id;
		this.orderM = orderM;
	}

	public int getFlow_id() {
		return Flow_id;
	}

	public void setFlow_id(int flow_id) {
		Flow_id = flow_id;
	}

	public OrderModel getOrderM() {
		return orderM;
	}

	public void setOrderM(OrderModel orderM) {
		this.orderM = orderM;
	}
	
	
}
