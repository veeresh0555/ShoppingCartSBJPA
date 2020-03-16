package com.shopping.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	
	 @JsonFormat(pattern = "dd-MM-yyyy")
	 private LocalDate orderdate;
	 
	 @Column(name="status")
	 private String status;
	 
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinColumn(name = "prodid")
	 private Product products;
	 
	 public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinColumn(name="userid")
	 private User usr;
	 
	 public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	@Column(name="quantity")
	 private long quantity; 
	 
	 @Column(name = "price")
	 private Double price;
	 
	 public Double getPrice() {
		 
			//List<Product> products=getProducts();
			double priced = 0D;
		/*
		 * for(Product p:products) { price += p.getPrice(); }
		 */
			
			priced=getProducts().getPrice()*getQuantity();
			
			return priced;
		}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getQuantity() {
		//List<Product> products=getProducts();
		//quantity=products.size();
		
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	 
}
