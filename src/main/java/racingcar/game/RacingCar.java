package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = getCarNamesFromUser();

        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    private List<String> getCarNamesFromUser() {
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(","))
                .peek(this::validateCarNameLength)
                .toList();
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘을 수 없습니다.");
        }
    }
}