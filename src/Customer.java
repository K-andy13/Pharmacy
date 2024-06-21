public class Customer {
    // Attributes
    private int customerID;
    private String customerName;
    private String customerEmail;

    // Constructor
    public Customer(int customerID, String customerName, String customerEmail) {
  //      this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        Utility.customerCollection.put(this.customerName,this);
    }

    // Getters
   public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    // Setters
   /* public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }*/

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
             //   "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a new customer
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");

        // Printing customer details
        System.out.println(customer);

        // Using getters
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Email: " + customer.getCustomerEmail());

        // Using setters
       // customer.setCustomerID(2);
        customer.setCustomerName("Jane Doe");
        customer.setCustomerEmail("jane.doe@example.com");

        // Printing updated customer details
        System.out.println(customer);
    }
}
