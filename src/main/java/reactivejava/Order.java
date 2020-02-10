package reactivejava;

public class Order {
	private String mId;
	
	public Order(String id) {
		mId = id;
	}
	
	public String getId() {
		return mId;
	}
	
	public String toString() {
		return "Order ID: " + mId;
	}
	
	
	
}
