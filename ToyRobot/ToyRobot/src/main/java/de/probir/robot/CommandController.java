package de.probir.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

    @Autowired
    private Robot robot;

    @RequestMapping("/place")
    public String place(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y, @RequestParam(value = "f") Facing f) {
        return robot.place(x, y, f);
    }

    @RequestMapping("/move")
    public String move() {
        return robot.move();
    }

    @RequestMapping("/left")
    public String left() {
        return robot.left();
    }

    @RequestMapping("/right")
    public String right() {
        return robot.right();
    }

    @RequestMapping("/report")
    public String report() {
        return robot.report();
    }
}
