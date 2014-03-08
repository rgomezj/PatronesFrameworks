package Concrete;

import javax.inject.Inject;

import com.google.inject.name.Named;

import Abstract.BillingService;
import Abstract.CreditCardProcessor;
import Abstract.TransactionLog;
import Abstract.UnreachableException;
import Entities.ChargeResult;
import Entities.CreditCard;
import Entities.PizzaOrder;
import Entities.Receipt;

public class RealBillingService implements BillingService {

	private TransactionLog transactionLog;

	// private CreditCardProcessor processor;

	private CreditCardProcessor visaProcessor;
	private CreditCardProcessor payPalProcessor;
	private CreditCardProcessor masterCardProcessor;

	@Inject
	public void setVisaProcessor(@Named("Visa") CreditCardProcessor processor) {
		this.visaProcessor = processor;
	}

	@Inject
	public void setPayPalProcessor(@Named("PayPal") CreditCardProcessor processor) {
		this.payPalProcessor = processor;
	}
	
	@Inject
	public void setMasterCardProcessor(@Named("Master") CreditCardProcessor processor) {
		this.masterCardProcessor = processor;
	}

	// @BindingAnnotation
	// @Retention(RUNTIME)
	// public @interface PayPal {
	// }
	//
	// @BindingAnnotation
	// @Retention(RUNTIME)
	// public @interface Visa {
	// }

	@Inject
	public RealBillingService(TransactionLog transactionLog) {
		this.transactionLog = transactionLog;
	}

	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
		try {
			ChargeResult result = null;
			if (creditCard.getCountryName() == "Colombia") {
				result = visaProcessor.charge(creditCard, order.getAmount());
			} else if(creditCard.getCountryName() == "England") {
				result = masterCardProcessor.charge(creditCard, order.getAmount());
			}
			else
			{
				result = payPalProcessor.charge(creditCard, order.getAmount());
			}
			
			transactionLog.logChargeResult(result);

			return result.WasSucessful() ? Receipt.forSuccessfulCharge(order
					.getAmount()) : Receipt.forDeclinedCharge(result
					.getDeclineMessage());
		} catch (UnreachableException e) {
			transactionLog.logConnectException(e);
			return Receipt.forSystemFailure(e.getMessage());
		}
	}

}