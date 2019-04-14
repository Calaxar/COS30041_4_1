/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.MyuserDTO;
import java.util.Date;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

	public String updateUser() {
		String result = "failure";
		if (isValidUserid(userid) && isValidName(name) && isValidPassword(password) && isValidPassword(cPassword) && isValidEmail(email) && isValidPhone(phone) && isValidAddress(address) && isValidSecQn(secQn) && isValidSecAns(secAns) && password.equals(cPassword)) {
			MyuserDTO myuserDTO = new MyuserDTO(userid, name, password, email, phone, address, secQn, secAns);
			if (myuserFacade.updateRecord(myuserDTO)) {
				result = "success";
				sendEmail();
			}
		}
		return result;
	}

	public void sendEmail() {
		String smtpServer = "smtp.gmail.com";
		String from = "person@mail.com";
		String to = "person2@mail.com";
		String subject = "Netbeans data update";
		String body = "Hi Person2,\nNetbeans data attached to your email has been updated (by you probably).\nIf it wasn't you... panic\n - Person\n";
		String emailUser = from;
		String password = "********";
		try {
			Properties props = System.getProperties();
			// --Attaching to   default Session, or we could start a new one --
			props.put("mail.smtp.host", smtpServer);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", true);
			// --prepare a password authenticator --
			MyAuthenticator myPA = new MyAuthenticator(emailUser, password);
			// see MyAuthenticator class
			// get a session
			Session session = Session.getInstance(props, myPA);
			// --Create a new message --
			Message msg = new MimeMessage(session);
			// --Set the FROM and TO fields --
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			// --Set the subject and body text --
			msg.setSubject(subject);
			msg.setText(body);
			// --Set some other header information --
			msg.setHeader("X-Mailer", "Gmail");
			msg.setSentDate(new Date());
			// --Send the message --
			Transport.send(msg);
			Transport.send(msg,emailUser, password);
			System.out.println("Message sent OK.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public class MyAuthenticator extends Authenticator {

		PasswordAuthentication mypa;

		public MyAuthenticator(String username, String password) {
			mypa = new PasswordAuthentication(username, password);
		}

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			return mypa;
		}
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
