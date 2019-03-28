/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author calum
 */
@Entity
@Table(name = "MYUSER")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Myuser.findAll", query = "SELECT m FROM Myuser m"),
	@NamedQuery(name = "Myuser.findByUserid", query = "SELECT m FROM Myuser m WHERE m.userid = :userid"),
	@NamedQuery(name = "Myuser.findByName", query = "SELECT m FROM Myuser m WHERE m.name = :name"),
	@NamedQuery(name = "Myuser.findByPassword", query = "SELECT m FROM Myuser m WHERE m.password = :password"),
	@NamedQuery(name = "Myuser.findByEmail", query = "SELECT m FROM Myuser m WHERE m.email = :email"),
	@NamedQuery(name = "Myuser.findByPhone", query = "SELECT m FROM Myuser m WHERE m.phone = :phone"),
	@NamedQuery(name = "Myuser.findByAddress", query = "SELECT m FROM Myuser m WHERE m.address = :address"),
	@NamedQuery(name = "Myuser.findBySecqn", query = "SELECT m FROM Myuser m WHERE m.secqn = :secqn"),
	@NamedQuery(name = "Myuser.findBySecans", query = "SELECT m FROM Myuser m WHERE m.secans = :secans")})
public class Myuser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USERID")
	private String userid;
	@Size(max = 30)
    @Column(name = "NAME")
	private String name;
	@Size(max = 6)
    @Column(name = "PASSWORD")
	private String password;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Size(max = 30)
    @Column(name = "EMAIL")
	private String email;
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
	@Size(max = 10)
    @Column(name = "PHONE")
	private String phone;
	@Size(max = 60)
    @Column(name = "ADDRESS")
	private String address;
	@Size(max = 60)
    @Column(name = "SECQN")
	private String secqn;
	@Size(max = 60)
    @Column(name = "SECANS")
	private String secans;

	public Myuser() {
	}

	public Myuser(String userid) {
		this.userid = userid;
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

	public String getSecqn() {
		return secqn;
	}

	public void setSecqn(String secqn) {
		this.secqn = secqn;
	}

	public String getSecans() {
		return secans;
	}

	public void setSecans(String secans) {
		this.secans = secans;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userid != null ? userid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Myuser)) {
			return false;
		}
		Myuser other = (Myuser) object;
		if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Myuser[ userid=" + userid + " ]";
	}
	
}
