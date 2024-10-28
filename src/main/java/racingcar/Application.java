package racingcar;

import racingcar.controller.Controller;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        new Controller(view);
    }
}
