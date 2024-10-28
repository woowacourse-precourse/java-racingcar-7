package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Output;

import java.util.List;

public class RacingGame {
    private final Output output = new Output();
    private final List<Car> carList;
    private final int number;
    public RacingGame(List<Car> carList, int num) {
        this.carList = carList;
        this.number = num;
    }

    public void start() {
        for(int i = 0; i < number; i++) {
            playTurn();
            output.printTurn(carList);
        }
        output.printWinner(findWinner());
    }

    public List<String> findWinner() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
        List<String> winnerList = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        return winnerList;
    }

    public void playTurn() {
        carList.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }
}
