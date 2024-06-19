import java.time.LocalDateTime;

public class Purchase {
    private final int purchaseID;
    private final int drugID;
    private final String drugName;
    private final String customerName;
    private final int quantity;
    private final double totalAmount;
    private final LocalDateTime purchaseDateTime;

    public LocalDateTime getPurchaseDateTime(){
        return  this.purchaseDateTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Purchase(int purchaseID, String drugName, int drugID, String customerName, int quantity, double totalAmount, LocalDateTime purchaseDateTime) {
        this.purchaseID = purchaseID;
        this.drugID=drugID;
        this.customerName=customerName;
        this.quantity=quantity;
        this.drugName=drugName;
        this.totalAmount=totalAmount;
        this.purchaseDateTime=purchaseDateTime;
    }

    @Override
    public String toString() {
        return "Purchase[" +
                "purchaseID =" + purchaseID + " drug: "+drugName+ " Customer: "+customerName+ " Quantity: "+quantity+" Total Amount: "+totalAmount+ " Time of Purchase: "+purchaseDateTime+
                "]";
    }

}
