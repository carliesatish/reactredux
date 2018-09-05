package org.shopping.serviceinterface;

import java.util.List;
import java.util.Map;

import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.SlabDiscount;

public interface ICalculateDiscountService {
	public double calculateDiscount(List<CartItem> cart,
			Map<String, CategoryDiscount> cdList, List<SlabDiscount> sdList);

}
