package testng.learning;

import org.testng.annotations.Test;

public class TestNgGroupsLearning {

	@Test
	public void sumTwoNo() {
		
		System.out.println(2+3);
		
	}
	
	@Test
	public void sumThreeNo() {
		
		System.out.println(2+3+5);
		
	}
	
	@Test
	public void subTwoNo() {
		
		System.out.println(8-4);
		
	}
	
	@Test
	public void subThreeNo() {
		
		System.out.println(8-4-2);
		
	}
	
	@Test(groups = {"smoke"} )
	public void mulTwoNo() {
		
		System.out.println(5*4);
		
	}
	
	@Test(groups = {"smoke"} )
	public void mulThreeNo() {
		
		System.out.println(5*4*2);
		
	}
	
	@Test(groups = {"critical usecase"} )
	public void divTwoNo() {
		
		System.out.println(10/2);
		
	}
	
	@Test
	public void divThreeNo() {
		
		System.out.println(10/2/5);
		
	}
	
}
