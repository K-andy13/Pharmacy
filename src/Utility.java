import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

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


    public static void writeToSuppDB(Supplier supplier) {
        String url = "jdbc:mysql://localhost:3306/pharmacy?autoReconnect=true&useSSL=false";
        String user = "blackjack13";
        String password = "Sarpoma..";
        // Open a single connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL insert statement
            String sql = "INSERT INTO suppliers (supplierName, location, contactInfo) VALUES (?, ?, ?)";

            // Create a PreparedStatement object
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Disable auto-commit mode
                connection.setAutoCommit(false);

                // Set the parameters for the supplier
                statement.setString(1, supplier.getSupplierName());
                statement.setString(2, supplier.getLocation());
                statement.setString(3, supplier.getContactInfo());

                // Execute the statement
                statement.executeUpdate();

                // Commit the transaction
                connection.commit();

                System.out.println("Supplier was inserted successfully!");
            } catch (SQLException ex) {
                // Roll back the transaction in case of an error
                connection.rollback();
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeToDrugDB(Drug drug) {
        String url = "jdbc:mysql://localhost:3306/pharmacy?autoReconnect=true&useSSL=false";
        String user = "blackjack13";
        String password = "Sarpoma..";
        // Open a single connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL insert statement
            String sql = "INSERT INTO drugs (drugName, unitPrice, numOfUnits) VALUES (?, ?, ?)";

            // Create a PreparedStatement object
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Disable auto-commit mode
                connection.setAutoCommit(false);

                // Set the parameters for the supplier
                statement.setString(1, drug.getDrugName());
                statement.setDouble(2, drug.getUnitPrice());
                statement.setInt(3, drug.getNumOfUnits());

                // Execute the statement
                statement.executeUpdate();

                // Commit the transaction
                connection.commit();

                System.out.println("Drug was inserted successfully!");
            } catch (SQLException ex) {
                // Roll back the transaction in case of an error
                connection.rollback();
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static HashMap<String, Drug> readFromDrugDB() {
        String url = "jdbc:mysql://localhost:3306/pharmacy?autoReconnect=true&useSSL=false";
        String user = "blackjack13";
        String password = "Sarpoma..";

        HashMap<String, Drug> collection = new HashMap<>();

        // Open a single connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL select statement
            String sql = "SELECT drugID,drugName, unitPrice,numOfUnits FROM drugs";
            // Create a Statement object
            try (Statement statement = connection.createStatement()) {
                // Execute the query
                ResultSet resultSet = statement.executeQuery(sql);

                // Iterate over the result set
                while (resultSet.next()) {
                    String drugName = resultSet.getString("drugName");
                    double unitPrice = resultSet.getDouble("unitPrice");
                    int drugID=resultSet.getInt("drugID");
                    int numOfUnits=resultSet.getInt("numOfUnits");
                    System.out.println("Drug ID: "
                            +drugID+" Drug Name: "+drugName+" Unit Price: " +unitPrice+" Number of Units "+numOfUnits);
                    // Create a new Drug object
                 //   Drug drug = new Drug(drugName, unitPrice,numOfUnits);
                    // Add the drug to the collection
                  //  collection.put(drugName, drug);
                }

                System.out.println( " drugs were read successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return collection;
    }

    public static void main(String[] kwame){
HashMap<String,Drug> collection=Utility.readFromDrugDB();

    }

}
