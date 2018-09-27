package vn.com.vuong.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
}
