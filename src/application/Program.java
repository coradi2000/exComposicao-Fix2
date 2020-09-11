package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.println("Enter order data :");
		System.out.print("Status: ");
		String status = sc.nextLine();
	
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client (name, email, birthDate));
		//                Order(Date moment, OrderStatus status, Client client)
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		for (int i=1; i<=items ; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order.toString());
		System.out.println();
		
		sc.close();
	}

}
