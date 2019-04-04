/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edjee;

import entity.MyuserDTO;
import javax.ejb.EJB;
import session.MyuserFacadeRemote;

/**
 *
 * @author calum
 */
public class MyuserAppClient {

	@EJB
	private static MyuserFacadeRemote myuserFacade;

	public
			MyuserAppClient() {
	}

	public static void main(String[] args) {
		MyuserAppClient client = new MyuserAppClient();
		// assuming inputs from keyboard or any GUI
		MyuserDTO myuserDTO = new MyuserDTO("000001", "Wei Lai", "123456",
				"wlai@swin.edu.au", "9876543210", "Swinburne EN510b",
				"What is my name?", "Wei");
		boolean result = client.createRecord(myuserDTO);
		client.showCreateResult(result, myuserDTO);
		// assuming inputs from keyboard or any GUI
		MyuserDTO myuserDTO2 = new MyuserDTO("000007", "Man Lai", "654321",
				"wlai@swin.edu.au", "9876543210", "Swinburne EN510b",
				"What is my name?", "Wei");
		result = client.createRecord(myuserDTO2);
		client.showCreateResult(result, myuserDTO2);
	}

	public void
			showCreateResult(boolean result, MyuserDTO myuserDTO) {
		if (result) {
			System.out.println("Record with primary key " + myuserDTO.getUserid() + " has been created in the database table.");
		} else {
			System.out.println("Record with primarykey " + myuserDTO.getUserid() + " could not be created in thedatabase table!");
		}
	}

	public Boolean createRecord(MyuserDTO myuserDTO) {
		return myuserFacade.createRecord(myuserDTO);
	}

}
