package com.online_perishable_store.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    public Long productid;
    @Column(name = "productname")
    public String productName;
    @Column(name = "producttype")
    public String productType;
    @Column(name = "productdescription")
    public String productDescription;
    @Column(name = "productprice")
    public Long productPrice;
    @Column(name = "productquantity")
    public Long productQuantity;
    @Column(name = "productimage")
    public String productImage;
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductType(){
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getProductDescription(){
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public Long getProductPrice(){
        return productPrice;
    }
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
    public Long getProductQuantity(){
        return productQuantity;
    }
    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }
    public String getProductImage(){
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    public void setProductid(Long productid){
        this.productid = productid;
    }
    public Long getProductid(){
        return productid;
    }
    @Override
    public String toString() {
        return "Product id : {"+productid+" ProductName : {"+productName+"} ProductType : {"+productType+"} ProductDescription : {"+productDescription+"} ProductPrice : {"+productPrice+"} ProductQuantity :"+productQuantity+"} productImage : {"+productImage+"}";
    }
}
