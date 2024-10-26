package racingcar;

import java.util.*;

public class RacingCarService {
    CreateCar createCar;
    PlayGame playGame;
    PrintWinner printWinner;
    List<String> carNames;
    List<Car> cars;
    int trycount;

    public RacingCarService() {
        createCar = new CreateCar();
        playGame = new PlayGame();
        printWinner = new PrintWinner();
    }

    public void play(List<String> carNames, int trycount) {
        this.carNames = carNames;
        this.trycount = trycount;

        for(int i = 0; i < carNames.size(); i++) {
            Car newCar = createCar.create(carNames.get(i));
            cars.add(newCar);
        }
    }
}
