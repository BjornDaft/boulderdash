package controller;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


@SuppressWarnings("unused")
public class UserOrderTest {
	
	private Order order;
	
	@Test
	public void testGetOrder() {
		
		try{
	        assertNotNull(this.order);//check if the object is != null
	        //checks if the returned object is of class Expression
	        assertTrue(this.order instanceof Order);
	        
	    }catch(Exception e){
	        // let the test fail, if your function throws an Exception.
	        fail("got Exception, i want an Expression");
	     }
	}

}
