package net.therap.validator;

import net.therap.model.VCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: imranahmed
 * Date: 2/19/14
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class VCardValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return VCard.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "vCard.firstName.empty");
    }
}
