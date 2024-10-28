package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private List<Car> cars;

    public void play() throws IllegalArgumentException {
        String[] carNames = readCarNames();
        int tryCnt = readTryCount();
        cars = new ArrayList<>();
        
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private String[] readCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    private int readTryCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCnt = Integer.parseInt(Console.readLine());
        return tryCnt;
    }
}
