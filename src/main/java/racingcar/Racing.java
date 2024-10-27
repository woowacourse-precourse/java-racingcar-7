package racingcar;

import java.util.List;
import racingcar.Input.InputHandler;

public class Racing {

    private final InputHandler inputHandler;

    public Racing(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = inputHandler.inputCarNameList();

        String[] carNameList = input.split(",", -1);

        Cars cars = new Cars();

        cars.addCar(carNameList);

        int roundNumber = 0;
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            roundNumber = inputHandler.inputRoundNumber();

            if (roundNumber < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < roundNumber; i++) {

            cars.moveForward();

            cars.printRacingProgress();
        }

        List<Car> winners = cars.getWinners();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
