package Abstract;
import Entities.CreditCard;
import Entities.PizzaOrder;

public interface TransactionLog {
	void logOrder(CreditCard card, PizzaOrder order);
}
