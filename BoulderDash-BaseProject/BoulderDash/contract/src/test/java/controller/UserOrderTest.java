package controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class UserOrderTest {
	
	@Before
	public void setup(){
		this.order = new UserOrder(Order.UP);
	}
	
	private UserOrder order;
	
	@Test
	public void testGetOrder() {
		
		try{
	        assertNotNull(this.order);//check if the object is != null
	        //checks if the returned object is of class Expression
	        equals(order.getOrder() instanceof Order);
	        
	    }catch(Exception e){
	        // let the test fail, if your function throws an Exception.
	        fail("got Exception, i want an Expression");
	     }
	}

}
