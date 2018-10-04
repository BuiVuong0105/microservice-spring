package vn.com.vuong.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.BaseData;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error implements Serializable, BaseData {
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
}
