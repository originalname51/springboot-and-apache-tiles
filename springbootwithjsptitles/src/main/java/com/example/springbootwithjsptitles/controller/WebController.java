package com.example.springbootwithjsptitles.controller;

import com.example.springbootwithjsptitles.model.employee;
import com.example.springbootwithjsptitles.model.employeeForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private static List<employee> employees = new ArrayList<>();

    static {
        employees.add(new employee("Steve", "Jobs"));
        employees.add(new employee("Bill", "Gate"));
    }

    @GetMapping(value = {"/home"})
    public String homePage(Model model) {

        return "homePage";
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Model model) {

        model.addAttribute(employees);
        return "listEmployee";
    }

    @GetMapping("/addEmployee")
    public String EmployeeForm(Model model) {

        employeeForm employeeForm = new employeeForm();
        model.addAttribute("employeeForm",employeeForm);
        return "addEmployee";
    }

    @Value("${error.message}")
    private String errorMessage;

    @PostMapping("/addEmployee")
    public String addEmployee(Model model, @ModelAttribute("EmployeeForm") employeeForm employeeForm) {

        String firstName = employeeForm.getFirstName();
        String lastName = employeeForm.getLastName();
        if(firstName != null && firstName.length() > 2 && lastName != null && lastName.length() > 2) {
            employee employee = new employee(firstName, lastName);
            return "redirect:/listEmployee";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addEmployee";
    }

    @GetMapping("/contactus")
    public String contactusPage(Model model) {
        model.addAttribute("address", "Vietnam");
        model.addAttribute("facebook", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }
}
