package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.CarsInRace;
import racingcar.domain.NameParser;
import racingcar.validation.RaceCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {


    public void run() {

        // 자동차 이름 입력
        String inputCarNames = InputView.readCarNames();
        NameParser nameParser = new NameParser(inputCarNames);
        List<String> nameList = nameParser.parse();

        // 시도할 횟수 입력
        int inputRaceCount = InputView.readRaceCount();
        RaceCountValidator.isPositiveNumber(inputRaceCount);

        // 자동차 객체 생성
        CarFactory carFactory = new CarFactory(nameList);
        List<Car> newCars = carFactory.operateCarFactory();
        CarsInRace carsInRace = new CarsInRace(newCars);

        // 경기 시작
        OutputView.showRaceStart();
        for (int count = 0; count < inputRaceCount; count++) {
            carsInRace.startRaceOnce();
            carsInRace.getCarsInRace()
                    .forEach(car -> OutputView.showRaceResult(car.getName(), car.getWinCount()));
            OutputView.showNewLine();
        }

        // 우승자 출력
        OutputView.showWinner(carsInRace.getWinnersName());
    }
}
