package testng.learning;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterLearning {
	
	@Test
	@Parameters({"browser","keyword1","keyword2"})
	public void parameterLearning(String brow, String k1, String k2) {
		

		System.out.println(brow);
		System.out.println(k1);
		System.out.println(k2);
		
	}

}
