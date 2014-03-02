package Abstract;
import Entities.ChargeResult;
import Entities.CreditCard;

public interface CreditCardProcessor {
	ChargeResult charge(CreditCard card, Double amount) throws UnreachableException;
}
