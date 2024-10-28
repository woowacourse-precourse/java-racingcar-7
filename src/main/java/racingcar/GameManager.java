package racingcar;

import static racingcar.CarFactory.createCars;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameManager {
    private final InputProcesser inputProcesser;
    private final OutputProcesser outputProcesser;
    private final RaceManager raceManager;

    public GameManager(InputProcesser inputProcesser, OutputProcesser outputProcesser) {
        this.inputProcesser = inputProcesser;
        this.outputProcesser = outputProcesser;
        this.raceManager = new RaceManager(outputProcesser);
    }


    public void run() {
        String carNames = inputProcesser.getCarNames();
        int tryNums = inputProcesser.getTryNums();
        List<Car> cars = CarFactory.createCars(carNames);
        raceManager.startRace(cars, tryNums);
        String winnerNames = raceManager.getWinners(cars);
        outputProcesser.printWinners(winnerNames);
    }
}
