package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarValueAssigner {

    int MIN = 1; // 최소값
    int MAX = 10; // 최대값

    public void assignRandomValue(List<Car> cars) {

        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN, MAX); // 랜덤 값 생성

            car.setRandomValue(randomValue);// 자동차에 랜덤 값 할당


        }

    }



}
