package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
//import validator.UserValidator;

@Controller
//@RequestMapping("/user.htm")
//Lo hacemos asi cuanndo tenenmos una app donde se guardan datos que se usarran en paginas posteriores(ej. restaurante)
@SessionAttributes("command")
//SI fueran varios
//@SessionAttributes(value={"sessAttr1","sessAttr2","sessAttr3"})
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String initForm(final ModelMap modelMap) {
        System.out.println("--- metodo inicial");
        modelMap.addAttribute("command", new User());
        return "Page1Form";
    }
    
    @RequestMapping(params = "_target0")    
    public String processFirstStep0(final @ModelAttribute("command") User command,
            final Errors errors) {
        return "Page1Form";
    }

    @RequestMapping(params = "_target1")
    public String processFirstStep1(final @ModelAttribute("command") User command,
            final Errors errors) {
        return "Page2Form";
    }

    @RequestMapping(params = "_target2")
    public String processFirstStep2(final @ModelAttribute("command") User command,
            final Errors errors) {
        return "Page3Form";
    }

    @RequestMapping(params = "_finish")
    public String processFinish(final @ModelAttribute("command") User command,
            final Errors errors,
            final ModelMap modelMap,
            final SessionStatus status) {
        System.out.println("--- En Finish");
        //System.out.println((User) command);
        return "ResultForm";
    }

    //A donde voy cuando se hace clic en cancel
    @RequestMapping(params = "_cancel")
    public String processCancel(final HttpServletRequest request,
            final HttpServletResponse response,
            final SessionStatus status) {
        //Olvidar el objeto
        status.setComplete();
        return "Cancel";
    }

    /*
     @Override
     protected void validatePage(Object command, Errors errors, int page) {

     UserValidator validator = (UserValidator) getValidator();

     //page is 0-indexed
     switch (page) {
     case 0: //if page 1 , go validate with validatePage1Form
     validator.validatePage1Form(command, errors);
     break;
     case 1: //if page 2 , go validate with validatePage2Form
     validator.validatePage2Form(command, errors);
     break;
     case 2: //if page 3 , go validate with validatePage3Form
     validator.validatePage3Form(command, errors);
     break;
     }
     }
     */
}
