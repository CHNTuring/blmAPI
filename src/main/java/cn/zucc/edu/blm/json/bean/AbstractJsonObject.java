package cn.zucc.edu.blm.json.bean;

import cn.zucc.edu.blm.json.status.StatusObject;
import org.springframework.stereotype.Component;

import java.util.Date;



/**
 *
 */
@Component
public class AbstractJsonObject {

	private int code;
	// 
	private String msg;

	private Date time = new Date();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

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
