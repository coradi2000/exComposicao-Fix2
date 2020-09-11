package entities;

public class OrderItem {

	private Integer quantity;
	//private Double price;
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		//this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return product.getPrice();
	}

	public void setPrice(Double price) {
		this.product.setPrice(price);;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double subTotal (int quantity, double price) {
		return quantity * price;
	}
	
}
