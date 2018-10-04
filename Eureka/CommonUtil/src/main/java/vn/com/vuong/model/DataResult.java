package vn.com.vuong.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.BaseData;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> implements Serializable, BaseData {
	private int total;
	private List<T> results;
}
