package com.deloitte.telcom.ui;

//import dao.CustomerAccountDaoImpl;
import java.util.*;

import com.deloitte.telcom.dao.*;
import com.deloitte.telcom.entities.*;
import com.deloitte.telcom.service.*;

public class TelcomInfoUi {
	 private  ICustomerService service = new CustomerServiceImpl(new CustomerAccountDaoImpl());
	 private Scanner sc;
	 
	 public static void main(String[] args) {
		 TelcomInfoUi ui = new TelcomInfoUi();
		 ui.execute();
	 }
	 
	 public void execute() {
		 try {
		 while(true) {
					 
				 System.out.println("Display Menu to the CustomerCare Representative :");
				 System.out.println("1)Account Balance Enquiry");
				 System.out.println("2)Recharge Account");
				 System.out.println("3)Create Account");
				 System.out.println("4)Exit");
				 sc = new Scanner(System.in);
				 int option = 0;
				 System.out.println("Enter your Choice :");
				 if(sc.hasNext())
					 option = sc.nextInt();
				
				 if(option==4) {
					 System.out.println("Exited");
					 break;
				 }
				 else {
				 
					 switch(option) {
					 case 1:
						 System.out.println("Enter Mobile No :");
						 String mobileNo="";
						 mobileNo = sc.next();
						 
						 CustomerAccount cust1 = service.findCustomerByMobNo(mobileNo);
						 System.out.println("Account Balance :"+cust1.getInitialBalance());
						 break;
					 
					 case 2:
						 double rechargeAmt;
						 System.out.println("Enter Recharge Amt :");
						 rechargeAmt = sc.nextDouble();
						 System.out.println("Recharge Amt is "+rechargeAmt);
						 String mobNo;
						 System.out.println("Enter Mobile No:");
						 mobNo = sc.next();
						 CustomerAccount cust2 = service.findCustomerByMobNo(mobNo); 
						 service.rechargeAccount(cust2, rechargeAmt);
						 System.out.println(+rechargeAmt+" Rcahrge done "+"Successfully");
						 break;
						 
					 case 3:
						 String mobiNo,name,accType;
						 double bal;
						 System.out.println("Enter Mobile Number :");
						 mobiNo=sc.next();
						 System.out.println("Enter Name:");
						 name=sc.next();
						 System.out.println("Enter AccountType(Prepaid/Postpaid) :");
						 accType=sc.next();
						 System.out.println("Enter Balance :");
						 bal = sc.nextDouble();
						 CustomerAccount cust3 =new CustomerAccount(mobiNo, name, accType, bal);
						 service.createAccount(mobiNo, name, accType, bal);
						 System.out.println("Account created "+cust3.getMobileNo() + " " +cust3.getName());
					 }
						 
				 }	 
		 	}
		 }catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Something went wrong ");
		 }
	 }
}
