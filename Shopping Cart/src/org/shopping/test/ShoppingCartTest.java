/*The JUnit class tests the calculateDiscount method of CalculateDiscountService service*/

package org.shopping.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.Item;
import org.shopping.model.SlabDiscount;
import org.shopping.service.CalculateDiscountService;
import org.shopping.serviceinterface.ICalculateDiscountService;

public class ShoppingCartTest {

	@Test
	public void testCalculateDiscount() {

		List<SlabDiscount> slabDiscList = new ArrayList<SlabDiscount>();
		Map<String, CategoryDiscount> categoryDiscMap = new HashMap<String, CategoryDiscount>();
		List<CartItem> cart = new ArrayList<CartItem>();

		// Test Case 1
		slabDiscList.add(new SlabDiscount(0, 3000, 2));
		slabDiscList.add(new SlabDiscount(3001, 7000, 4));
		slabDiscList.add(new SlabDiscount(7001, Double.MAX_VALUE, 5));

		categoryDiscMap.put("001", new CategoryDiscount("001", "ConsumerGoods",5));
		categoryDiscMap.put("002",new CategoryDiscount("002", "OrganicFood", 7));
		categoryDiscMap.put("003", new CategoryDiscount("003", "Grocery", 2));
		categoryDiscMap.put("004", new CategoryDiscount("004", "BabyProducts",10));
		categoryDiscMap.put("005", new CategoryDiscount("005", "Apparrel", 15));

		cart.add(new CartItem(new Item("000001", "003", "Muesli", 100), 2));
		cart.add(new CartItem(new Item("000002", "005","Mens Tshirt Arrow 3463", 1536), 1));
		cart.add(new CartItem(new Item("000003", "002", "Organic Tomatoes", 10), 2));
		cart.add(new CartItem(new Item("000004", "001", "Wipro CFL", 120), 1));

		ICalculateDiscountService calculateDiscountService = new CalculateDiscountService();

		double expectedNetBill = 1601.516;
		assertEquals("Net Bill Amount for above data ", expectedNetBill,
				calculateDiscountService.calculateDiscount(cart,
						categoryDiscMap, slabDiscList), 0.1);

	}

}
