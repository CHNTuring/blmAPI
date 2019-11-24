package cn.zucc.edu.blm.json.bean;

import org.springframework.stereotype.Component;

@Component
public class SingleObject extends AbstractJsonObject {

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}



}
