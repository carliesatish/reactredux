/*This class contains method that parses the XMLs and place the data in relevant data structure. We are using DOM Parser to parse the XMLs*/

package org.shopping.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.shopping.constants.Constants;
import org.shopping.model.CartItem;
import org.shopping.model.CategoryDiscount;
import org.shopping.model.Item;
import org.shopping.model.SlabDiscount;
import org.shopping.serviceinterface.IParseXMLService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXMLService implements IParseXMLService {

	private static List<SlabDiscount> slabDiscList = new ArrayList<SlabDiscount>();
	private static Map<String, CategoryDiscount> categoryDiscMap = new HashMap<String, CategoryDiscount>();
	private List<CartItem> cart = new ArrayList<CartItem>();

	private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory
			.newInstance();
	private static DocumentBuilder dBuilder;
	private static Document doc;
	private static NodeList nodeList;;

	/**
	 * Parses categoryFileName XML and convert it into {@link CategoryDiscount}
	 * objects
	 *
	 * @param categoryFileName
	 *            - Category file name
	 * @return the Map of {@link CategoryDiscount} with id of
	 *         {@link CategoryDiscount} as the key of the Map
	 */
	@Override
	public Map<String, CategoryDiscount> parseCategoryXML(
			String categoryFileName) {

		try {
			// Retrieving Categories File
			File category = new File(Constants.PATH + categoryFileName);
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(category);
			doc.getDocumentElement().normalize();

			nodeList = doc.getElementsByTagName("Category");

			for (int i = 0; i < nodeList.getLength(); i++) {
				CategoryDiscount cd = getCategory(nodeList.item(i));
				CategoryDiscount copy = new CategoryDiscount(cd);

				categoryDiscMap.put(cd.getId(), copy);

			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
		return categoryDiscMap;

	}

	/**
	 * Parses slabFileName XML and convert it into {@link SlabDiscount} objects
	 *
	 * @param slabFileName
	 *            - Slab file name
	 * @return the List of {@link SlabDiscount} objects corresponding to
	 *         slabFileName xml
	 */
	@Override
	public List<SlabDiscount> parseSlabXML(String slabFileName) {

		try {
			// Retrieving Slab File
			File slab = new File(Constants.PATH + slabFileName);
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(slab);
			doc.getDocumentElement().normalize();

			nodeList = doc.getElementsByTagName("Slab");

			for (int i = 0; i < nodeList.getLength(); i++) {
				slabDiscList.add(getSlab(nodeList.item(i)));
			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
		return slabDiscList;

	}

	/**
	 * Parses slabFileName XML and convert it into {@link SlabDiscount} objects
	 *
	 * @param shoppingCartFileName
	 *            - Shopping Cart file name
	 * @return the List of {@link CartItem} objects corresponding to
	 *         shoppingCartFileName xml
	 */
	@Override
	public List<CartItem> parseShoppingCartXML(String shoppingCartFileName) {

		try {
			// Retrieving Categories File
			File itemFileName = new File(Constants.PATH + shoppingCartFileName);
			doc = dBuilder.parse(itemFileName);
			doc.getDocumentElement().normalize();

			nodeList = doc.getElementsByTagName("Item");

			for (int i = 0; i < nodeList.getLength(); i++) {
				cart.add(getItem(nodeList.item(i)));
			}
		} catch (SAXException | IOException e1) {
			e1.printStackTrace();
		}

		return cart;

	}

	/**
	 * Returns CategoryDiscount based on XML Node
	 * 
	 * @param node
	 *            - XML Node representing CategoryDiscount
	 * @return CategoryDiscount object corresponding to @node
	 */
	private CategoryDiscount getCategory(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		CategoryDiscount categoryDisc = new CategoryDiscount();
		if (node.getNodeType() == Node.ELEMENT_NODE) {

			Element element = (Element) node;
			categoryDisc.setId(getTagValue("id", element));
			categoryDisc.setName(getTagValue("name", element));
			categoryDisc.setDiscPerc(Double.parseDouble(getTagValue("discPerc",
					element)));

		}

		return categoryDisc;
	}

	/**
	 * Returns SlabDiscount based on XML Node
	 * 
	 * @param node
	 *            - XML Node representing SlabDiscount
	 * @return SlabDiscount object corresponding to @node
	 */
	private SlabDiscount getSlab(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		SlabDiscount slabDisc = new SlabDiscount();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			slabDisc.setRangeMin(Double.parseDouble(getTagValue("RangeMin",
					element)));
			slabDisc.setRangeMax(Double.parseDouble(getTagValue("RangeMax",
					element)));
			slabDisc.setDiscPerc(Double.parseDouble(getTagValue("discPerc",
					element)));

		}

		return slabDisc;
	}

	/**
	 * Returns Cart based on XML Node
	 * 
	 * @param node
	 *            - XML Node representing Cart
	 * @return Cart object corresponding to @node
	 */
	private CartItem getItem(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		Item item = new Item();
		CartItem cartItem = new CartItem();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			item.setItemID(getTagValue("itemID", element));
			item.setItemCategoryID(getTagValue("itemCategoryID", element));
			item.setItemName(getTagValue("itemName", element));
			item.setUnitPrice(Double.parseDouble(getTagValue("unitPrice",
					element)));
			cartItem.setItem(item);
			cartItem.setQuantity(Integer.parseInt(getTagValue("quantity",
					element)));

		}

		return cartItem;

	}

	/**
	 * Returns Tag value based on tag name passed as parameter
	 * 
	 * @param tag
	 *            - tag name
	 * @param element
	 *            - XML Node representing tag
	 * @return Tag value based on tag name passed
	 */
	private String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0)
				.getChildNodes();

		Node node = (Node) nodeList.item(0);
		if (node == null && tag.equals("RangeMax"))
			return (Double.toString(Double.MAX_VALUE));
		return node.getNodeValue();
	}

}
