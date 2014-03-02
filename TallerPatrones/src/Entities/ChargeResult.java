package Entities;

public class ChargeResult {

	private boolean wasSucessful;
	private String declineMessage;

	public boolean WasSucessful() {
		return wasSucessful;
	}

	public void setWasSucessful(boolean wasSucessful) {
		this.wasSucessful = wasSucessful;
	}

	public String getDeclineMessage() {
		return declineMessage;
	}

	public void setDeclineMessage(String declineMessage) {
		this.declineMessage = declineMessage;
	}
}
