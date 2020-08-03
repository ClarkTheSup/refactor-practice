package com.twu.refactoring;

public class West extends Direction{
    public West() {
        super('W');
    }

    @Override
    public Direction turnRight() {
        return new South();
    }

    @Override
    public Direction turnLeft() {
        return new North();
    }
}
