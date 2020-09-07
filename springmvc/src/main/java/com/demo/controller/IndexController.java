package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;

@SessionAttributes({"user"})
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/test.do")
    public ModelAndView getTest(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("HelloWorld");
        return modelAndView;
    }

    @RequestMapping(value = "/login.do")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
        @RequestParam("name") String name, @RequestParam(value = "pwd", required = false) String pwd) {
        ModelAndView modelAndView = new ModelAndView("Index");
        System.out.println("name:" + name + " pwd:" + pwd);
        return modelAndView;
    }

    @RequestMapping(value = "/login.do/{name}/{pwd}", method = RequestMethod.GET)
    public ModelAndView getlogin(HttpServletRequest request, HttpServletResponse response,
        @PathVariable(value = "name") String name, @PathVariable(value = "pwd") String pwd) {
        ModelAndView modelAndView = new ModelAndView("HelloWorld");
        System.out.println("name:" + name + " pwd:" + pwd);
        return modelAndView;
    }

//    @RequestMapping(value="/login.do",method=RequestMethod.POST)
//    public ModelAndView login2(HttpServletRequest request,HttpServletResponse response,String name,String pwd){
//        ModelAndView modelAndView = new ModelAndView("Index"); 
//        System.out.println("name:"+name+" pwd:"+pwd);
//        return modelAndView;
//        }

//    @RequestMapping(value="/login.do",method=RequestMethod.POST)
//    public ModelAndView login3(HttpServletRequest request,HttpServletResponse response,User user){
//        ModelAndView modelAndView = new ModelAndView("Index"); 
//        String username=request.getParameter("name");
//        System.out.println("username:"+username);
//        String pwd=request.getParameter("pwd");
//        System.out.println("pwd:"+pwd);
//        
//        System.out.println("name:"+user.getName()+" pwd:"+user.getPwd());
//        return modelAndView;
//        }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login4(HttpServletRequest request, HttpServletResponse response, User user) {
        ModelAndView modelAndView = new ModelAndView("Index");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/testModel.do", method = RequestMethod.GET)
    public String testModel(Model model) {
        User user = new User();
        user.setName("abc");
        user.setPwd("123456");
        model.addAttribute("user", user);
        return "Index";
    }

    @RequestMapping(value = "/requestbodybind.do", method = {RequestMethod.POST})
    @ResponseBody
    public User requestBodyBind(@RequestBody User user) {
        System.out.println("requestbodybind:" + user);
        return user;
    }

    @RequestMapping(value = "/testModelAttribute.do", method = RequestMethod.GET)
    public String testModelAttribute(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute("user") User user, @ModelAttribute("name") String name, Model model) {
        user.setName("abc");
        user.setPwd("123456");
        name = "testModelAttribute";
        model.addAttribute("name", name);
        return "Index";
    }

    @ModelAttribute(value = "mymap")
    public Map<String, Object> map() {
        User user = new User();
        user.setName("abc");
        user.setPwd("123456");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        return map;
    }

    @ModelAttribute
    public void voidmap(Model model) {
        User user = new User();
        user.setName("abcd");
        user.setPwd("123456");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        model.addAttribute("voidmap", map);
    }

}
