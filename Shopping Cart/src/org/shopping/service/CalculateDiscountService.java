/*This class calculates the discount - Category wise and Slab wise*/

package org.shopping.service;

import java.util.List;
import java.util.Map;

import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.SlabDiscount;
import org.shopping.serviceinterface.ICalculateDiscountService;

public class CalculateDiscountService implements ICalculateDiscountService {

	/**
	 * Calculates discount on each item in the cart based on category of Item
	 *
	 * @param cart
	 *            - List of Cart items
	 * @param cdList
	 *            - Map of CategoryDiscount
	 * @param sdList
	 *            - List of SlabDiscount
	 * @return the netBillAmount after application of category wise discount and
	 *         slab wise discount
	 */
	@Override
	public double calculateDiscount(List<CartItem> cart,
			Map<String, CategoryDiscount> cdList, List<SlabDiscount> sdList) {
		double totalBill = 0;
		double applicableDiscount = 0;
		double grandTotal = 0;
		double netBillAmount = 0;
		for (CartItem cartItem : cart) {
			double discountPer = cdList.get(
					cartItem.getItem().getItemCategoryID()).getDiscPerc();
			double discount = cartItem.getItem().getUnitPrice() * discountPer
					/ 100;
			cartItem.setDiscount(discount);
			totalBill = totalBill + cartItem.getItem().getUnitPrice()
					* cartItem.getQuantity();
			applicableDiscount = applicableDiscount + cartItem.getQuantity()
					* cartItem.getDiscount();
			grandTotal = totalBill - applicableDiscount;

		}

		displayItemizedBill(cart);
		netBillAmount = calculateSlabDiscount(grandTotal, sdList);
		System.out.println("Total Bill = " + totalBill);
		System.out.println("Applicable Discount = " + applicableDiscount);
		System.out.println("Grand Total = " + grandTotal);
		System.out.println("Net Bill Amount = " + netBillAmount);

		return netBillAmount;

	}

	/**
	 * Display Itemized Bill
	 *
	 * @param cart
	 *            - List of Cart item
	 */
	private void displayItemizedBill(List<CartItem> cart) {

		for (CartItem cartItem : cart) {
			System.out.println(cartItem);

		}

	}

	/**
	 * Calculates slab wise discount on grand total of items in the cart
	 *
	 * @param grandTotal
	 *            - grand total of items in the cart after application of
	 *            category wise discount
	 * @param sdList
	 *            - List of SlabDiscount
	 * @return the netBillAmount after application of slab wise discount
	 */
	private double calculateSlabDiscount(double grandTotal,
			List<SlabDiscount> sdList) {
		// TODO Auto-generated method stub
		double netBillAmount = 0;
		for (SlabDiscount slabDisc : sdList) {

			if (grandTotal >= slabDisc.getRangeMin()
					&& grandTotal <= slabDisc.getRangeMax()) {
				netBillAmount = grandTotal - grandTotal
						* slabDisc.getDiscPerc() / 100;
				break;
			}

		}

		return netBillAmount;

	}

}
