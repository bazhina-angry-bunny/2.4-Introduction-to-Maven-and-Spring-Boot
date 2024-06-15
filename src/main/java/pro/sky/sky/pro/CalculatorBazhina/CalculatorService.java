package pro.sky.sky.pro.CalculatorBazhina;

public interface CalculatorService {
    // Интерфейс по умолчанию определяет всем методам модификатор public
    String welcomeMessage();

    Integer sum(int num1, int num2);

    Integer minus(int num1, int num2);

    Integer multiply(int num1, int num2);

    Integer divide(int num1, int num2);

}