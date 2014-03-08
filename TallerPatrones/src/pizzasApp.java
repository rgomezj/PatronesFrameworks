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
		 credit.setCountryName("England");
		 credit.setNumber("123");
		 credit.setDueMonth(12);
		 credit.setDueYear(2016);
		 credit.setFullName("");
		 
	    BillingService billingService = injector.getInstance(BillingService.class);
	    Receipt receipt = billingService.chargeOrder(pizza, credit);
	    System.out.println("Master card:" + receipt.getMessage());
	    
	    CreditCard creditCardVisa = new CreditCard();
	    creditCardVisa.setCountryName("Colombia");
	    creditCardVisa.setNumber("");
	    creditCardVisa.setDueMonth(12);
	    creditCardVisa.setDueYear(2016);
	    creditCardVisa.setFullName("Roger Gomez Jaramillo");
	    
	    receipt = billingService.chargeOrder(pizza, creditCardVisa);
	    System.out.println("Visa Card:" + receipt.getMessage());
	    
	    CreditCard creditCardPaypal = new CreditCard();
	    creditCardPaypal.setCountryName("");
	    creditCardPaypal.setNumber("");
	    creditCardPaypal.setDueMonth(12);
	    creditCardPaypal.setDueYear(2016);
	    creditCardPaypal.setFullName("Roger Gomez Jaramillo");
	    
	    receipt = billingService.chargeOrder(pizza, creditCardPaypal);
	    System.out.println("Paypal Card:" + receipt.getMessage());
		
	}

}
