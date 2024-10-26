package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameCarParsingList {
    public static List<GameCar> createGameCarList(String userInput) {
        List<String> carNames = ParsingCar.parseInputCarToList(userInput);
        List<GameCar> gameCarList = new ArrayList<>();

        for (String carName : carNames) {
            gameCarList.add(new GameCar(carName));
        }
        return gameCarList;
    }
}
