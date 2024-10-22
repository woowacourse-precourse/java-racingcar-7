package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarRacing {
    private static Car[] cars;

    public static void start() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String carNames = bufferedReader.readLine();

        CarRacing.cars = Arrays.stream(carNames.split(","))
                .peek(CarRacing::validateCarName)
                .map(Car::new)
                .toArray(Car[]::new);
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
