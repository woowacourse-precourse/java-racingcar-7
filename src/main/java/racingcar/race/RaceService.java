package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.CarService;

public class RaceService {
    public void race(List<Car> cars) {
        for (Car car : cars) {
            if (isMove(createRandomNumber())) {
                car.setTotalMove();
            }
        }
    }

    public int createRandomNumber() {
        // 생성한 무작위 숫자 반환
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<String> getChampion(List<Car> participant) {
        return participant.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Comparator.comparingInt(Car::getTotalMove)),
                        Collectors.toList(),
                        (maxTotalMove, cars) -> cars.stream()
                                .filter(car -> maxTotalMove.orElseThrow().getTotalMove() == car.getTotalMove())
                                .map(Car::getName)
                                .collect(Collectors.toList())
                ));
    }
}
