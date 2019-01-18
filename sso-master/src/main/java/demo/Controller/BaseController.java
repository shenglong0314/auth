package demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {

   /* @RequestMapping("/dashboard/login")
    public String dashboard() {
        return "redirect:/#/";
    }*/

    @RequestMapping("/dashboard/login")
    public String dashboard() {
        return "index";
    }
    @RequestMapping("/dashboard/home")
    public String home() {
        return "home";
    }
}
