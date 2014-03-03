package Concrete;
import Abstract.BillingService;
import Abstract.CreditCardProcessor;
import Abstract.TransactionLog;
import Abstract.UnreachableException;
import Entities.ChargeResult;
import Entities.CreditCard;
import Entities.PizzaOrder;
import Entities.Receipt;
import javax.inject.*;


public class RealBillingService implements BillingService {
  private final CreditCardProcessor processor;
  private final TransactionLog transactionLog;

  @Inject
  public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
    this.processor = processor;
    this.transactionLog = transactionLog;
  }

  public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
	  try {
	      ChargeResult result = processor.charge(creditCard, order.getAmount());
	      transactionLog.logChargeResult(result);

	      return result.WasSucessful()
	          ? Receipt.forSuccessfulCharge(order.getAmount())
	          : Receipt.forDeclinedCharge(result.getDeclineMessage());
	     } catch (UnreachableException e) {
	      transactionLog.logConnectException(e);
	      return Receipt.forSystemFailure(e.getMessage());
	    }
  }
}