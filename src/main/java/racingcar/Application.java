package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing();
        String input = inputCarNames();
        racing.setupCars(input);

        int attempts = inputAttempts();

        System.out.println("실행 결과");
        startRace(racing, attempts);

        System.out.println("최종 우승자 : " + racing.getWinners());
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Validator.parseAttempts(Console.readLine());
        Validator.checkAttempts(attempts);
        return attempts;
    }

    private static void startRace(Racing racing, int attempts) {
        for (int i = 0; i < attempts; i++) {
            racing.performRaceRound();
            displayRoundResult(racing);
        }
    }

    private static void displayRoundResult(Racing racing) {
        for (Car car : racing.getCars()) {
            System.out.println(car.getName() + " : " + car.showPosition());
        }
        System.out.println();
    }
}
