package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.RacingInfoDTO;
import racingcar.model.Car;

import java.math.BigInteger;
import java.util.List;

public class RacingService {

    // 자동차 경주
    public void racing(RacingInfoDTO processedInput) {
        System.out.println();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(processedInput.getRaceRounds()) < 0; i = i.add(BigInteger.ONE)) {
            raceSingleRound(processedInput.getCarList());
        }
    }

    // 레이싱 한 라운드 수행
    public void raceSingleRound(List<Car> carList) {
        for (Car car : carList) {
            if (getRandom() > 3) {
                car.moveForward();
            }
            car.printPosition();
        }
        System.out.println();
    }

    // 무작위 수 구하기
    public int getRandom() {
        return Randoms.pickNumberInRange(0,9);
    }

}
