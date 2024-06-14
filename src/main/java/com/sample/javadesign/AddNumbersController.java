package com.sample.javadesign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddNumbersController {
    @GetMapping("/addNumbers")
    public String showForm(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "addNumbers";
    }

    @PostMapping("/addNumbers")
    public String calculate(@ModelAttribute Numbers numbers, Model model) {
        int result;
        if("subtract".equals(numbers.getOperation())){
      result =    numbers.getNumber1() - numbers.getNumber2();}

   else if("add".equals(numbers.getOperation())){
            result =   numbers.getNumber1() + numbers.getNumber2();
            }
        else {
            result = 0; // or throw an error if unexpected operation
        }
        String reversedString = null;

        if (numbers.getInputString() != null && !numbers.getInputString().isEmpty()) {


            reversedString = new StringBuilder(numbers.getInputString()).reverse().toString();

        }
        model.addAttribute("result", result);
        model.addAttribute("reversedString", reversedString);
        return "addNumbers";


    }
}
