package hello.hellospring.controller;
import org.springframework.ui.Model;  //
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // 웹 어플리케이션에서 /hello를 호출하면 이 메서드를 호출하게 됨
    public String hello(Model model){ // MVC에서의 model
        model.addAttribute("data","hello!!"); //data를 hello!!로 넘길꺼임
        return "hello"; //templates파일의 hello.html로 가게 함
    }
    @GetMapping("hello-mvc")
    //파라미터를 이용하면 이전에 "model.addAttribute("data","hello!!");"을 통해 직접 스프링이 받는 대신
    //외부(웹사이트)에서 url 파라미터로 바꿔서 String name, Model model에 담으면 뷰에서 쓸 수 있음
    public String helloMvc(@RequestParam("name") String name, Model model){ //웹에서 파라미터를 받을 예정
        //required - 기본이 True라서 안넣어도 됨
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);  //파라미터로 넘어온 name을 넣음
        return hello; //객체 넘기기
    }
    //class 안에서 class를 쓸 수 있음
    static class Hello {
        private String name;

        public String getName() {   // 꺼낼 때 getName()
            return name;
        }
        public void setName(String name) { // 넣을 때는 setName()
            this.name = name;
        }
    }
}
