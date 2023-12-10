package pack;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("      <= JK HOSPITAL =>      ");
	System.out.println("* * * * * * * * * * * * * * *");
	System.out.println("*   1 - For Admin login     *");
	System.out.println("*   2 - For Patient Login   *");
	System.out.println("* * * * * * * * * * * * * * *");
	
	int Option=sc.nextInt();
	if(Option==1)
	{
		try {
			System.out.println("---------------------------------------------");
			System.out.println("* * * * * Welcome To Hospital Login * * * * *");
			System.out.println("---------------------------------------------");
			System.out.println("     ");
			System.out.println("```Enter a Username```");
			String user=sc.next();
			System.out.println("```Enter a Password```");
			String pass=sc.next();
			
			DCode d=new DCode();
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
			if(d.hlogin(user, pass))
			{
				while(true)
				{
					System.out.println("---------------------------------------");
					System.out.println("* * * * * Welcome to Hospital * * * * *");
					System.out.println("---------------------------------------");
					System.out.println("    ");
					System.out.println("---1.Add Hospital Details---");
					System.out.println("---2.Update Hospital Details---");
					System.out.println("---3.View Hospital Details---");
					System.out.println("---4.Delete Hospital Details---");
					System.out.println("---5.Exit---");
					System.out.println("    ");
					System.out.println("------------------------------------------------------------------------------------------");
					int opt=sc.nextInt();
					if(opt==1)
					{
						System.out.println("---Enter a Hospital ID---");
						int H_ID=sc.nextInt();
						System.out.println("---Enter a City Name---");
						String City=sc.next();					
						System.out.println("---Enter a Hospital Name---");
						String H_Name=sc.next();
						System.out.println("---Enter a Patient ID---");
						int P_ID=sc.nextInt();
						System.out.println("---Enter a Doctor ID---");
						int D_ID=sc.nextInt();
						if(d.insert(H_ID,City,H_Name,P_ID,D_ID)>0)
						{
							System.out.println("-----------------------------------");
							System.out.println("  New Customer Added Successfully  ");
							System.out.println("-----------------------------------");
						}
					}
					else if(opt==2)
					{
						System.out.println("---Enter a Hospital ID---");
						int H_ID=sc.nextInt();
						System.out.println("---Enter a New City---");
						String City=sc.next();
						if(d.update(City,H_ID)>0)
						{
							System.out.println("------------------------");
							System.out.println("  Updated Successfully  ");
							System.out.println("------------------------");
						}
						
					}
					else if(opt==3)
					{
						d.view();
						
					}
					else if(opt==4)
					{
						System.out.println("---Enter a Hospital ID---");
						if(d.delete(sc.nextInt())>0)
						{
							System.out.println("------------------------");
							System.out.println("  Deleted Successfully  ");
							System.out.println("------------------------");
						}
						
					}else if(opt==5)
					{
						System.out.println("-----------------------");
						System.out.println("  Logout Successfully  ");
						System.out.println("-----------------------");
						d.conclose();
						break;
					}
					System.out.println("---------------------------------------------------------------------------------------");
				}
			}
			
			}catch(ClassNotFoundException | SQLException e)
		{
				System.out.println(e);
		}
	}else if(Option==2)
	{
		System.out.println("-----------------------------------------------------");
		System.out.println("* * * * * Your Welcome To The Patient Login * * * * *");
		System.out.println("-----------------------------------------------------");
		System.out.println("```Enter a Username```");
		String uname=sc.next();
		System.out.println("```Enter a Password```");
		String pwd=sc.next();
		
		DCode db=new DCode();
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		if(db.plogin(uname,pwd))
		{
			while(true)
			{
				System.out.println("------------------------------------------------");
				System.out.println("* * * * * Your Welcome to the Hospital * * * * *");
				System.out.println("------------------------------------------------");
				System.out.println("---1.Add Patient Details---");
				System.out.println("---2.Update Patient Details---");
				System.out.println("---3.View Patient Details---");
				System.out.println("---4.Delete  Details---");
				System.out.println("---5.Exit---");
				System.out.println("    ");
				System.out.println("------------------------------------------------------------------------------------------");
				int opn=sc.nextInt();
				if(opn==1)
				{
					System.out.println("---Enter a Patient ID---");
					int P_ID=sc.nextInt();
					System.out.println("---Enter a Patient Name---");
					String P_Name=sc.next();					
					System.out.println("---Enter a Address---");
					String Address=sc.next();
					System.out.println("---Enter Diagnosis---");
					String Diagnosis=sc.next();
					System.out.println("---Enter a Record ID---");
					int R_ID=sc.nextInt();
					System.out.println("---Enter a Age---");
					System.out.println("    ");
					System.out.println("-------------------------------------------------------------------------------------");
					int Age=sc.nextInt();
					if(db.insert1(R_ID, Diagnosis, P_Name, P_ID, Age, Address )>0)
					{
						System.out.println("------------------------------");
						System.out.println("  Patient Added Successfully  ");
						System.out.println("------------------------------");
					}
				}else if(opn==2)
				{
					System.out.println("---Enter a Patient ID---");
					int P_ID=sc.nextInt();
					System.out.println("---Enter a New Diagnosis---");
					String Diagnosis=sc.next();
					if(db.update1(Diagnosis, P_ID)>0)
					{
						System.out.println("----------------------------------------");
						System.out.println("  Patient Details Updated Successfully  ");
						System.out.println("----------------------------------------");
					}
					
				}else if(opn==3)
				{
					db.view1();
					
				}else if(opn==4)
				{
					System.out.println("---Enter a Patient ID---");
					int P_ID=sc.nextInt();
					if(db.delete1(P_ID)>0)
					{
						System.out.println("-----------------------------------");
						System.out.println("  Patient ID Deleted Successfully  ");
						System.out.println("-----------------------------------");
					}
				}else if(opn==5)
				{
					System.out.println(" -----------------------");
					System.out.println("   LOGOUT SUCCESSFULLY  ");
					System.out.println(" -----------------------");
					db.conclose();
					break;
				}
			}
		}
	}else {
		
		System.out.println("----- (warning) ***** Enter Correct Login Number ***** (warning) -----");
		
	}sc.close();
	
	}
}



