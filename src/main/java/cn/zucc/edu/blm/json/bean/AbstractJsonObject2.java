package cn.zucc.edu.blm.json.bean;

import java.util.Date;

import cn.zucc.edu.blm.json.status.StatusObject;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class AbstractJsonObject2 {

	private int code;
	// 
	private String msg;



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the time
	 */

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setContent(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setStatusObject(StatusObject statusObject) {
		this.code = statusObject.getCode();
		this.msg = statusObject.getMsg();
	}
}
