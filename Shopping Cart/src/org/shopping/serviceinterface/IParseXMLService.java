package org.shopping.serviceinterface;

import java.util.List;
import java.util.Map;

import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.SlabDiscount;

public interface IParseXMLService {
	public Map<String, CategoryDiscount> parseCategoryXML(
			String categoryFileName);

	public List<SlabDiscount> parseSlabXML(String slabFileName);

	public List<CartItem> parseShoppingCartXML(String shoppingCartFileName);

}
