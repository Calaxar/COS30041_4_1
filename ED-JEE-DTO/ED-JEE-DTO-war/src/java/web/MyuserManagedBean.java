/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.MyuserDTO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import session.MyuserFacadeRemote;

/**
 *
 * @author calum
 */
@ManagedBean
@RequestScoped
public class MyuserManagedBean {

	@EJB
	private MyuserFacadeRemote myuserFacade;

	private String userid;
	private String name;
	private String password;
	private String cPassword;
	// for confirmed password field
	private String email;
	private String phone;
	private String address;
	private String secQn;
	private String secAns;

	public
			MyuserManagedBean() {
	}

	/*
	 * add a user to the database
	 * @return "success" if the add operation is successful
	 *         "failure" otherwise
	 */
	public String addUser() {
		String result = "failure";
		/*
		 * are all data entered valid?
		 * and password the same as cPassword (case sensitive)
		 * before calling the façade’s createRecord() method
		 */
		if (isValidUserid(userid) && isValidName(name) && isValidPassword(password) && isValidPassword(cPassword) && isValidEmail(email) && isValidPhone(phone) && isValidAddress(address) && isValidSecQn(secQn) && isValidSecAns(secAns) && password.equals(cPassword)) {
			MyuserDTO myuserDTO = new MyuserDTO(userid, name, password, email, phone, address, secQn, secAns);
			if (myuserFacade.createRecord(myuserDTO)) {
				result = "success";
			}
		}
		return result;
	}
	/*Some basic checking,complicated checking can be done later.
	 *Not a good way of doing this
	 * Should use JSF’s validator method to do this –left as C task
	 */

	public boolean isValidUserid(String userid) {
		return (userid != null);
	}

	public boolean isValidName(String name) {
		return (name != null);
	}

	public boolean isValidPassword(String password) {
		return (password != null);
	}

	public boolean isValidEmail(String email) {
		return (email != null);
	}

	public boolean isValidPhone(String phone) {
		return (phone != null);
	}

	public boolean isValidAddress(String address) {
		return (address != null);
	}

	public boolean isValidSecQn(String secQn) {
		return (secQn != null);
	}

	public boolean isValidSecAns(String secAns) {
		return (secAns != null);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSecQn() {
		return secQn;
	}

	public void setSecQn(String secQn) {
		this.secQn = secQn;
	}

	public String getSecAns() {
		return secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

}
