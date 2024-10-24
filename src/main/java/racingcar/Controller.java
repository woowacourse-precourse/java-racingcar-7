package racingcar;

import java.util.List;

public class Controller {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private final CarArgumentResolver carArgumentResolver = new CarArgumentResolver();
    private final SizeValidator sizeValidator = new SizeValidator();

    private final CarConverter carConverter = new CarConverter();

    public void run() {
        outputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNames = inputView.read();

        List<String> carNames = carArgumentResolver.parse(racingCarNames);
        sizeValidator.isValid(carNames);
        List<Car> cars = carConverter.to(carNames);

        outputView.println("시도할 횟수는 몇 회인가요?");

    }

}
