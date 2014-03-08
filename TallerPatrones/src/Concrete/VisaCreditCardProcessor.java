package Concrete;

import Abstract.UnreachableException;
import Entities.ChargeResult;
import Entities.CreditCard;

public class VisaCreditCardProcessor implements Abstract.CreditCardProcessor {

	@Override
	public ChargeResult charge(CreditCard card, Double amount)
			throws UnreachableException {
		if (card.getNumber().isEmpty()) {
			throw new UnreachableException("The card number wasn't defined - Visa");
		} else {
			ChargeResult charge = new ChargeResult();
			if (card.getFullName().isEmpty()) {
				charge.setWasSucessful(false);
				charge.setDeclineMessage("The name wasn't defined - Visa");
			} else {
				charge.setWasSucessful(true);
			}
			return charge;
		}
	}

}
