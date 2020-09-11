package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem>  orderItem = new ArrayList<>();
	private Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	
	public double total() {
		double total = 0;
		for (OrderItem item : orderItem) {
			total += item.subTotal(item.getQuantity(), item.getPrice());
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + client.getBirthDate() + " - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		
		
		return sb.toString();
	}
}
