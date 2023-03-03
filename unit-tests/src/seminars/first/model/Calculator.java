package seminars.first.model;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) throws ArithmeticException {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) throws ArithmeticException {
        if (number == 0) {
            throw new ArithmeticException("It is not possible to extract the root from 0");
        }
        if (number < 0) {
            throw new ArithmeticException("It is impossible to extract the root from negative numbers");
        }

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }

    /**
     * Дз 1
     * Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
     * Примерная сигнатура и тело метода:
     *
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return результат
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0;

        if (purchaseAmount >= 0) {

            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new java.lang.ArithmeticException("Скидка должна быть в интервале от 0 до 100%");
            }
        } else {
            throw new java.lang.ArithmeticException("Сумма покупки не может быть < 0");
        }

        return discountedAmount;
    }
}