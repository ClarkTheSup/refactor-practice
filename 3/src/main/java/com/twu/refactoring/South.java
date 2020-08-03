package com.twu.refactoring;

public class South extends Direction{
    public South() {
        super('S');
    }

    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }
}
