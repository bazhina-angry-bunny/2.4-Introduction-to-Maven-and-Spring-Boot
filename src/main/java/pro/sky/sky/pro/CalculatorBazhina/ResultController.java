package pro.sky.sky.pro.CalculatorBazhina;

import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    private final CalculatorService calculatorService;
    public ResultController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String welcomeMessage() {
        return calculatorService.welcomeMessage();
    }

    @GetMapping("/calculator/sum")
    public String sum(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
        if(num1 == null & num2 == null) {
            return "Все параметры не заданы, повторите ввод и обновите страницу";
        } else if(num1 == null) {
            return "Параметр " + "num1" + " не задан, повторите ввод и обновите страницу";
        } else if(num2 == null) {
            return "Параметр " + "num2" + "  не задан, повторите ввод и обновите страницу";
        } else
            return num1 + " + " + num2 + " = " + calculatorService.sum(num1, num2);
    }
    // http://localhost:8080/calculator/sum?num1=2&num2=2   после метода разделитель ? а вместо запятой между параметрами &

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1,num2);
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1,num2);
    }

    @RequestMapping(path = "/calculator/divide", method = RequestMethod.GET)
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        if(num2 == 0) {
            return "Деление на 0 запрещено!";
        } else
            return num1 + " / " + num2 + " = " + calculatorService.divide(num1,num2);
    }
    // можно просто записать      public String divide(int num1, int num2) - без аннотации @RequestParam, так как имя параметра для пользователя сейчас не меняю

}