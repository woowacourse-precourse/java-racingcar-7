package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Input {
    public List<Car> getCarName() {
        String carNames = Console.readLine();
        validateInput(carNames);
        return addCar(carNames);
    }

    public int getAttemptCount() {
        String attemptCount = Console.readLine();
        validateInteger(attemptCount);
        return Integer.parseInt(attemptCount);
    }

    public List<Car> addCar(String name) {
        List<Car> cars = new ArrayList<>();
        for (String s : name.split(",")) {
            cars.add(new Car(s));
        }
        return cars;
    }

    public void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }

    public void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("문자열 입력이 필요합니다.");
        }
    }

    public void validateNameLength(String input) {
        if (Arrays.stream(input.split(","))
                .anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("차 이름은 5자 이하로 작성해야 합니다.");
        }
    }

    public void validateDuplicate(String input) {
        Set<String> cars = new HashSet<>();
        for (String s : input.split(",")) {
            if (!cars.add(s)) {
                throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public void validateSeparatorSplit(String input) {
        long commaCount = input.chars().filter(c -> c == ',').count();
        int splitInput = input.split(",").length - 1;
        if (commaCount != splitInput) {
            throw new IllegalArgumentException("입력은 문자열로 끝나야 합니다.");
        }
    }

    public void validateSeparator(String input) {
        for (String s : input.split(",")) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("쉼표가 연속이거나 이름 사이에 존재하지 않습니다.");
            }
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수형으로 작성해야 합니다.");
        }
    }

    public void validateInput(String input) {
        validateBlank(input);
        validateEmpty(input);
        validateNameLength(input);
        validateDuplicate(input);
        validateSeparator(input);
        validateSeparatorSplit(input);
    }
}