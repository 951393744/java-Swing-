package Test;

import com.ynu.dinnerorder.databasedao.NormalUserDao;
import com.ynu.dinnerorder.databasemodel.NormalUserModel;

public class NormalUserDaoTest {

	public static void main(String[] args) {
		NormalUserDao nud=new NormalUserDao();
//		boolean b=nud.registerNormalUser("С��", "12345678", "158745", "����У��");
//		System.out.println(b);
//		NormalUserModel num=nud.loginNormalUser("С��", "12345678");
//		if(num==null){
//			System.out.println("��¼ʧ��");
//		}else{
//			System.out.println("��½�ɹ�");
//			System.out.println(num.getNu_address()+num.getNu_id()+num.getNu_password()+num.getNu_telephone()+num.getNu_name());
//		}
//		nud.updateNormalUser("С��", "00", "35", "25", 1001);
//		nud.registerNormalUser("xiao", "","","",500001);
//		NormalUserModel num=nud.equeryN_User(500001);
//		System.out.println(num.getNu_id()+num.getNu_name()+num.getNu_password()+num.getNu_address()+num.getNu_telephone());
		boolean b=nud.deleteNormalUser(500001);
		if(b=false){
			System.out.println("ɾ��ʧ��");
		}else{
			System.out.println("ɾ���ɹ�");
		}
	}

}
