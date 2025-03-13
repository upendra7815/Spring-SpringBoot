import java.sql.*;
public class JDBC {
    public static void main(String[] args) throws Exception  {
     /*   1.import package
        2.load and register driver
        3.create connection
        4.create statement
        5.execute statement
        6.process the result
        7.close
*/
        int sid=8;
        int snum=47;
        int sage=87;

      String url="jdbc:postgresql://localhost:5432/postgres";
      String uname="postgres";
      String pass="7815";
//      String sql="insert into students values(7,56,98)";
        String sql="insert into students values(?,?,?)";

     // Class.forName("org.postgresql.Driver");
       Connection con=DriverManager.getConnection(url,uname,pass);
       System.out.println("connection estabilsh");
       //Statement st= con.createStatement();
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setInt(2,snum);
        st.setInt(3,sage);

       st.execute();

//       ResultSet rs=st.executeQuery(sql);
//       rs.next();
//       String name=rs.getString("snum");
//       System.out.println(name);

//        while(rs.next()){
//            System.out.print(rs.getInt(1)+" - ");
//            System.out.print(rs.getString(2)+" - ");
//            System.out.println(rs.getInt(3));
//        }

       con.close();
       System.out.println("close connection");
    }
}
