import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static final String QUERY2 = "insert into users (id,age,login,fulname,email,gender) values(1,27,'Edil','tagaibek','edk@','m')";
    static final String QUERY1 = "delete from users where id=1";
    static final String QUERY = " select id,age,login,fulname,email,gender from users";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {
            //Extract data from result
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id"));
                System.out.println(",Age:" + rs.getInt("age"));
                System.out.println(",login:" + rs.getString("login"));
                System.out.println(",Fulname:" + rs.getString("fulname"));
                System.out.println(",email:" + rs.getString("email"));
                System.out.println(",gender:" + rs.getString("gender"));
            }
//            Statement stm2 = conn.createStatement();
//            int rsz1 = stm2.executeUpdate(QUERY2);
//            System.out.println(rsz1);
            Statement stmt1 = conn.createStatement();
            int rsz = stmt1.executeUpdate(QUERY1);
            System.out.println(rsz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}