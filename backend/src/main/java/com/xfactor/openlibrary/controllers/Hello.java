package com.xfactor.openlibrary.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Hello {

    @GetMapping("/hi/{name}/{n}")
    //@GetMapping("/hello")
    //public String sayhi(@PathVariable String name,@PathVariable int n) {
    public String hello(@RequestParam String name,int n) {
        //return "Show a number: "+name+" "+n;
        return "Show a number: "+name+", "+n;
    }
    @GetMapping("/Hola/{name}/{age}/{Gender}")
    public String sayhola(@PathVariable String name, @PathVariable char Gender,@RequestParam int age){
        return "Your Info: "+name+" "+age+" "+Gender;
    }
    @GetMapping("/hii/{name}/{age}")
    public HashMap<String, String> sayhii(@PathVariable String name,@PathVariable int age){
        HashMap<String, String> respHashMap=new HashMap<>();
        respHashMap.put("name",name);
        respHashMap.put("age",String.valueOf(age));
        return respHashMap;
    }

}

