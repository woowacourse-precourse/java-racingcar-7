package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Car> cars;
    private int raceCount;

    public Game(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    // 경주 시작
    public void startRace() {
        for (int i=0; i<raceCount; i++) {
            randomMove();
            // 각 차수 별 상태 출력
            RacingCarOutput output = new RacingCarOutput();
            output.getRaceState(cars);
        }
    }

    // 자동차별 난수 발생
    public void randomMove() {
        for (Car c : cars) {
            c.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<String> getFinalWinners() {
        int maxLength = cars.stream().mapToInt(Car::getLength).max().getAsInt();
        List<String> list = new ArrayList<>();
        for (Car c : cars) {
            if (c.getLength() == maxLength) {
                list.add(c.getName());
            }
        }
        return list;
    }
}
