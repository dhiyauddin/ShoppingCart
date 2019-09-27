package com.dhiyauddin.order;

import java.util.Collection;

import com.dhiyauddin.bean.Product;
import com.dhiyauddin.exception.ProductNotFoundException;

public interface IOrder {
	boolean addProduct(Product p);
	boolean removeProduct(String pid) throws ProductNotFoundException;
	Collection<Product> getCartDetails();
	Product getProductFromCart(String pid) throws ProductNotFoundException;
	int productCount();
  double getCartPrice();
}