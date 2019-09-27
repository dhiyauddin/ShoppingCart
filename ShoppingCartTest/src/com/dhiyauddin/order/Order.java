package com.dhiyauddin.order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.dhiyauddin.bean.Product;
import com.dhiyauddin.exception.ProductNotFoundException;

public class Order implements IOrder {
	
	public String uid;
	private Map<String, Product> map;
	
	public Order(){}
	public Order(String uid){
		this.uid=uid;
		map = new HashMap<String, Product>();
	}//Order
	
	public boolean addProduct(Product p){
		if(map.containsKey(p.getPid())){
			Product p1 = map.get(p.getPid());
			p1.setPrice(p1.getPrice()+p.getPrice());
			p1.setQty(p1.getQty()+p.getQty());
			return true;	
		}
		map.put(p.getPid(),p);
		return false;
	}//addProduct
	
	public boolean removeProduct(String pid) 
    throws ProductNotFoundException {
		if(map.containsKey(pid)){
			map.remove(pid);
			return true;
		}else throw new ProductNotFoundException(
      "Product with ID "+pid+" is not Found.");
	}
	
	public Collection<Product> getCartDetails(){
		return map.values();
	}
	
	public Product getProductFromCart(String pid) 
    throws ProductNotFoundException {
		if(map.containsKey(pid)){
			return map.get(pid);
		}else {
			throw new ProductNotFoundException(
        "Product with ID "+pid+" is not Found.");
		}
	}
	
	public int productCount(){
		return map.size();
	}
  
  public double getCartPrice() {
    double price = 0.0d;
    Iterator<Product> iterator = getCartDetails().iterator();
    while(iterator.hasNext()){
      price+= iterator.next().getPrice();
    }
    return price;
  }
}
