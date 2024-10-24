package racingcar;

import java.util.List;

public class Controller {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private final CarArgumentResolver carArgumentResolver = new CarArgumentResolver();
    private final AttemptCountArgumentResolver attemptCountArgumentResolver = new AttemptCountArgumentResolver();

    private final SizeValidator sizeValidator = new SizeValidator();

    private final CarConverter carConverter = new CarConverter();
    private final AllCarMover allCarMover = new AllCarMover();

    public void run() {
        outputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNamesRequest = inputView.read();

        List<String> carNames = carArgumentResolver.parse(racingCarNamesRequest);
        sizeValidator.isValid(carNames);
        List<Car> cars = carConverter.to(carNames);

        outputView.println("시도할 횟수는 몇 회인가요?");
        String attemptCountRequest = inputView.read();
        int attemptCount = attemptCountArgumentResolver.parse(attemptCountRequest);

        outputView.println("\n실행 결과");
        for (int count = 0; count < attemptCount; count++) {
            allCarMover.run(cars);
            outputView.printCars(cars);
            outputView.endLine();
        }

    }

}
