package de.probir.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    @Autowired
    private Table table;

    private Facing facing;
    private boolean placed;
    private int x;
    private int y;

    /**
     * Places a robot on a table if it wasn't placed already and the coordinates
     * are valid
     *
     * @param newX to be used as X coordinate
     * @param newY to be used as Y coordinate
     * @param f to face on
     * @return resulting fail/success message
     */
    public String place(int newX, int newY, Facing f) {
        if (table.isPositionValid(newX, newY)) {
            placed = true;
            x = newX;
            y = newY;
            facing = f;
            return "Robot placed at " + newX + ", " + newY;
        } else {
            return "ROBOT can't be placed";
        }
    }

    /**
     * Moves the robot in the facing direction if possible
     * @return resulting fail/success message
     */
    public String move() {
        if (!placed) {
            return "ROBOT MISSING";
        }
        // temporary coords
        int tmpX = x;
        int tmpY = y;
        switch (facing) {
            case NORTH:
                // facing north, increase y
                tmpY++;
                break;
            case SOUTH:
                // facing south, decrease y
                tmpY--;
                break;
            case EAST:
                // facing east, increase x
                tmpX++;
                break;
            case WEST:
                // facing west, decrease x
                tmpX--;
                break;
        }
        // if temp coords are valid for move
        if (table.isPositionValid(tmpX, tmpY)) {
            // assign them to the real coords
            x = tmpX;
            y = tmpY;
            return "Moved to " + x + "," + y;
        }
        return "Can't move to " + tmpX + "," + tmpY;
    }

    /**
     * Rotates the robot to the left
     * @return resulting fail/success message
     */
    public String left() {
        if (!placed) {
            return "ROBOT MISSING";
        }
        switch (facing) {
            case NORTH:
                facing = Facing.WEST;
                break;
            case SOUTH:
                facing = Facing.EAST;
                break;
            case EAST:
                facing = Facing.NORTH;
                break;
            case WEST:
                facing = Facing.SOUTH;
                break;
        }
        return "Facing " + facing;
    }

    /**
     * Rotates the robot to the right
     * @return resulting fail/success message
     */
    public String right() {
        if (!placed) {
            return "ROBOT MISSING";
        }
        switch (facing) {
            case NORTH:
                facing = Facing.EAST;
                break;
            case SOUTH:
                facing = Facing.WEST;
                break;
            case EAST:
                facing = Facing.SOUTH;
                break;
            case WEST:
                facing = Facing.NORTH;
                break;
        }
        return "Facing " + facing;
    }

    /**
     * Report the current cords and the facing
     * @return resulting fail/success message
     */
    public String report() {
        if (!placed) {
            return "ROBOT MISSING";
        }
        return x + "," + y + "," + facing;
    }
}
