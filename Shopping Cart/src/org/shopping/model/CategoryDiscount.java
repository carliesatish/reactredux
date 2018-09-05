/*This class represents Category wise Discount*/

package org.shopping.model;

public class CategoryDiscount {

	private String id;
	private String name;
	private double discPerc;

	public CategoryDiscount(String id, String name, double discPerc) {
		super();
		this.id = id;
		this.name = name;
		this.discPerc = discPerc;
	}

	public CategoryDiscount() {
		super();
	}

	public CategoryDiscount(CategoryDiscount cd) {

		id = cd.id;
		name = cd.name;
		discPerc = cd.discPerc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(double discPerc) {
		this.discPerc = discPerc;
	}

	@Override
	public String toString() {
		return "CategoryDiscount [id=" + id + ", name=" + name + ", discPerc="
				+ discPerc + "]";
	}

}
