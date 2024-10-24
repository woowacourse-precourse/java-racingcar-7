package racingcar.View;

import racingcar.dto.RacingCarDTO;

import java.util.Map;

public class OutputView {

    /**
     * Print The result Of Each RaceCar Update Distance
     * Input : RacingCarDTO
     * Return : X
     */
    void printEachDistanceByRandomMovement(RacingCarDTO racingCarDTO){

        // 1. racingCarDTO 내부의 Map 데이터를 가져온다.
        Map<String, Integer> racingCarData = racingCarDTO.getRacingCarData();

        // 2. 각 racingCarData에 맞춰서 순서대로 출력 함수를 돌린다.
        for (Map.Entry<String, Integer> eachRacingCarData : racingCarData.entrySet()) {
            String NameOfEachRacingCar = eachRacingCarData.getKey();
            int distanceOfEachRacingCar = eachRacingCarData.getValue();

            // 각 차량의 이동 거리만큼 "-"를 반복해서 출력
            System.out.println(NameOfEachRacingCar + " : " + "-".repeat(distanceOfEachRacingCar));
        }
    }
}
