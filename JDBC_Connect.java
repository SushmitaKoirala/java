import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JDBC_Connect
{
public static void main(String[] args)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","server");
Statement smt=con.createStatement();
smt.executeUpdate("create table emp(eno number,ename varchar(12),esalary number)");
System.out.print("Table created Successfully");
con.close();
}
catch(Exception e)
{
System.out.print(e);
}
}
}