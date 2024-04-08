package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")   //localhost로 /를 호출하면 이 부분이 실행이 됨
    public String home() {
        return "home"; //home.html이 호출이 된다.
    }
}