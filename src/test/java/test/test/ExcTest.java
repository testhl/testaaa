package test.test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.common.ExcRead;



public class ExcTest {


	
	
	@DataProvider(name = "A")
	public Object[][] dataT(){
		ExcRead ex=new ExcRead();
		return ex.testDate("C:\\Users\\k\\Desktop\\aaaaaaaaa\\a.xls","Sheet2");
	}

	
	@Test(dataProvider="A")
	public void testT(HashMap<String,String> data)  {
		System.out.println(data.get("user"));
		System.out.println(data.get("password"));
		System.out.println(data.get("type"));
		System.out.println(data.get("day"));
	}
}
