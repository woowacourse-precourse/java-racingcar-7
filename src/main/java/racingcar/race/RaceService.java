package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class RaceService {

    public int createRandomNumber() {
        // 생성한 무작위 숫자 반환
        return Randoms.pickNumberInRange(0, 9);
    }


    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Car> getChampion(List<Car> participant) {
        return participant.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Comparator.comparingInt(Car::getTotalMove)),
                        Collectors.toList(),
                        (maxTotalMove, cars) -> cars.stream()
                                .filter(car -> maxTotalMove.orElseThrow().getTotalMove() == car.getTotalMove())
                                .collect(Collectors.toList())
                ));
    }
}
