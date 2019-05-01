/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author calum
 */
@FacesValidator("passwordValidator")
	public class PasswordValidator implements Validator {

		@Override
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			Object otherValue = component.getAttributes().get("otherValue");
			
			if (value == null || otherValue == null) {
				return;
			}
			
			if (!value.equals(otherValue)) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirm Password validation failed.", "Make sure Password and Confirm Password match");
				throw new ValidatorException(msg);
			}
		}
		
	}
