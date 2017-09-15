package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.User;

public class UserValidator implements Validator {

    public boolean supports(Class<?> c) {
        //just validate the User instances
        return User.class.isAssignableFrom(c);
    }

    public void validate(Object target, Errors errors) {
        validatePage1Form(target, errors);
        validatePage2Form(target, errors);
        validatePage3Form(target, errors);
    }

    //validate page 1, userName
    public void validatePage1Form(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "required.userName", "Field name is required.");
    }

    //validate page 2, password
    public void validatePage2Form(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Field password is required.");
    }

    //validate page 3, mail
    public void validatePage3Form(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail",
                "required.mail", "Field maill is required.");
    }

}
