/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author calum
 */
public class MyuserDTO implements java.io.Serializable {
	private final String userid;
	private final String name;
	private final String password;
	private final String email;
	private final String phone;
	private final String address;
	private final String secQn;
	private final String secAns;

	public MyuserDTO(String userid, String name, String password, String email, String phone, String address, String secQn, String secAns) {
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.secQn = secQn;
		this.secAns = secAns;
	}

	public String getUserid() {
		return userid;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getSecQn() {
		return secQn;
	}

	public String getSecAns() {
		return secAns;
	}
	
	@Override
	public String toString() {
		return "|" + this.userid + "|" + this.name + "|" + this.password + "|" + this.email + "|" + this.phone + "|" + this.address + "|" + this.secQn + "|" + this.secAns + "|";
	}
}
