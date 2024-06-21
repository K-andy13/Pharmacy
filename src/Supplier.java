public class Supplier {
    // Attributes
  //  private int supplierID;
    private String supplierName;
    private String location;
    private String contactInfo;

    // Constructor
    public Supplier(/*int supplierID,*/ String supplierName, String location, String contactInfo) {
    //    this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.location = location;
        this.contactInfo = contactInfo;
        Utility.supplierCollection.put(this.supplierName,this);
        Utility.writeToSuppDB(this);

    }

    // Getters
    /*public int getSupplierID() {
        return supplierID;
    }*/

    public String getSupplierName() {
        return supplierName;
    }

    public String getLocation() {
        return location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    // Setters
   /* public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }*/

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // toString method
    @Override
    public String toString() {
        return "Supplier{" +
            //    "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", location='" + location + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a new supplier
        Supplier supplier = new Supplier("ABC Supplies", "123 Main St, Anytown, USA", "contact@abcsupplies.com");

        // Printing supplier details
        System.out.println(supplier);

        // Using getters
      //  System.out.println("Supplier ID: " + supplier.getSupplierID());
        System.out.println("Supplier Name: " + supplier.getSupplierName());
        System.out.println("Location: " + supplier.getLocation());
        System.out.println("Contact Info: " + supplier.getContactInfo());

        // Using setters
  //      supplier.setSupplierID(2);
        supplier.setSupplierName("XYZ Supplies");
        supplier.setLocation("456 Elm St, Othertown, USA");
        supplier.setContactInfo("info@xyzsupplies.com");

        // Printing updated supplier details
        System.out.println(supplier);
        Utility.findSupplierBasedOnLocation("456 Elm St, Othertown, USA");
    }
}
