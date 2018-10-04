package vn.com.vuong.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable, BaseData {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Product> products;
}
