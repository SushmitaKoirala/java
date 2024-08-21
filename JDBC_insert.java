import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*; 
public class JDBC_insert
{
public static void main(String[] args)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","server");
PreparedStatement psmt=con.prepareStatement("insert into emp values(?,?,?)");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
while(true)
{
System.out.print("Enter emp ID:");
int eno=Integer.parseInt(br.readLine());
System.out.print("Enter emp Name:");
String ename=br.readLine();
System.out.print("Enter emp salary:");
int esalary=Integer.parseInt(br.readLine());
psmt.setInt(1,eno);
psmt.setString(2,ename);
 psmt.setInt(3,esalary);
int count= psmt.executeUpdate();
if(count>0)
System.out.println(count+"Record inserted");
else 
System.out.println("no record inserted");
System.out.println("Do you want to more Records[Yess/No]");
String ch=br.readLine();
if(ch.equalsIgnoreCase("no"))
break;
}
}
catch(Exception e)
{
System.out.print(e);
}
}
}