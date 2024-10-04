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
        double result = 0;

        // Check the operator passed from the frontend
        String operation = numbers.getOperation();

        if ("+".equals(operation)) {
            result = numbers.getNumber1() + numbers.getNumber2();
        } else if ("-".equals(operation)) {
            result = numbers.getNumber1() - numbers.getNumber2();
        } else if ("*".equals(operation)) {
            result = numbers.getNumber1() * numbers.getNumber2();
        } else if ("/".equals(operation)) {
            // Ensure you're not dividing by zero
            if (numbers.getNumber2() != 0) {
                result = numbers.getNumber1() / numbers.getNumber2();
            } else {
                model.addAttribute("error", "Cannot divide by zero");
                return "addNumbers";
            }
        }

        // Reverse the input string if it's not empty
        String reversedString = "";
        if (numbers.getInputString() != null && !numbers.getInputString().isEmpty()) {
            reversedString = new StringBuilder(numbers.getInputString()).reverse().toString();
        }

        model.addAttribute("result", result);
        model.addAttribute("reversedString", reversedString);

        return "addNumbers";
    }
}
