/*This class is the entry point. It consumes ParseXMLService to parse the XMLs and CalculateDiscountService to calculate discounts*/

package org.shopping.app;

import java.util.List;
import java.util.Map;

import org.shopping.constants.Constants;
import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.SlabDiscount;
import org.shopping.service.CalculateDiscountService;
import org.shopping.service.ParseXMLService;
import org.shopping.serviceinterface.ICalculateDiscountService;
import org.shopping.serviceinterface.IParseXMLService;

public class MainApplication {

	public static void main(String[] args) {

		String categoryFileName = Constants.CATEGORY_FILE_NAME;
		String slabFileName = Constants.SLAB_FILE_NAME;
		String shoppingCartFileName = Constants.SHOPPING_CARD_FILE_NAME;

		IParseXMLService parseXMLService = new ParseXMLService();
		ICalculateDiscountService calculateDiscountService = new CalculateDiscountService();

		/* Parsing the XMLs */
		Map<String, CategoryDiscount> categoryDiscMap = parseXMLService
				.parseCategoryXML(categoryFileName);
		List<SlabDiscount> slabDiscList = parseXMLService
				.parseSlabXML(slabFileName);
		List<CartItem> cart = parseXMLService
				.parseShoppingCartXML(shoppingCartFileName);

		/* Calculating Discounts */
		calculateDiscountService.calculateDiscount(cart, categoryDiscMap,
				slabDiscList);

	}

}
