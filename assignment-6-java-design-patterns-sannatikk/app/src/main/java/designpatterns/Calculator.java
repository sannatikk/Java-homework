package designpatterns;

public class Calculator {

    // private member to store the result of the calculation
    private Double result;

    // constructor that sets the initial value of the result
    public Calculator(Double result) {
        if (result == null) {
            throw new IllegalArgumentException("Initial value cannot be null");
        } else {
            this.result = result;
        }
    }

    // getter for the result
    public Double getResult() {
        return result;
    }

    // method for addition
    public Calculator add(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Value to add cannot be null");
        } else {
        result += value;
        return this;
        }
    }

    // method for subtraction
    public Calculator subtract(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Value to subtract cannot be null");
        } else {
        result -= value;
        return this;
        }
    }

    // method for multiplication
    public Calculator multiply(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Value to multiply cannot be null");
        } else {
        result *= value;
        return this;
        }
    }

    // method for division
    public Calculator divide(Double value) {
        if (value == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        result /= value;
        return this;
    }

}
