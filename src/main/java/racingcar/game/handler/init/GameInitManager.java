package racingcar.game.handler.init;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.context.GameContext;
import racingcar.game.Game;
import racingcar.game.handler.round.GameRoundHandlerImpl;
import racingcar.printer.ResultPrinter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameInitManager {

    private static final String carInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String roundCountMessage = "시도할 횟수는 몇 회인가요?";

    public static Game init() {
        Game game = initGame();
        GameContext.setAttribute(Game.class, game);
        GameContext.setAttribute(ResultPrinter.class, new ResultPrinter());
        return game;
    }

    private static List<Car> initCars() {
        System.out.println(carInputMessage);
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();

        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() == 0) {
                throw new IllegalArgumentException("Invalid name : Zero name length");
            }
            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException("invalid name : Duplicate name");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static Game initGame() {
        List<Car> cars = initCars();
        System.out.println(roundCountMessage);
        int rounds = Integer.parseInt(Console.readLine());
        return new Game(cars, new GameRoundHandlerImpl(), rounds);
    }

}
