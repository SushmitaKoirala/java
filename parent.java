import java.util.Scanner;
class parent
{
int a;
void getdata()
{
Scanner r=new Scanner(System.in);
System.out.println("Enter the values of a");
a=r.nextInt();
}
}
class child extends parent
{
int b;
void show()
{
Scanner r1=new Scanner(System.in);
System.out.println("Enter values of b");
b=r1.nextInt();
}
void sum()
{
System.out.println("sum:" +(a+b));
}
public static void main (String[] args)
{
child c1=new child();
c1.getdata();
c1.show();
c1.sum();
}
}