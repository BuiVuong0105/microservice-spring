package vn.com.vuong.util;

public class API {
	public static final class Customer {
		public static final String SEARCH_CUSTOMER = "/customers";
	}
	public static final class Payment {
		public static final String SEARCH_PAYMENT = "/payments";
	}
	public static final class Product {
		public static final String SEARCH_PRODUCT = "/products";
		public static final String FIND_PRODUCT_BY_ID = "/product/{id}";
	}
}
