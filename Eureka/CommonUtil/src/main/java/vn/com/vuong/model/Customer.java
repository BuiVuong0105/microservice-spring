package vn.com.vuong.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Product> products;
}
