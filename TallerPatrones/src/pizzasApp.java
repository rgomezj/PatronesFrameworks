import java.util.Date;
import Abstract.BillingService;
import Entities.CreditCard;
import Entities.PizzaOrder;
import Entities.Receipt;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class pizzasApp {

	public static void main(String[] args) {
		
		/*
	     * Guice.createInjector() takes your Modules, and returns a new Injector
	     * instance. Most applications will call this method exactly once, in their
	     * main() method.
	     */
		 Injector injector = Guice.createInjector(new BillingModule());

		 PizzaOrder pizza = new PizzaOrder();
		 pizza.setAmount(45000);
		 pizza.setOrderDate(new Date());
		 
		 CreditCard credit = new CreditCard();
		 credit.setNumber("");
		 credit.setDueMonth(12);
		 credit.setDueYear(2016);
		 credit.setFullName("Roger Gomez Jaramillo");
		 
	    BillingService billingService = injector.getInstance(BillingService.class);
	    Receipt receipt = billingService.chargeOrder(pizza, credit);
	    System.out.println(receipt.getMessage());
	    
	}

}
