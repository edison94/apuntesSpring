package controller;

import domain.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClienteController {
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    //El nombre del m√©todo puede ser el que yo quiera
    public ModelAndView initForm() {
        System.out.println("--- metodo cliente");
        
        // SI empleas <form: en el JSP, est· esperando un objeto en blanco con el nombre   command (por defecto) 
        
        ModelAndView mav = new ModelAndView("form1");
        Cliente c = new Cliente();
        mav.getModelMap().put("cliente", c);
        return mav;
        
        //Habria otra opcion en vez de las 4 lineas anteriores
        //     return new ModelAndView("form1", "command", new Cliente());
        // En este caso lo que ocurre es que pasasmos el objeto vacio 
        // EN el JSP deberiamos quitar lo de    commandName. No deberia haber ninguno
    }

    @RequestMapping(value = "/addCliente", method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("cliente") Cliente cliente,
            ModelMap model) {
        System.out.println("--- metodo addcliente");
        model.addAttribute("nombre", cliente.getNombre());
        model.addAttribute("password", cliente.getPassword());
        model.addAttribute("id", cliente.getId());

        return "form2";
    }
}
