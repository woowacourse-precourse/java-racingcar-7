package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Race;
import racingcar.model.Winner;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private Input input = new Input();
    private CarFactory carFactory = new CarFactory();
    private List<String> carNames;
    private int tryNum;
    private Race race = new Race();
    private Output output = new Output();
    private Winner winner = new Winner();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        carNames = input.getCarNames();
        System.out.println("시도할 회수는 몇 회인가요?");
        tryNum = input.getTryNum();

        List<Car> cars = carFactory.createCarList(carNames);

        //입력받은 tryNum 수만큼 레이스 진행
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNum; i++) {
            cars = race.play(cars);
            output.printRaceResult(cars);
        }
        String winners = winner.getWinners(cars);
        output.printWinners(winners);
    }
}
