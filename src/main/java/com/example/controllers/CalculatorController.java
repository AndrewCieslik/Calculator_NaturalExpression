package com.example.controllers;

import com.example.model.OperationModel;
import com.example.service.CalculateSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

    OperationModel operationModel = new OperationModel();

    @Autowired
    private CalculateSimple calculateSimple;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model) {
        model.addAttribute("operationModel", operationModel);
        return "calculator";
    }

    public String handleOperator(OperationModel operationModel, Model model, String operator) {
        if(operationModel.getNowSecondNumber()){
            double result = calculate(operationModel,model);
            operationModel.setA(String.valueOf(result));
        }
        operationModel.setOperator(operator);
        operationModel.setNowSecondNumber(true);
        operationModel.setNaturalExpression(operationModel.getNaturalExpression() + " " + operator + " ");
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleOperator(operationModel, model, "+");
    }

    @RequestMapping(value = "/calculator", params = "subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleOperator(operationModel, model, "-");
    }

    @RequestMapping(value = "/calculator", params = "multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleOperator(operationModel, model, "*");
    }

    @RequestMapping(value = "/calculator", params = "divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleOperator(operationModel, model, "/");
    }

    @RequestMapping(value = "/calculator", params = "clear", method = RequestMethod.POST)
    public String clear(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("operationModel", calculateSimple.clearSimple(operationModel));

        operationModel.setA("");
        operationModel.setB("");
        operationModel.setOperator("");
        operationModel.setNowSecondNumber(false);

        model.addAttribute("result", 0);
        operationModel.setNaturalExpression("");
        return "calculator";
    }

    private String handleDigit(OperationModel operationModel, Model model, String digit) {
        if (operationModel.getNowSecondNumber()) {
            operationModel.setB(digit);
        } else {
            operationModel.setA(digit);
        }
        operationModel.setNaturalExpression(operationModel.getNaturalExpression() + digit);
        model.addAttribute("operationModel", operationModel);
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "one", method = RequestMethod.POST)
    public String handleOne(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "1");
    }

    @RequestMapping(value = "/calculator", params = "two", method = RequestMethod.POST)
    public String handleTwo(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "2");
    }

    @RequestMapping(value = "/calculator", params = "three", method = RequestMethod.POST)
    public String handleThree(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "3");
    }

    @RequestMapping(value = "/calculator", params = "four", method = RequestMethod.POST)
    public String handleFour(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "4");
    }

    @RequestMapping(value = "/calculator", params = "five", method = RequestMethod.POST)
    public String handleFive(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "5");
    }

    @RequestMapping(value = "/calculator", params = "six", method = RequestMethod.POST)
    public String handleSix(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "6");
    }

    @RequestMapping(value = "/calculator", params = "seven", method = RequestMethod.POST)
    public String handleSeven(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "7");
    }

    @RequestMapping(value = "/calculator", params = "eight", method = RequestMethod.POST)
    public String handleEight(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "8");
    }

    @RequestMapping(value = "/calculator", params = "nine", method = RequestMethod.POST)
    public String handleNine(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "9");
    }

    @RequestMapping(value = "/calculator", params = "zero", method = RequestMethod.POST)
    public String handleZero(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        return handleDigit(operationModel, model, "0");
    }

    public double calculate(OperationModel operationModel, Model model) {
        double result = 0;

        String a = operationModel.getA();
        String b = operationModel.getB();

        String operator = operationModel.getOperator();

        switch (operator) {
            case "+":
                result = Double.parseDouble(a) + Double.parseDouble(b);
                break;
            case "-":
                result = Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "*":
                result = Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "/":
                if (!b.equals("0")) {
                    result = Double.parseDouble(a) / Double.parseDouble(b);
                } else {
                    result = Double.NaN;
                }
        }
        return result;
    }

    @RequestMapping(value = "/calculator", params = "calculate", method = RequestMethod.POST)
    public String handleResult(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        double result = calculate(operationModel, model);

        model.addAttribute("result", result);

            if (!Double.isNaN(result)) {
                operationModel.setNaturalExpression(operationModel.getNaturalExpression() + " = " + result);
            }
        operationModel.setWebResult(String.valueOf(result));
        return "calculator";
    }
}
