package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.Car;

public class InputView {
    public static List<Car> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateEmptyOrZeroString(carNames);

        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        for (String inputname : splitNames) {
            inputname = inputname.trim();
            validateNameFormat(inputname);
            validateNameLength(inputname);
            Car car = new Car(inputname);
            cars.add(car);
        }
        return cars;
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        validateEmptyOrZeroString(tryCount);
        validateNotNumber(tryCount);

        int inputTryCount = Integer.parseInt(tryCount);
        return inputTryCount;
    }

    private static void validateNotNumber(String tryCount) {
        String rex = "[\\D]*";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(tryCount);

        if (matcher.find()) {
            throw new IllegalArgumentException("시도횟수는 양수만 입력할 수 있습니다.");
        }
    }

    private static void validateEmptyOrZeroString(String inputString) {
        if (inputString.isBlank() || inputString =="0") {
            throw new IllegalArgumentException("0또는 빈 값을 입력하셨습니다");
        }
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
