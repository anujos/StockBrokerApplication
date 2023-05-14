package com.ibm.client;

import java.util.Scanner;

import com.ibm.bean.Order;
import com.ibm.service.OrderService;

public class Client {
	
	static Scanner con;
	static OrderService os;

	public static void main(String[] args) {
		
		os = new OrderService();

		while (true) {
			System.out.println();
			System.out.println("1) Place Order ");
			System.out.println("2) Order Summary ");
			System.out.println("3) Exit");

			System.out.print(" select an option : ");
			con = new Scanner(System.in);

			int choice = con.nextInt();
			switch (choice) {
			case 1:
				createNewOrder();
				break;
			case 2:
				displayOrderSummary();
				break;
			case 3:
				con.close();
				System.exit(0);
			default:
				System.out.println("\nEnter a valid option");

			}
		}

	}

	private static void createNewOrder() {
		System.out.println();
		System.out.println("1. LNT			   1451.5");
		System.out.println("2. Reliance		   923.90 ");
		System.out.println("3. Tata Steel	  \t435.60 ");
		
		System.out.print("   Enter an option: ");
		
		int choice = con.nextInt();
		
		if(choice>3) {
			System.out.println("\nEnter a valid option");
			return;
		}
		
		System.out.print("   Select Action(Buy/Sell): ");
		String action = con.next();
		
		
		if(!action.equals("Buy") && !action.equals("Sell")) {
			System.out.println("\nEnter a valid action(Buy/Sell)");
			return;
		}
		
		System.out.print("   Enter Quantity: ");
		int quantity = con.nextInt();
		
		
		if(quantity <=0) {
			System.out.println("\nEnter a valid quantity(greater than zero)");
			return;
		}
		
		String stock = choice==1?"LNT":choice==2?"Reliance":"Tata Steel";
		
		double orderAmount = quantity * (choice==1?1451.5:choice==2?923.90:435.60);
		
		double commission = action.equals("Buy")?orderAmount*0.005:orderAmount*0.01;
		
		Order o = new Order(stock, action, quantity, orderAmount, commission);
		
		System.out.println("   Your order no. " + os.placeOrder(o) + ", thanks for placing order");
		
	}

	private static void displayOrderSummary() {
		System.out.println();
		System.out.print("   Enter the order No: ");
		int orderNo = con.nextInt();
		Order o = os.getOrder(orderNo);
		
		System.out.println(o);

	}

}