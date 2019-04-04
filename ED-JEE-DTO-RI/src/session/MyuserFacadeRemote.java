/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.MyuserDTO;
import javax.ejb.Remote;

/**
 *
 * @author calum
 */
@Remote
public interface MyuserFacadeRemote {

	boolean createRecord(MyuserDTO myuserDTO);
	
}
