import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*; 
public class Student
{
public static void main(String[] args)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","user");
PreparedStatement psmt=con.prepareStatement("insert into std values(?,?,?,?)");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
while(true)
{
System.out.print("Enter std ID:");
int stdno=Integer.parseInt(br.readLine());
System.out.print("Enter std Name:");
String stdname=br.readLine();
System.out.print("Enter emp age:");
int stdage=Integer.parseInt(br.readLine());
System.out.print("Enter std district:");
String stddistrict=br.readLine();
psmt.setInt(1,stdno);
psmt.setString(2,stdname);
 psmt.setInt(3,stdage);
psmt.setString(4,stddistrict);
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