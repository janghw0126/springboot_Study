package hello.hellospring.controller;
import org.springframework.ui.Model;  //
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {
    @GetMapping("hello") // 웹 어플리케이션에서 /hello를 호출하면 이 메서드를 호출하게 됨
    public String hello(Model model){ // MVC에서의 model
        model.addAttribute("data","hello!!"); //data를 hello!!로 넘길꺼임
        return "hello";
    }
}
