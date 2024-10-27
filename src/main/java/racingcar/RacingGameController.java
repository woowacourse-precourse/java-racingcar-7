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

        // 유효성 검사 추가: 쉼표 이외의 문자로 구분되어 있는지 검사
        if (!input.matches("^[a-zA-Z]+(,[a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로만 구분되어야 합니다.");
        }

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
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
