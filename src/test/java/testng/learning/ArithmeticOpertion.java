package testng.learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOpertion {

	@Test(groups = {"smoke"} )
	public void sumTwoNo() {
		
		System.out.println(2+3);
		
	}
	
	@Test
	public void sumThreeNo() {
		
		System.out.println(2+3+5);
		Assert.assertEquals(2+3+5, 5);
		
	}
	
	@Test(groups = {"smoke"} )
	public void subTwoNo() {
		
		System.out.println(8-4);
		Assert.assertEquals(8-4, 6);
		
	}
	
	@Test
	public void subThreeNo() {
		
		System.out.println(8-4-2);
		
	}
	
	@Test(groups = {"smoke","critical usecase"} )
	public void mulTwoNo() {
		
		System.out.println(5*4);
		Assert.assertEquals(5*2, 20);
		
	}
	
	@Test
	public void mulThreeNo() {
		
		System.out.println(5*4*2);
		
	}
	
	@Test
	public void divTwoNo() {
		
		System.out.println(10/2);
		Assert.assertEquals(10/2, 10);
		
	}
	
	@Test
	public void divThreeNo() {
		
		System.out.println(10/2/5);
		
	}
}
