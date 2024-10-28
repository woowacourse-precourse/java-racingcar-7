package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private List<String> carNames = new ArrayList<>();
    private Map<String, String> carPositions = new HashMap<>();
    private int round;

    public void setCarName() {
        String inputCarName = Console.readLine();
        this.carNames = List.of(inputCarName.split(","));

        validateCarNames();

        for (String carName : carNames) {
            carPositions.put(carName, "");  // 초기 상태를 빈 문자열로 설정
        }
    }

    private void validateCarNames() {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("최소 2대의 자동차 이름을 입력해야 합니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다: " + carName);
            }
        }
    }

    public void setRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRound = Console.readLine();

        try {
            this.round = Integer.parseInt(inputRound);

            if (this.round < 1) {
                throw new IllegalArgumentException("라운드는 1 이상의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드는 정수여야 합니다.");
        }
    }


    public void inGame() {
    }
}
