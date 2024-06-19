import jdk.jshell.execution.Util;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;


public class Drug {
  //  private static final HashMap<String, Drug> DrugCollection = new HashMap<>();

/*•	add drugs, (add)---done
•	search for a drug, (find a drug in the drug collection)
•	view all drugs and their suppliers,
•	view purchase history for each drug with detailed information of the time, date and buyer.---done
*/



    private int drugID;
    private String drugName;
    private double unitPrice;
    private final PurchaseHistory purchaseHistory;

    public ArrayList<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public int getDrugID() {
        return drugID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Drug(int drugID, String drugName, double unitPrice) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.purchaseHistory = new PurchaseHistory();
        Utility.drugCollection.put(drugName, this); //Automatically adds newly created Drugs to DrugCollection
    }

    public Drug(int drugID, String drugName, double unitPrice,Supplier[] suppliers) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.purchaseHistory = new PurchaseHistory();
        Utility.drugCollection.put(drugName, this); //Automatically adds newly created Drugs to DrugCollection
        Utility.drugToSupplierCollection.put(this.drugName,suppliers);
    }


    public void recordPurchase(int purchaseID, String drugName, int drugID, String customerName, int quantity, double totalAmount, LocalDateTime purchaseDateTime) throws IOException {
        //add to purchaseHistory
        Purchase temp=new Purchase(purchaseID, drugName, drugID, customerName, quantity, totalAmount, purchaseDateTime);
        purchaseHistory.add(0,temp);/*Stack like implementation of purchase history
        ,latest purchases at the top*/
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\kwame\\Pharmacy\\Sales.txt",true));
                writer.write(temp.toString());
                writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}}



     }
     public Drug findDrug(String drugName){
         return Utility.drugCollection.getOrDefault(drugName, null);
     }

    @Override
    public String toString() {
        return this.drugName+ "("+this.drugID+ ")";
    }


    public static List<Map.Entry<String, Drug>> sortDrugCollection() {
        List<Map.Entry<String, Drug>> entriesList = new ArrayList<>(Utility.drugCollection.entrySet());
        entriesList.sort(new DrugCompare());
        return entriesList;
    }

    static class DrugCompare implements Comparator<Map.Entry<String, Drug>> {
        public int compare(Map.Entry<String, Drug> one, Map.Entry<String, Drug> two) {
            return one.getValue().getDrugName().compareTo(two.getValue().getDrugName());
        }
    }public static void main(String[] args) throws IOException {
        // Create drugs
        Drug drug1 = new Drug(1, "Aspirin", 0.50);
        Drug drug2 = new Drug(2, "Benadryl", 1.20);
        Drug drug3 = new Drug(3, "Citalopram", 2.30);

        // Add purchase history
        drug1.recordPurchase(101, "Aspirin", 1, "John Doe", 2, 1.00, LocalDateTime.now().minusDays(1));
        drug1.recordPurchase(102, "Aspirin", 1, "Jane Smith", 5, 2.50, LocalDateTime.now().minusDays(2));
        drug2.recordPurchase(103, "Benadryl", 2, "Alice Johnson", 1, 1.20, LocalDateTime.now().minusHours(3));
        drug3.recordPurchase(104, "Citalopram", 3, "Bob Brown", 3, 6.90, LocalDateTime.now().minusDays(3));

        // Test getters
        System.out.println("Drug 1 Name: " + drug1.getDrugName());
        System.out.println("Drug 2 ID: " + drug2.getDrugID());
        System.out.println("Drug 3 Unit Price: " + drug3.getUnitPrice());

        // Test finding a drug
        Drug foundDrug = drug1.findDrug("Benadryl");
        System.out.println("Found Drug: " + (foundDrug != null ? foundDrug : "Drug not found"));

        // Test viewing purchase history
        System.out.println("Purchase History for Aspirin:");
        for (Purchase purchase : drug1.getPurchaseHistory()) {
            System.out.println(purchase);
        }

        // Sort and view all drugs
        List<Map.Entry<String, Drug>> sortedDrugs = Drug.sortDrugCollection();
        System.out.println("Sorted Drug Collection:");
        for (Map.Entry<String, Drug> entry : sortedDrugs) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Sort and view purchase history for Aspirin by amount
        System.out.println("Sorted Purchase History for Aspirin by Amount:");
        PurchaseHistory p=(PurchaseHistory)drug1.getPurchaseHistory();
        p.sortPurchaseHistoryByAmount();
        for (Purchase purchase : p) {
            System.out.println(purchase);
        }

        // Sort and view purchase history for Aspirin by date-time
        System.out.println("Sorted Purchase History for Aspirin by Date-Time:");
        p.sortPurchaseHistoryByDate();
        for (Purchase purchase : p) {
            System.out.println(purchase);
        }
        System.out.println(Utility.numOfDrugs());

    }

}

