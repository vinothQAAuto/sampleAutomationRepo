package selenium_AllControls;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class sampleTestNG {
	

//	   @BeforeClass
//	    public void setUp1() {
//	        
//	        System.out.println("Launch the browser1");
//	      
//	    }
	
	   @BeforeMethod
	    public void setUp2() {
	        
	        System.out.println("Launch the browser2");
	      
	    }
//	   
//	   @BeforeTest
//	    public void setUp3() {
//	        
//	        System.out.println("Launch the browser3");
//	      
//	    }
	   
	   @Test
	    public void setUp41() {
	        
	        System.out.println("Launch the browser");
	      
	    }
	   
	   
	   @Test
	    public void setUp42() {
	        
	        System.out.println("Launch the browser");
	      
	    }
	   
	   @Test
	    public void setUp43() {
	        
	        System.out.println("Launch the browser");
	      
	    }
	   
//	   @AfterTest
//	    public void teardowns() {
//	        System.out.println("close the browser1");
//	      
//	    }
//	   
//	
////
	    @AfterMethod
	    public void tearDownss() {
	      
	            System.out.println("Close the browser2");
	        }
	   
	    
//	    @AfterClass
//	    public void tearDownsss() {
//	      
//	            System.out.println("Close the browser3");
//	        }
	    
	    
	    
	}

