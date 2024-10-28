package racingcar;

import java.util.List;
import racingcar.argumentresolver.ArgumentResolver;
import racingcar.validator.Validator;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;

    private final ArgumentResolver<List<String>> carArgumentResolver;
    private final ArgumentResolver<Integer> attemptCountArgumentResolver;

    private final Validator<List<String>> sizeValidator;
    private final Validator<Integer> rangeValidator;

    private final AllCarMover allCarMover;

    private final WinnersDecider winnersDecider;

    public Controller(
            OutputView outputView,
            InputView inputView,
            ArgumentResolver<List<String>> carArgumentResolver,
            ArgumentResolver<Integer> attemptCountArgumentResolver,
            Validator<List<String>> sizeValidator,
            Validator<Integer> rangeValidator,
            AllCarMover allCarMover,
            WinnersDecider winnersDecider
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.carArgumentResolver = carArgumentResolver;
        this.attemptCountArgumentResolver = attemptCountArgumentResolver;
        this.sizeValidator = sizeValidator;
        this.rangeValidator = rangeValidator;
        this.allCarMover = allCarMover;
        this.winnersDecider = winnersDecider;
    }

    public void run() {
        outputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNamesRequest = inputView.read();

        List<String> carNames = carArgumentResolver.parse(racingCarNamesRequest);
        sizeValidator.check(carNames);
        List<Car> cars = CarConverter.toCars(carNames);

        outputView.println("시도할 횟수는 몇 회인가요?");
        String attemptCountRequest = inputView.read();
        int attemptCount = attemptCountArgumentResolver.parse(attemptCountRequest);
        rangeValidator.check(attemptCount);

        outputView.endLine();
        outputView.println("실행 결과");
        for (int count = 0; count < attemptCount; count++) {
            allCarMover.run(cars);
            outputView.printCarsStatus(cars);
            outputView.endLine();
        }

        outputView.print("최종 우승자 : ");
        List<Car> winners = winnersDecider.run(cars);
        List<String> winnerNames = CarConverter.toNames(winners);
        outputView.printNames(winnerNames);
    }

}
