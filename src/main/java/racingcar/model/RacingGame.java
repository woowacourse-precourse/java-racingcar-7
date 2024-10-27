package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int round;

    public RacingGame(List<String> carNames, int round) {
        validateCarNames(carNames);
        validateRound(round);

        this.cars = duplicateNames(carNames).stream().map(Car::new).collect(Collectors.toList());
        this.round = round;
    }

    private List<String> duplicateNames(List<String> carNames) {
        Map<String, Integer> nameCount = new HashMap<>();

        for (String name : carNames) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        // 이름 리스트를 순회하면서 중복된 이름에만 숫자 접미사를 붙인다.
        List<String> uniqueNames = new ArrayList<>();
        Map<String, Integer> suffixCount = new HashMap<>();

        for (String name : carNames) {
            if (nameCount.get(name) > 1) {
                // 중복된 이름일 경우 숫자 접미사 추가
                int suffix = suffixCount.getOrDefault(name, 1);
                uniqueNames.add(name + suffix);
                suffixCount.put(name, suffix + 1);
            } else {
                // 고유한 이름은 그대로 추가
                uniqueNames.add(name);
            }
        }
        return uniqueNames;
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상 입력해야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 공백이 들어갈 수 없습니다.");
            }
            if (name.matches(".*\\d.*")) {
                throw new IllegalArgumentException("자동차 이름에는 숫자를 포함할 수 없습니다.");
            }
        }
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("1 이상의 정수여야 합니다.");
        }
    }

    public void race() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
