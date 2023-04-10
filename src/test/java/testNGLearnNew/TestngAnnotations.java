package testNGLearnNew;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class TestngAnnotations {
		
		/*
		 * BeforeSuite
		 * BeforeTest
		 * BeforeClass
		 * BeforeMethod
		 * Test
		 * AfterMethod
		 * AfterClass
		 * AfterTest
		 * AfterSuite  
		 * 
		 * for 100 test cases, 2 Tests (Sanity and Smoke), 10 Classes
		 * 1 BS
		 * 2 BT (Once for each test group)
		 * 10 BC (once for each Class)
		 * 100 BM
		 * 100 @Test
		 * 100 AM
		 * 10 AC
		 * 2 AT
		 * 1 AS
		 * 
		 * 
		 */
		
		@BeforeSuite
		public void beforeSuite()
		{
			System.out.println("This will be executed before the complete Test Suite");
		}
		
		@BeforeTest
		public void beforeTest()
		{
			System.out.println("This will be executed before each Test suite");
		}
		
		@BeforeClass
		public void beforeClass()
		{
			System.out.println("This will be executed before each class");
		}
		
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("This will be executed before each @Test method");
		}
		
		
		/*
		 * priority
		 * enabled
		 * alwaysRun
		 * dependsOnMethods
		 */
		
		@Test (priority=3,enabled=false)
		public void testCase1()
		{
			System.out.println("Test Case 1");
		}
		
		@Test (priority=2, alwaysRun=true)
		public void testCase2()
		{
			System.out.println("Test Case 2");
		}
		
		@Test (priority=1)
		public void testCase3()
		{
			System.out.println("Test Case 3");
		}
		
		
		@Test(dependsOnMethods="testCase3")
		public void testCase4()
		{
			System.out.println("Test case 4");
		}
		
		
		@AfterSuite
		public void afterSuite()
		{
			System.out.println("This will be executed after the complete Test Suite");
		}
		
		@AfterTest
		public void afterTest()
		{
			System.out.println("This will be executed after each Test suite");
		}
		
		@AfterClass
		public void afterClass()
		{
			System.out.println("This will be executed after each class");
		}
		
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("This will be executed after each @Test method");
		}
		
		

	}



