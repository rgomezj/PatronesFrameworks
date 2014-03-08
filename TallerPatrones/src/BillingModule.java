import Abstract.BillingService;
import Abstract.CreditCardProcessor;
import Abstract.TransactionLog;
import Concrete.DatabaseTransactionLog;
import Concrete.MasterCardCreditCardProcessor;
import Concrete.PaypalCreditCardProcessor;
import Concrete.RealBillingService;
import Concrete.VisaCreditCardProcessor;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TransactionLog.class).to(DatabaseTransactionLog.class);

		// bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PaypalCreditCardProcessor.class);
		// bind(CreditCardProcessor.class).annotatedWith(Visa.class).to(VisaCreditCardProcessor.class);

		bind(CreditCardProcessor.class).annotatedWith(Names.named("PayPal"))
				.to(PaypalCreditCardProcessor.class);
		bind(CreditCardProcessor.class).annotatedWith(Names.named("Visa")).to(
				VisaCreditCardProcessor.class);
		bind(CreditCardProcessor.class).annotatedWith(Names.named("Master")).to(
				MasterCardCreditCardProcessor.class);
		bind(BillingService.class).to(RealBillingService.class);
	}
}
