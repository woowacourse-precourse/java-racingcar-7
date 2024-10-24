package racingcar.service;

import racingcar.dto.RacingCarDTO;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class RacingCarServiceImpl {

    /**
     * Method Type : void
     * Input : RacingCarDto
     * Detail
     * - Get Random Number for each RacingCar
     * - Move Each RacingCar and Update Each distance in DTO
     */
    public static void moveRacingCarByRandom(RacingCarDTO racingCarDTO) {
        // 1. racingCarDTO 내부의 Map 데이터를 가져온다.
        Map<String, Integer> racingCarData = racingCarDTO.getRacingCarData();

        // 2. 각 racingCarData에 맞춰서 순서대로 랜덤 함수를 돌린다.
        for (Map.Entry<String, Integer> eachRacingCarData : racingCarData.entrySet()) {

            // 랜덤 숫자를 생성해서 차의 이동 거리를 +1 or 유지
            int newDistance = eachRacingCarData.getValue() + getRandomMovementResult();

            // RacingCarDTO의 Upate method를 새용해서 Service에서 직접 데이터를 수정하지않음
            racingCarDTO.updateRacingCarDistance(eachRacingCarData.getKey(), newDistance);
        }
    }


    private static int getRandomMovementResult(){
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        if (pickNumberInRange(0, 9) >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
