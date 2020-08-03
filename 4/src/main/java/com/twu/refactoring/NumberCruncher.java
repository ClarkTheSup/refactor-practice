package com.twu.refactoring;

import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public long countEven() {
        return Arrays.stream(numbers).filter(num -> num % 2 == 0).count();
    }

    public long countOdd() {
        return Arrays.stream(numbers).filter(num -> num % 2 == 1).count();
    }

    public long countPositive() {
        return Arrays.stream(numbers).filter(num -> num >= 0).count();
    }

    public long countNegative() {
        return Arrays.stream(numbers).filter(num -> num < 0).count();
    }
}
