package com.ynu.dinnerorder.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ynu.dinnerorder.databaseConnection.Jdbc;
import com.ynu.dinnerorder.databasemodel.NormalUserModel;


public class NormalUserDao {
	/*
	 * @Author:��Сѩ
	 * @TestState:ͨ��
	 */
	
	
	/*
	 * ��ͨ�û���½
	 */
	public NormalUserModel loginNormalUser(String nu_name,String nu_password){
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		//��ȡ���ݿ�����
		NormalUserModel num=null;
		String sql="select * from "
				+ "normaluser where nu_name=? and nu_password=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			//ִ��sql���
			psmt.setString(1,nu_name);
			//���ò���1
			psmt.setString(2, nu_password);
			//���ò���2
			ResultSet rs=psmt.executeQuery();
			//���в�ѯ
			if(rs.next()){
				//�����ѯ������ڣ���ô����WaiterModel���󣬲��Ҹ�ֵ
				num=new NormalUserModel();
				num.setNu_id(rs.getInt("nu_id"));
				num.setNu_name(rs.getString("nu_name"));
				num.setNu_password(rs.getString("nu_password"));
				num.setNu_telephone(rs.getString("nu_telephone"));
				num.setNu_address(rs.getString("nu_address"));
			}else{
				//�����ѯ��������ڣ���ô�򲻴�������
				num=null;
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	/*
	 * ��ͨ�û�ע��
	 */
	public boolean registerNormalUser(String nu_name,String nu_password,
			String nu_telephone,String nu_address){
		boolean b=false;
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		String sql1="select * from normaluser where nu_name=?";
		//����ͨ�û����в�ѯ���û����Ƿ����
		String sql2="insert into normaluser(nu_name,nu_password,nu_telephone,nu_address)values"
				+ "(?,?,?,?)";
		//д����ͨ�û�������
		PreparedStatement psmt1;
		PreparedStatement psmt2;
		try {
			psmt1=con.prepareStatement(sql1);
			psmt1.setString(1, nu_name);
			ResultSet rs=psmt1.executeQuery();
			if(rs.next()){
				b=false;
			}else{
				b=true;
				psmt2=con.prepareStatement(sql2);
				//ִ��sql���
				psmt2.setString(1, nu_name);
				//���ò���1
				psmt2.setString(2, nu_password);
				//���ò���2
				psmt2.setString(3, nu_telephone);
				//���ò���3
				psmt2.setString(4, nu_address);
				//���ò���4
				
				psmt2.execute();
				//ִ�в���
				psmt2.close();
				//�ر�ִ�ж���
			}
			rs.close();
			psmt1.close();
			con.close();
			//�ر����ݿ��������в���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	/*
	 * ������ͨ�û���Ϣ
	 */
	public NormalUserModel updateNormalUser(String nu_newname,String nu_newpassword,
			String nu_newtelephone,String nu_newaddress,int nu_id)
	{
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		NormalUserModel num=null;
		String sql="update normaluser set nu_name=?,nu_password=?,nu_telephone=?,"
				+ "nu_address=? where nu_id=?";
		PreparedStatement psmt;
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, nu_newname);
			psmt.setString(2, nu_newpassword);
			psmt.setString(3, nu_newtelephone);
			psmt.setString(4, nu_newaddress);
			psmt.setInt(5, nu_id);
			psmt.execute();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	/*
	 * ͨ����ͨ�û�id����ѯ������û���������Ϣ
	 */
	public NormalUserModel equeryN_User(int nu_id){
		NormalUserModel NUM=null;
		//����ָ��
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		//��ȡ���ݿ�����
		String sql="select * from normaluser where nu_id=?";
		PreparedStatement psmt;
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, nu_id);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				NUM=new NormalUserModel();
				NUM.setNu_id(nu_id);
				NUM.setNu_name(rs.getString("nu_name"));
				NUM.setNu_telephone(rs.getString("nu_telephone"));
				NUM.setNu_address(rs.getString("nu_address"));
			}else{
				NUM=null;
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NUM;
	}
	
	/*
	 * ɾ����ͨ�û�����Ϣ
	 */
	public boolean deleteNormalUser(int nu_id){
		boolean b=false;
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		String sql1="select * from normaluser where nu_id=?";
		String sql2="delete from normaluser where nu_id=?";
		PreparedStatement psmt1;
		PreparedStatement psmt2;
		
		try {
			psmt1=con.prepareStatement(sql1);
			psmt1.setInt(1, nu_id);
			ResultSet rs=psmt1.executeQuery();
			if(rs.next()){
				b=true;
				psmt2=con.prepareStatement(sql2);
				psmt2.setInt(1,nu_id);
				psmt2.execute();
				psmt2.close();
			}else{
				b=false;
			}
			rs.close();
			psmt1.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public NormalUserModel equeryN_UserByName(String nu_name){
		NormalUserModel NUM=null;
		//����ָ��
		Jdbc j=new Jdbc();
		Connection con=j.getConnection();
		//��ȡ���ݿ�����
		String sql="select * from normaluser where nu_name=?";
		PreparedStatement psmt;
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, nu_name);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				NUM=new NormalUserModel();
				NUM.setNu_id(rs.getInt("nu_id"));
				NUM.setNu_name(rs.getString("nu_name"));
				NUM.setNu_telephone(rs.getString("nu_telephone"));
				NUM.setNu_address(rs.getString("nu_address"));
			}else{
				NUM=null;
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NUM;
	}
}
