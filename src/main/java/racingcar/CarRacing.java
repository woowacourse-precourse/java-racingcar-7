package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarRacing {
    private static Car[] cars;
    private static int tryCount;

    public static void start() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String carNames = bufferedReader.readLine();

        CarRacing.cars = Arrays.stream(carNames.split(","))
                .peek(CarRacing::validateCarName)
                .map(Car::new)
                .toArray(Car[]::new);

        System.out.println("시도할 횟수는 몇 회인가요?");

        String tryCount = bufferedReader.readLine();
        validateTryCountInput(tryCount);
        CarRacing.tryCount = Integer.parseInt(tryCount);
    }

    private static void validateTryCountInput(String tryCountString) {
        if (!tryCountString.matches("\\d+") || Integer.parseInt(tryCountString) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
