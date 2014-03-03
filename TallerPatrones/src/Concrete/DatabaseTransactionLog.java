package Concrete;

import Abstract.UnreachableException;
import Entities.ChargeResult;

public class DatabaseTransactionLog implements Abstract.TransactionLog {

	final String loggingMessage = "--- Logging ---";
	
	@Override
	public void logChargeResult(ChargeResult charge) {
		
		if(charge.WasSucessful())
		{
			System.out.println(loggingMessage + " Succesful transaction logged");
		}
		else
		{
			System.out.println(loggingMessage + " Transaction declined:" + charge.getDeclineMessage());
		}
	}

	@Override
	public void logConnectException(UnreachableException ex) {
		System.out.println(loggingMessage + " Exception:" + ex.getMessage());
	}

}
