package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConditionCar {
    private final String name;
    private int position;

    // 자동차 이름이 5자를 초과한 경우 예외 처리
    public ConditionCar(String name) {
        validateCarName(name); // 이름에 대한 검증 수행
        this.name = name.trim();
        this.position = 0;
    }

    // 자동차의 이름 검증 메서드들

    // 1. 자동차의 개수가 2개 미만인 경우
    public static void validateCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차의 개수는 2대 이상이어야 합니다.");
        }
    }

    // 2. 이름이 앞뒤 공백을 제거했을 때 0자인 경우
    private void validateEmptyName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 비어 있을 수 없습니다.");
        }
    }

    // 3. 자동차 이름이 5자를 초과한 경우
    private void validateNameLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    // 4. 자동차 이름이 중복되는 경우
    public static void validateDuplicateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (!nameSet.add(name.trim())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    // 전체 이름 검증 함수
    private void validateCarName(String name) {
        validateEmptyName(name);
        validateNameLength(name);
    }

    // 시도 횟수에 대한 예외 처리 메서드들

    // 5. 시도할 횟수에 수가 아닌 값을 입력한 경우
    public static int validateRoundInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    // 6. 시도할 횟수에 0 이하의 값 또는 int 범위를 초과하는 값을 입력한 경우
    public static void validateRoundRange(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
        if (rounds > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("시도할 횟수가 int 범위를 초과했습니다.");
        }
    }

    // 자동차 전진 기능
    public void move() {
        // 전진하는 조건 (랜덤 값 4 이상일 경우)
        if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}