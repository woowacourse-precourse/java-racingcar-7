package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import racingcar.model.CarName;
import racingcar.model.CarScores;
import racingcar.model.Distance;

public class RaceService {
    public static CarScores playGame(CarScores previousCarScores) {
        LinkedHashMap<CarName, Distance> nowScores = new LinkedHashMap<>();

        // 전체 맵 돌면서
        // 랜덤 값 구하기
        // 전진이 필요한지 확인 후 전진
        // 결과 출력
        return previousCarScores;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private Distance moveOrStop(Distance previousDistance, int randomNumber) {
        if (randomNumber >= 4 && randomNumber <= 9) {
            return new Distance(previousDistance.move(randomNumber));
        }
        return previousDistance;
    }

}
