package testng.learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriortiesTestNg {
	
	@Test(priority = 0)
	public void sumTwoNo() {
		
		System.out.println(2+3);
		
	}
	
	@Test(priority = 2)
	public void sumThreeNo() {
		
		System.out.println(2+3+5);
		//Assert.assertEquals(2+3+5, 5);
		
	}
	
	@Test(priority = 1)
	public void subTwoNo() {
		
		System.out.println(8-4);
		//Assert.assertEquals(8-4, 6);
		
	}
	
	@Test(priority = 4)
	public void subThreeNo() {
		
		System.out.println(8-4-2);
		
	}
	
	@Test(priority = 3)
	public void mulTwoNo() {
		
		System.out.println(5*4);
		//Assert.assertEquals(5*2, 20);
		
	}
	
	@Test(priority = -2)
	public void mulThreeNo() {
		
		System.out.println(5*4*2);
		
	}
	
	@Test(priority = -1)
	public void divTwoNo() {
		
		System.out.println(10/2);
		//Assert.assertEquals(10/2, 10);
		
	}
	
	@Test(priority = 1)
	public void divThreeNo() {
		
		System.out.println(10/2/5);
		
	}

}
