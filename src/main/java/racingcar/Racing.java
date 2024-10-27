package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Racing {
    private String cars;
    private Integer attemptsCnt;
    private Map<String, String> racingCars;
    private final String DELIMITERS = ",";

    Racing() {}

    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Console.readLine();
        splitCarsName(cars);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String cntString = Console.readLine();
        validateAttemptsCnt(cntString);
    }

    private void splitCarsName(String cars) {
        String[] carNames = cars.split(DELIMITERS);
        validateCars(carNames);
        makeCarsDict(carNames);
    }

    private void makeCarsDict(String[] carNames) {
        racingCars = new HashMap<>();

        for (String name : carNames) {
            racingCars.put(name, "");
        }
    }

    private void validateCars(String[] carNames) {
        validateCarsCnt(carNames);
        validateCarNameLength(carNames);
    }

    private void validateCarsCnt(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("경기는 최소 2명부터 참여 가능합니다.");
        }
    }

    private void validateCarNameLength(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 6) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 작성 가능합니다.");
            }
        }
    }

    private void validateAttemptsCnt(String cntString) {
        attemptsCnt = validateAttemptsCntType(cntString);
        validateAttemptsCntSize(attemptsCnt);
    }

    private void validateAttemptsCntSize(Integer cnt) {
        if (cnt <= 0) {
            throw new IllegalArgumentException("시도할 수 있는 횟수는 1회 이상입니다.");
        }
    }

    private Integer validateAttemptsCntType(String cntString) {
        try {
            return Integer.valueOf(cntString);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
