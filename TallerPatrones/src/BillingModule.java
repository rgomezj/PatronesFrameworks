import Abstract.BillingService;
import Abstract.CreditCardProcessor;
import Abstract.TransactionLog;
import Concrete.DatabaseTransactionLog;
import Concrete.PaypalCreditCardProcessor;
import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
	
  @Override
  protected void configure() {
    bind(TransactionLog.class).to(DatabaseTransactionLog.class);
    bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
    bind(BillingService.class).to(RealBillingService.class);
  }
}
