package cn.zucc.edu.blm.json.bean;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ListObject2 extends AbstractJsonObject2 {

	// 列表对象
	private int count;
	private List<?> items;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

}
