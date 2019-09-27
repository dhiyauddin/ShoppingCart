package com.dhiyauddin.test;

import java.util.Iterator;

import com.dhiyauddin.bean.Product;
import com.dhiyauddin.order.Order;

public class OrderTest {

	public static void main(String[] s) throws Exception {

		Order o = new Order("Dhiyauddin Aziz");
		o.addProduct(new Product("p101", "Lux Soap", 12, 120));
		o.addProduct(new Product("p102", "Olive Oil", 4, 140));
		o.addProduct(new Product("p103", "Pomade", 6, 30));

		System.out.println("\nNo. of Product : " + o.productCount());
		System.out.println("Order Places By: " + o.uid);

		System.out.println("Cart Total : " + o.getCartPrice());
		final Iterator<Product> it = o.getCartDetails().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// code to remove product from Cart
		 o.removeProduct("p103");
		// Get Product By its Id
		Product p = o.getProductFromCart("p103");
		System.out.println(p.toString());

	}

}