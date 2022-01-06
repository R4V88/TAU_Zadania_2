package tau.lab1.kalkulator;

public class Calculator {
    public static void main(String[] args) {

    }

    int addition(int a, int b) {
        return a + b;
    }

    int subtraction(int a, int b) {

        return a - b;
    }

//    int multiplication(int a, int b) {
//        return a * b;
//    }

    double division(int a, int b) {
        return a / numberValidator(b);
    }

    /**
     * will be used with division
     **/
    Integer numberValidator(int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Can not divide by 0");
        } else
            return b;
    }
}
