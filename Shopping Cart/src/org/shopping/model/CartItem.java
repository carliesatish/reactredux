/*This class represents each Item in the cart*/

package org.shopping.model;

public class CartItem {

	private Item item;
	private int quantity;
	private double discount;

	public CartItem() {
		super();
	}

	public CartItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;

	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Cart [Item=" + item + ", Quantity=" + quantity + ", PerUnitDiscount="
				+ discount+ ", TotalDiscount="
				+ discount * quantity+ ", NetValue="+ item.getUnitPrice()*quantity+"]";
	}

}
