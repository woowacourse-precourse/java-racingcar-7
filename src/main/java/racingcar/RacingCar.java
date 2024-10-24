package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.view.InputView;

public class RacingCar {

    public void run() {
        String[] carNames = InputView.getCarNames().split(",");
        int numberOfAttempts = InputView.getNumberOfAttempts();

        Map<String, Integer> cars = createCar(carNames);

        for (int i = 0; i < numberOfAttempts; i++) {
            playRound(cars);
            showRaceProgress(cars);
        }

        List<String> winners = findWinner(cars);
        showResult(winners);
    }

    public Map<String, Integer> createCar(String[] carNames) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNames) {
            cars.put(name, 0);
        }
        return cars;
    }

    public List<String> findWinner(Map<String, Integer> cars) {
        List<Entry<String, Integer>> carList = new ArrayList<>(cars.entrySet());
        carList.sort(((o1, o2) -> cars.get(o2.getKey()) - cars.get(o1.getKey())));

        List<String> winners = new ArrayList<>();
        Integer maxValue = carList.getFirst().getValue();

        for (Entry<String, Integer> car : carList) {
            if (car.getValue() != maxValue) {
                break;
            }
            winners.add(car.getKey());
        }
        return winners;
    }

    private boolean canMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }

    private void playRound(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
        }
    }

    private void showRaceProgress(Map<String, Integer> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.print(car.getKey() + " : ");
            for (int j = 0; j < car.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void showResult(List<String> winners) {
        System.out.println();
        System.out.println("최종 우승자 : " + winners);
    }
}
