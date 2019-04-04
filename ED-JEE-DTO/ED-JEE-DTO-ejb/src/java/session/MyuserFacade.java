/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Myuser;
import entity.MyuserDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author calum
 */
@Stateless
public class MyuserFacade implements MyuserFacadeRemote {

	@PersistenceContext(unitName = "ED-JEE-DTO-ejbPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	private void create(Myuser myuser) {
		em.persist(myuser);
	}

	private void edit(Myuser myuser) {
		em.merge(myuser);
	}

	private
			void remove(Myuser myuser) {
		em.remove(em.merge(myuser));
	}

	private Myuser find(Object id) {
		return em.find(Myuser.class, id);
	}

	@Override
	public boolean createRecord(MyuserDTO myuserDTO) {
		if (find(myuserDTO.getUserid()) != null) {
		// user whose userid can be found 
			return false;
		}
		// user whose userid could not be found
		try {
			Myuser myuser = this.myDTO2DAO(myuserDTO);
			this.create(myuser);    // add to database
			return true;
		} catch (Exception ex) {
			return false; // something is wrong, should not be here though
		}
	}

	private Myuser myDTO2DAO(MyuserDTO myuserDTO) {
		Myuser myuser = new Myuser();
		myuser.setUserid(myuserDTO.getUserid());
		myuser.setName(myuserDTO.getName());
		myuser.setPassword(myuserDTO.getPassword());
		myuser.setEmail(myuserDTO.getEmail());
		myuser.setPhone(myuserDTO.getPhone());
		myuser.setAddress(myuserDTO.getAddress());
		myuser.setSecqn(myuserDTO.getSecQn());
		myuser.setSecans(myuserDTO.getSecAns());
		return myuser;
	}
}
