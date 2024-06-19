import java.util.ArrayList;
import java.util.HashMap;

public class Utility {
    public static final HashMap<String, Drug> drugCollection = new HashMap<>();

    public static int numOfDrugs(){
        return drugCollection.size();
    }

    public static final HashMap<String, Supplier[]> drugToSupplierCollection=new HashMap<>();

    public static final HashMap<String,Supplier> supplierCollection=new HashMap<>();
    public static final HashMap<String,Supplier> supplierSearchCollectionLoc=new HashMap<>();


    public static final HashMap<String,Customer> customerCollection=new HashMap<>();
}
