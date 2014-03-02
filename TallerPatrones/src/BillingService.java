import Abstract.CreditCardProcessor;
import Abstract.TransactionLog;
import Entities.CreditCard;
import Entities.PizzaOrder;
import Entities.Receipt;


public class BillingService {
  private final CreditCardProcessor processor;
  private final TransactionLog transactionLog;

  @Inject
  public BillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
    this.processor = processor;
    this.transactionLog = transactionLog;
  }

  public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
    return null;
  }
}