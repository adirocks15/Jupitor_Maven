package com.jupiter.interfaces;

import com.jupiter.pages.Product;

public class CompareByTitleStrategy implements ICompareStrategy {
	
	public String productTitle;
	
	public CompareByTitleStrategy (String productTitle) {
		this.productTitle = productTitle;
	}
	public boolean compare(Product product) {
		return product.getTitle().equals(productTitle);
	}
}
