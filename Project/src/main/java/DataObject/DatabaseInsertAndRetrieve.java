//package DataObject;
//
//import com.github.javafaker.Faker;
//
//import java.sql.*;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//import static com.google.common.base.Ascii.toLowerCase;
//
//public class DatabaseInsertAndRetrieve {
//
//    public String firstName, lastName, phone, password, address, email, country, state, city, zip;
//    private DatabaseConnection _connection = new DatabaseConnection();
//
//    Connection conn = _connection.getConnection();
//
//    public String randomNum() {
//        // generating and returning minutes and seconds of current time
//        String s;
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("mmss");
//        LocalTime time = LocalTime.now();
//        s = format.format(time);
//        return s;
//    }
//
//    public void Insert() {
//
//        Faker faker = new Faker();
//
//        // saving first and lastname so that I will have email according to them
//        firstName = faker.name().firstName();
//        lastName = faker.name().lastName();
//
//        try {
//            String insert = "INSERT INTO users(firstName,lastName,phone,password,address,email,country," +
//                    "state,city,zip) VALUES(?,?,?,?,?,?,?,?,?,?)";
//
//            PreparedStatement pstmt = conn.prepareStatement(insert);
//
//            // inserting data
//            pstmt.setString(1, firstName);
//            pstmt.setString(2, lastName);
//            pstmt.setString(3, faker.phoneNumber().cellPhone());
//            pstmt.setString(4, "password");
//            pstmt.setString(5, faker.address().streetAddress());
//            pstmt.setString(6, toLowerCase(firstName) + "." + toLowerCase(lastName) + "@mail.com");
//            pstmt.setString(7, "Georgia");
//            pstmt.setString(8, "Tbilisi");
//            pstmt.setString(9, "Tbilisi");
//            pstmt.setInt(10, 0153);
//
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.print("Could not insert new data to database");
//            e.printStackTrace();
//        }
//    }
//
//    public void RetrieveData() {
//        try {
//
//            String select = "SELECT * FROM users";
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            ResultSet rs = stmt.executeQuery(select);
//            // moving pointer to the last row
//            rs.last();
//
//            firstName = rs.getString("firstName");
//            lastName = rs.getString("lastName");
//            // adding random num to email so that it will most likely be unique
//            email = randomNum() + rs.getString("email");
//            phone = rs.getString("phone");
//            password = rs.getString("password");
//            address = rs.getString("address");
//            country = rs.getString("country");
//            state = rs.getString("state");
//            city = rs.getString("city");
//            zip = rs.getString("zip");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Could not retrieve data");
//        }
//
//        // closing connection
//        try {
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
