package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Controller {
    private List<String> carNames;
    private int roundCount;
    private Cars cars;
    private Race race;


    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Input.inputCarName();
        System.out.println("시도할 횟수는 몇 회인가요?");
        roundCount = Input.inputRoundCount();
        System.out.println();

        cars = new Cars(carNames);
        race = new Race(roundCount);
        System.out.println("실행 결과");
        while (race.getRoundCount() > 0) {
            race.roundMove(cars);
            Output.printRoundResult(cars);
        }
        Output.printWinner(cars);
    }
}
