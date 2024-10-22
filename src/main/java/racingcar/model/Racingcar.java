package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Racingcar {

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

}
