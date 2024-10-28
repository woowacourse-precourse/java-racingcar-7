package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.car.Car;

public class RaceService {

    public int createRandomNumber() {
        // 생성한 무작위 숫자 반환
        return Randoms.pickNumberInRange(0, 9);
    }


    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<String> getChampion(/*List<Car> participant*/) {
        return null; // 경주 우승자 반환
    }
}
