package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.comparable.IntegerComparable;
import racingcar.comparable.NumberComparable;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;
import racingcar.random.RandomIntegerGenerator;
import racingcar.random.RandomNumberGenerator;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;

public class Application {

    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";

    public static void main(String[] args) {
        List<String> names = readNames();
        List<Car> cars = new ArrayList<>(names.size());
        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        initialize(names, cars, movingStrategy);
        long attempt = readAttempt();

        printResult(cars, attempt);

        long maxPosition = getMaxPosition(cars);
        String winners = getWinners(cars, maxPosition);
        System.out.println("최종 우승자 : " + winners);
    }

    private static String repeatHyphen(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count is negative: " + count);
        }
        if (count == 1) {
            return HYPHEN;
        }
        StringBuilder repeatedValue = new StringBuilder();
        for (long i = 0; i < count; i++) {
            repeatedValue.append(HYPHEN);
        }
        return repeatedValue.toString();
    }

    private static List<String> readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        validateInputNames(inputNames);

        List<String> names = new ArrayList<>();
        for (String name : inputNames.split(COMMA)) {
            validateName(names, name);
            names.add(name);
        }
        return names;
    }

    private static void validateInputNames(final String value) {
        if (value.endsWith(COMMA)) {
            throw new InvalidNameException("이름은 비어있을 수 없습니다.");
        }
    }

    private static void validateName(final List<String> names, final String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidNameException("이름은 null이거나 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new InvalidNameException("이름은 5글자 이하여야 합니다.");
        }
        if (names.contains(name)) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private static void initialize(final List<String> names, final List<Car> cars,
                                   final MovingStrategy movingStrategy) {
        for (String name : names) {
            cars.add(new Car(name, movingStrategy));
        }
    }

    private static long readAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = Console.readLine();
        validateInputAttempt(inputAttempt);

        long attempt = Long.parseLong(inputAttempt);
        validateAttempt(attempt);
        return attempt;
    }

    private static void validateInputAttempt(final String inputAttempt) {
        if (inputAttempt == null || inputAttempt.isBlank()) {
            throw new InvalidAttemptException("시도 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private static void validateAttempt(final long attempt) {
        if (attempt < 0) {
            throw new InvalidAttemptException("시도 횟수는 양수여야 합니다.");
        }
    }

    private static void printResult(final List<Car> cars, final long attempt) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + repeatHyphen(car.getPosition()));
            }
            System.out.println();
        }
    }

    private static Long getMaxPosition(final List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Long::compare)
                .get();
    }

    private static String getWinners(final List<Car> cars, final long maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
