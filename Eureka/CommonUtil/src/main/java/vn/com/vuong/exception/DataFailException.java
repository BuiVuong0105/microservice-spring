package vn.com.vuong.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataFailException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
}
