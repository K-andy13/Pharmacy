import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utility {
    public static final HashMap<String, Drug> drugCollection = new HashMap<>();

    public static int numOfDrugs(){
        return drugCollection.size();
    }

    public static final HashMap<String, Supplier[]> drugToSupplierCollection=new HashMap<>();

    public static final HashMap<String,Supplier> supplierCollection=new HashMap<>();
   //


public static void findSupplierBasedOnLocation(String location){
    // Iterate through the HashMap to find the Supplier with the desired location
    for (Map.Entry<String, Supplier> entry : supplierCollection.entrySet()) {
        Supplier supplier = entry.getValue();
        if (supplier.getLocation().equals(location)) {
            System.out.println("Supplier found with location " + location + ": " + supplier);
            // Optionally break here if you only need to find the first match
        }
    }

}
    public static final HashMap<String,Customer> customerCollection=new HashMap<>();
    public static void checkStock(){
        for (Map.Entry<String, Drug> entry : drugCollection.entrySet()) {
            Drug drug=entry.getValue();
            if(drug.numOfUnits<=5){System.out.println(drug.getDrugName()+" :Low stock");}
            else{System.out.println(drug.getDrugName()+" :Sufficient stock");}
        }


        }
}
