package racingcar;


import racingcar.app.CLICarGameApp;
import racingcar.app.CarGameApp;

public class Application {
    public static void main(String[] args) {
        CarGameApp app = new CLICarGameApp();
        CarGame game = app.initCarGame();
        game.play();
    }
}
