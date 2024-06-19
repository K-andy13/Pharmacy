import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PurchaseHistory extends ArrayList<Purchase>{

    public  PurchaseHistory sortPurchaseHistoryByAmount() {
        this.sort(new PurchaseHistory.PurchaseCompare_Amount());
        return this;
    }


    public  PurchaseHistory sortPurchaseHistoryByDate() {
        this.sort(new PurchaseHistory.PurchaseDateTimeCompare());
        return this;
    }



    static class PurchaseCompare_Amount implements Comparator<Purchase> {
        public int compare(Purchase one, Purchase two) {
            return Double.compare(one.getTotalAmount(), two.getTotalAmount());
        }
    }

    static class PurchaseDateTimeCompare implements Comparator<Purchase> {
        public int compare(Purchase one, Purchase two) {
            return one.getPurchaseDateTime().compareTo(two.getPurchaseDateTime());
        }
    }
}

