package Concrete;

import Abstract.UnreachableException;
import Entities.ChargeResult;
import Entities.CreditCard;

public class MasterCardCreditCardProcessor implements Abstract.CreditCardProcessor {

	@Override
	public ChargeResult charge(CreditCard card, Double amount)
			throws UnreachableException {
		if (card.getNumber().isEmpty()) {
			throw new UnreachableException("The card number wasn't defined - Master");
		} else {
			ChargeResult charge = new ChargeResult();
			if (card.getFullName().isEmpty()) {
				charge.setWasSucessful(false);
				charge.setDeclineMessage("The name wasn't defined - Master");
			} else {
				charge.setWasSucessful(true);
			}
			return charge;
		}
	}

}
