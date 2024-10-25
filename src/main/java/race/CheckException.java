package race;

import java.util.Map;

public class CheckException {

    public static void checkAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException("[잘못된 입력] 시도할 횟수는 0 또는 음수를 허용하지 않습니다.");
        }
    }

    public static void checkNameOfCar(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[잘못된 입력] 쉼표와 쉼표 사이에 자동자의 이름이 입력되지 않았습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[잘못된 입력] 자동자 이름의 길이가 5자 이상입니다.");
        }
    }

    public static void checkIsStart(Map<String, Integer> cars) {

        boolean isStart = false;

        for(int i : cars.values()) {
            if (i > 0) {
                isStart = true;
                break;
            }
        }

        if(!isStart) {
            throw new IllegalArgumentException("아무 자동차도 출발하지 않았습니다.");
        }
    }
}
