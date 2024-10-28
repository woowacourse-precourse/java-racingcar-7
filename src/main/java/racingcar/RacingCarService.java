package racingcar;

import java.util.*;

public class RacingCarService {
    PlayGame playGame;
    PrintWinner printWinner;
    List<Car> cars;

    public RacingCarService() {
        playGame = new PlayGame();
        printWinner = new PrintWinner();
        cars = new ArrayList<>();
    }

    public void set(List<String> carNames, int trycount) {
        for(int i = 0; i < carNames.size(); i++) {
            Car newCar = new Car(carNames.get(i));
            cars.add(newCar);
        }

        playGame.play(cars, trycount);
        printWinner.finishGame(cars);
    }
}
