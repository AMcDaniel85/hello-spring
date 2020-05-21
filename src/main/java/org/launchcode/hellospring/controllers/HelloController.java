package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

@Controller
@ResponseBody
@RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //lives at /hello/hello
    //Handles request of the form /hello?name=LaunchCode
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

//    @GetMapping("form")
//    public String helloForm(){
//        String html =
//                "<html>" +
//                        "<body>" +
//                        "<form action='hello' method='post'>" + //submits a request to hello
//                        "<input type='text' name='name'/>" +
//                        "<input type='submit' value='Greet me!'/>" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
//        return html;
//    }
    @PostMapping("language")
    public static String displayMessage(ServletRequest request) {
        String lang = request.getParameter("Language");
        String name = request.getParameter("name");

        return lang + " " + name + "!";
    }
    //exercise 10.5
    @GetMapping("form")
    public static String createMessage(){
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action='language'>" +
                        "<input type='text' name='name'/>" +
                        "<label for='Language'>Select a language:</label>" +
                        "<select name='Language' id='Language'>" +
                        "<option value=''>--Please choose a language--</option>" +
                        "<option value='HELLO'>English</option>" +
                        "<option value='HOLA'>Spanish</option>" +
                        "<option value='BONJOUR'>French</option>" +
                        "<option value='HALLO'>German</option>" +
                        "<option value='NAMASTE'>Hindi</option>" +
                        "</select>" +
                        "<input type='submit' value='Greet me!'/>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }


}
