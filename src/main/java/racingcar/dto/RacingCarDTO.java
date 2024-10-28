package racingcar.dto;

import java.util.HashMap;

import static java.lang.Integer.*;

public class RacingCarDTO {

    private final HashMap<String, Integer> racingCarData;
    private final int numberOfRacing;

    public RacingCarDTO(String racingCarNameString, String numberOfRacingString) {
        this.racingCarData = new HashMap<>();
        String[] racingCarNames = racingCarNameString.split(",");

        // 각 레이싱카 이름에 대해 초기 이동거리를 0으로 설정하여 HashMap에 저장
        for (String name : racingCarNames) {
            racingCarData.put(name, 0);  // 처음 시작 시 이동 거리는 0
        }
        this.numberOfRacing = parseInt(numberOfRacingString);
    }

    public HashMap<String, Integer> getRacingCarData() {
        return racingCarData;
    }

    public int getNumberOfRacing() {
        return numberOfRacing;
    }

    // 특정 레이싱카의 이동 거리를 업데이트하는 메서드
    public void updateRacingCarDistance(String carName, int distance) {
        racingCarData.put(carName, distance);
    }
}
