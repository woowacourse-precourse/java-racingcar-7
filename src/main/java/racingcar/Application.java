package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        run();

    }

    private static void run() {

        inputCars();

    }

    private static void inputCars() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        String[] inputs = carsInput.split(",");

    }

    private static void print(String message) {
        System.out.println(message);
    }
}
