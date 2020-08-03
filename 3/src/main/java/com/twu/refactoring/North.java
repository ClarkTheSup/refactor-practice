package com.twu.refactoring;

public class North extends Direction{
    public North() {
        super('N');
    }

    @Override
    public Direction turnRight() {
        return new East();
    }

    @Override
    public Direction turnLeft() {
        return new West();
    }
}
