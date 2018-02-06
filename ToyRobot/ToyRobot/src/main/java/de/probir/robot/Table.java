package de.probir.robot;

import org.springframework.stereotype.Component;

@Component
public class Table {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    public boolean isPositionValid(int newX, int newY) {
        // both x and y can be the values from the range [0, 5)
        return newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT;
    }
}
