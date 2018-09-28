package vn.com.vuong.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
}
