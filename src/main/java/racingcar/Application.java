package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int VALID_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 회수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("실행결과 ");

        for (int i = 0; i < count; i++) {
            String roundProgress = doRacing(input, count);
            System.out.println(roundProgress);
        }

        String winner = getWinner();
        System.out.println("최종 우승자 : " + winner);
    }

    private static String doRacing(String input, int count) {
        String[] cars = input.split(",");
        validateInput(cars);
        return "";
    }

    private static String getWinner() {
        return "";
    }

    private static void validateInput(String[] cars) {
        for (String car : cars) {
            validateCarName(car);
        }

    }

    private static void validateCarName(String car) {
        if (car.length() > VALID_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
