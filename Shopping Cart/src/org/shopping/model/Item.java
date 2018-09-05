/*This class represents each Item */

package org.shopping.model;

public class Item {

	private String itemID;
	private String itemCategoryID;
	private String itemName;
	private double unitPrice;

	public Item() {
		super();
	}

	public Item(String itemID, String itemCategoryID, String itemName,
			double unitPrice) {
		super();
		this.itemID = itemID;
		this.itemCategoryID = itemCategoryID;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemCategoryID() {
		return itemCategoryID;
	}

	public void setItemCategoryID(String itemCategoryID) {
		this.itemCategoryID = itemCategoryID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [ItemID=" + itemID + ", ItemCategoryID=" + itemCategoryID
				+ ", ItemName=" + itemName + ", UnitPrice=" + unitPrice + "]";
	}

}
