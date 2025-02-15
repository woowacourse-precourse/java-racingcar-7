package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.InputProcessor;
import racingcar.service.CarRacing;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Car> cars = new ArrayList<>();
        InputProcessor inputProcessor = new InputProcessor();
        CarRacing carRacing = new CarRacing();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRound = Console.readLine();

        inputProcessor.isValidRound(inputRound);

        int round = Integer.parseInt(inputRound);

        // 입력 값에서 자동차 이름을 분리하고 각 자동차를 객체로 만든다.
        List<String> carNames = inputProcessor.parseCarNames(input);
        for (String carName : carNames) {
            Car car = new Car();
            car.setName(carName);
            cars.add(car);
        }

        // 자동차 경주
        for (int i = 0; i < round; i++) {
            carRacing.raceOneTurn(cars);
        }

        carRacing.printRoundResult(cars);

        List<Car> winners =  carRacing.findWinners(cars);

        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
