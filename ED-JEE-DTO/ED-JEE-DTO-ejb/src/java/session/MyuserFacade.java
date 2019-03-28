/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Myuser;
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
}
