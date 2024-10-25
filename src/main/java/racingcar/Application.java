package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    public static void main(String[] args) throws IllegalArgumentException {
        Application application = new Application();
        InputHandler inputHandler = new InputHandler();

        application.playGames(inputHandler.getCarNames(), inputHandler.getNumberOfGames());
    }
}
