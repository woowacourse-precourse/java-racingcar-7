package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CarNameHandler carNameHandler = new CarNameHandler();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String movement = Console.readLine();

        // 차 이름 저장
        RacingCars carData = carNameHandler.storeCar(carNamesInput);

        RacingGame racingGame = new RacingGame(carData);
        racingGame.startRacing(Integer.parseInt(movement));

        carNameHandler.printWinCarNames(carData);
    }
}
