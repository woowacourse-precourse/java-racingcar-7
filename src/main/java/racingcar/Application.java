package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;

public class Application {

    public static final String COMMA = ",";

    public static void main(String[] args) {
        List<String> names = readNames();
        List<Car> cars = new ArrayList<>(names.size());
        for (String name : names) {
            cars.add(new Car(name));
        }
        long attempt = readAttempt();
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
}
