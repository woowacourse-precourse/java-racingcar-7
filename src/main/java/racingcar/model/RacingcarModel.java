package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class RacingcarModel {

    private Map<String, String> car = new HashMap<>();

    // 자동차 이름 초기화 (입력받은 자동차 이름으로 빈 상태 초기화)
    public void initializeCars(String[] carNames) {
        for (String name : carNames) {
            car.put(name, "");
        }
    }

    // 현재 자동차 상태 반환 (차수별로 출력할 수 있는 형식으로 반환)
    public Map<String, String> getCarStates() {
        return car;
    }

    // 무작위 값이 4 이상일 때만 전진
    public void advanceCar(String carName) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            car.put(carName, car.get(carName) + "-");
        }
    }

    public String getWinners() {
        int maxDistance = car.values().stream().mapToInt(String::length).max().orElse(0);
        StringBuilder winners = new StringBuilder();

        // 가장 많이 이동한 자동차(들) 찾기
        for (Map.Entry<String, String> entry : car.entrySet()) {
            if (entry.getValue().length() == maxDistance) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(entry.getKey());
            }
        }
        return winners.toString();  // 우승자 이름 반환
    }

}
