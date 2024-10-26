package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public record UserInputData(List<Car> cars, int tryCount) {
    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .forEach(winners::add);

        return winners;
    }

    public void tryingMoveCar() {
        for (int i = 0; i < tryCount; i++) {
            cars().stream()
                    .forEach((car)->car.tryMove(if60PercentChance()));
        }
    }

    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }

    public static List<Car> splitCarNames(String carNames) {
        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        cars.addAll(
                splitNames.stream()
                        .map(String::trim)
                        .peek(UserInputData::validateNameFormat)
                        .peek(UserInputData::validateNameLength)
                        .map(Car::new)
                        .collect(Collectors.toList())
        );
        return cars;
    }

    private static void validateNameLength(String inputname) {
        if (inputname.length() > 5) {
            throw new IllegalArgumentException("5글자 이하의 이름만 입력할 수 있습니다.");
        }
    }

    private static void validateNameFormat(String inputname) {
        String rex = "[\\W]+";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(inputname);

        if (matcher.find()) {
            throw new IllegalArgumentException("이름은 알파벳,숫자와 언더바(_)만 사용할 수 있습니다.");
        }
    }
}
