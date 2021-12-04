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

    /**
     * will be used with multiplication and division
     **/
    void numberValidator(int a, int b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException();
        }
    }
}
