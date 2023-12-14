package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("data", "modelValue");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 바디에 이 데이터를 직접 넣어준다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환
    }

    static class Hello {
        private String name;
        private String aa = "asdfasdf";

        public void setName(String name) {
            this.name = name;
        }

        public String getAa() {
            return aa;
        }

        public String getName() {
            return name;
        }
    }
}
// /hello 접속시
//Controller의 hello를 매핑
//hello에 해당 메서드는 model에서 데이터를 받고 value를 담아 hello.html에게 반환
