package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date: (DD/MM/YYYY)");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(clientName,clientEmail,birthDate);


        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus prodStatus = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), prodStatus,client);
        System.out.println("How many items to this order: ");
        Integer n = sc.nextInt();

        for(int i = 1; i <=n; i++){
            System.out.println("Enter #"+i+" item data: ");
            System.out.print("Product name: ");
            String prodName = sc.next();
            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer prodQuantity = sc.nextInt();
            Product product = new Product(prodName,prodPrice);
            OrderItem orderItem = new OrderItem(prodQuantity,product);
            order.addItem(orderItem);
        }

        System.out.println("\n");
        System.out.println(order.toString());
    sc.close();
    }
}
