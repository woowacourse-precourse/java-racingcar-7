package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;

public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    //자동차 별로 전진시키는 메소드
    public void race(Cars cars) {

        Iterator<String> carName = cars.getCars().keySet().iterator();

        while(carName.hasNext()){
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            cars.updateDistance(carName.next(), randomNumber);
        }
    }
}
