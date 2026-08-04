package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGSample {
	
	//pre condition
	@BeforeClass
	public static void A()
	{
		System.out.println("TestA");
	}
	
	
	@BeforeMethod
	public static void SetUp()
	{
		System.out.println("Lanunch browser");
		
		//Browser Launch
	}
	
	@BeforeTest
	public static void C()
	{
		System.out.println("Browser Launched");
	}
	
	@Test
	public static void VinoMinds()
	{
		System.out.println("TestVinominds");
	}
	
	
	@Test
	public static void AVinoMinds()
	{
		System.out.println("TestVinominds");
	}
	
	
	
	@AfterTest
	public static void C1()
	{
		System.out.println("TestC1");
	}
	
	
	@AfterMethod
	public static void tearDown()
	{
		System.out.println("Exit successfully");
		
		//Browser exit
	}
	
	
	@AfterClass
	public static void E()
	{
		System.out.println("class closed");
	}

}
