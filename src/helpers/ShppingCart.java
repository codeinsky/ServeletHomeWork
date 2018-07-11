package helpers;

import java.util.ArrayList;
import java.util.Collection;

import db.Item;

public class ShppingCart {
	Collection<Item> shoppingCart = new ArrayList<Item>();
	
	public void addItem(Item item) {
		shoppingCart.add(item);
		}
	
	public void removeItem(Item item) {
		shoppingCart.remove(item);
		}
	
	public void getItems() {
		System.out.println(shoppingCart);
	}
	
	public void clearCart() {
		shoppingCart.clear();
	}

}
