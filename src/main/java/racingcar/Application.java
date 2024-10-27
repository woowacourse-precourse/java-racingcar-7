package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("입력하세요");
        String carNameInput = readLine();
        String[] carNames = carNameInput.split(",");
        Car[] cars = createCars(carNames);

        int count = Integer.parseInt(readLine());
    }

    public static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        validateCarNames(carNames); // 자동차 이름 유효성 검사
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
