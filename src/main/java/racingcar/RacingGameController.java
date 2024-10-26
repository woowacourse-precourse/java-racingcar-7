package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameController {
    public void start() {
        Car[] cars = inputCars();
        int rounds = inputRounds();
        RacingGame game = new RacingGame(cars, rounds, new RandomMoveStrategy());
        game.start();
    }

    // 사용자로부터 자동차 이름을 입력받고 Car 배열을 생성
    private Car[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i].trim());
        }
        return cars;
    }

    // 시도할 횟수를 입력받고 유효성을 검사하여 반환
    private int inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
