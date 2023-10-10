package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")   //웹에서 Param을 가져온다.
    public String helloMvc(@RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name); //Parameter로 넘어온 name을 넘겨본다.
        return "hello-template";   //이 템플릿으로 가게 된다.
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello" +name; //"hello spring"
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello
    {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

    }

}
