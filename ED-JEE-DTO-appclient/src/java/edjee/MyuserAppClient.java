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

	public MyuserAppClient() {
	}

	public static void main(String[] args) {
		System.out.println("getRecord(000001):");
		MyuserDTO getRecordDTO = myuserFacade.getRecord("000001");
		if (getRecordDTO != null) {
			System.out.println(getRecordDTO.toString());
		}
		System.out.println("updateRecord() for ID 000001:");
		MyuserDTO myuserDTO = new MyuserDTO("000001", "Wai Lei", "654321",
				"wlai@swin.edu.au", "9876543210", "Swinburne EN510b",
				"What is my name?", "Wai");
		System.out.print("Before: ");
		System.out.println(myuserFacade.getRecord(myuserDTO.getUserid()).toString());
		myuserFacade.updateRecord(myuserDTO);
		System.out.print("After: ");
		System.out.println(myuserFacade.getRecord(myuserDTO.getUserid()).toString());
		System.out.println("deleteRecord(000005):");
		myuserFacade.deleteRecord("000005");
		if (myuserFacade.getRecord("000005") == null) {
			System.out.println("Record has been removed.");
		} else System.err.println("Record has not been removed.");
		System.out.println("getRecordsByAddress(\"Swinburne EN510b\")");
		for (MyuserDTO m: myuserFacade.getRecordsByAddress("Swinburne EN510b                                            ")) {
			System.out.println(m.toString());
		}
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
