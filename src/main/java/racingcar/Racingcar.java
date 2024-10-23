package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racingcar {
    private List<Car> carList = new ArrayList<>();

    public void splitInputValue(String input_value) {
        String[] carNames = input_value.split(",");
        for (String carName : carNames) {
            ErrorValidator.carName(carName);
            createCars(carName);
        }
    }

    public void createCars(String carName) {
        Car car = new Car(carName);
        carList.add(car);
    }

    public void startGames(int game_count) {
        for (int i = 0; i < game_count; i++) {
            Game game = new Game(carList);
        }
    }

    public void start() {
        System.out.println(Contants.NOTICE_CAR_NAMES);
        String input_value = Console.readLine();
        splitInputValue(input_value);

        System.out.println(Contants.NOTICE_GAME_TIMES);
        String input_value2 = Console.readLine();
        ErrorValidator.gameCount(input_value2);

        int game_count = Integer.parseInt(input_value2);
        startGames(game_count);

    }
}
