/*This class represents Slab wise Discount*/

package org.shopping.model;

public class SlabDiscount {

	private double rangeMin;
	private double rangeMax;
	private double discPerc;

	public SlabDiscount() {
		super();
	}

	public SlabDiscount(double rangeMin, double rangeMax, double discPerc) {
		super();
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.discPerc = discPerc;
	}

	public double getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(double rangeMin) {
		this.rangeMin = rangeMin;
	}

	public double getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(double rangeMax) {
		this.rangeMax = rangeMax;
	}

	public double getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(double discPerc) {
		this.discPerc = discPerc;
	}

	@Override
	public String toString() {
		return "SlabDiscount [rangeMin=" + rangeMin + ", rangeMax=" + rangeMax
				+ ", discPerc=" + discPerc + "]";
	}

}
