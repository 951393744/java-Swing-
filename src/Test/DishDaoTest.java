package Test;

import java.util.List;

import com.ynu.dinnerorder.databasedao.DishDao;
import com.ynu.dinnerorder.databasemodel.DishModel;

public class DishDaoTest {

	public static void main(String[] args) {
		DishDao DD=new DishDao();
//		DD.addDish("�������빽", 25.5, "�ó�����ζ", "hj");
//		boolean b=DD.updateDishInfBy_Id("�������빽", 26.6, "", "", 1);
//		System.out.println(b);
//		DishModel dm=DD.equeryDishInfBy_id(1);
//		System.out.println(dm.getDish_name()+"  "+dm.getDish_price());
//		List<DishModel> ldm=DD.equeryDishInfBy_name("���빽");
//		for(DishModel dm:ldm){
//			System.out.println(dm.getDish_id()+" "+dm.getDish_name()+" "+dm.getDish_price()+" "+dm.getDish_description());
//		}
//		DishModel dm=DD.equeryDishInfBy_name("");
//		System.out.println(dm.getDish_name()+"  "+dm.getDish_price());
//		DD.deleteDish(1);
		
		List<DishModel> ldm=DD.equeryAllDish();
		for(DishModel dm:ldm){
			System.out.println(dm.getDish_id()+" "+dm.getDish_name()+" "+dm.getDish_price()+" "+dm.getDish_description());
		}
	}

}
