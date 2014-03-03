package Entities;

public class Receipt {
	
	private String message;
	public String getMessage() {
		return message;
	}
	
	public static Receipt forSuccessfulCharge(Double amount)
	{
		Receipt receipt = new Receipt();
		receipt.message = "Order processed with the amount:" + amount;
		return receipt;
	}
	
	public static Receipt forDeclinedCharge(String declineMessage)
	{
		Receipt receipt = new Receipt();
		receipt.message = "Order declined. Reason:" + declineMessage;
		return receipt;
	}
	
	public static Receipt forSystemFailure(String exceptionMessage)
	{
		Receipt receipt = new Receipt();
		receipt.message = "Order not processed. Reason:" + exceptionMessage;
		return receipt;
	}
}
