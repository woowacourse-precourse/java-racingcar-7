package racingcar;

import racingcar.racingcarController.Controller;
import racingcar.racingcarView.View;
import racingcar.racingcarModel.Model;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.run();


    }

}
