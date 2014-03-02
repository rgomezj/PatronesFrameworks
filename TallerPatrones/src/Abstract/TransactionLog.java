package Abstract;
import Entities.ChargeResult;

public interface TransactionLog {
	
	void logChargeResult(ChargeResult charge);
	
	void logConnectException(UnreachableException charge);
}
