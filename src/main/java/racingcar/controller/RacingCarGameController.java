package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.CarFactory;
import racingcar.model.car.CarNameParser;
import racingcar.model.util.Parser;
import racingcar.model.simulator.RacingCarGameSimulator;
import racingcar.model.simulator.SimulationResult;
import racingcar.model.util.Simulator;
import racingcar.view.ApplicationInputView;
import racingcar.view.ApplicationOutputView;

import java.util.List;

public class RacingCarGameController {
    public void run() {
        ApplicationOutputView.outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(, ) 기준으로 구분)");
        String givenInput = ApplicationInputView.input();
        List<String> carNames = Parser.select(CarNameParser.class).parse(givenInput);
        List<Car> cars = CarFactory.createCars(carNames);

        ApplicationOutputView.outputLine("시도할 횟수는 몇 회인가요?");
        int trial = ApplicationInputView.getInt();

        ApplicationOutputView.outputLine("실행 결과");
        Simulator<List<Car>,String> simulator = new RacingCarGameSimulator();

        SimulationResult<String> simulationResult = simulator.simulate(cars, trial);
        simulationResult.getResult().forEach(ApplicationOutputView::outputLine);
    }
}
