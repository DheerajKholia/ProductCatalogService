package com.ecommerce.productcatalogservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void Test_AddWithTwoIntegers_RunsSuccessfully() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        int result = calculator.add(21,51);

        //Assert
        assert(result==72);
    }


    @Test
    public void Test_DivideByZero_ThrowsArithmeticException()  {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        //int res = calculator.divide(1,0);
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(1,0));
    }
}