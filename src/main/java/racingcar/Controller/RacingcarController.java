package racingcar.Controller;

import racingcar.Domain.Car;
import racingcar.Domain.Round;
import racingcar.Dto.RoundResult;
import racingcar.Service.RacingCarService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private final InputView inputView = new InputView();
    private  final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    public void run() {
        // Car 객체만 멤버로 받는 List
        // 타입 안전성을 보장할 수 있다.
        List<Car> cars = inputView.readCarName().stream()
                .map(Car::new)
                .toList();
        // 정적 메서드 참조 : ClassName::staticMethod
        // 인스턴스 메서드 참조 : instance::method
        // 특정 객체의 메서드 참조 : ClassName::instanceMethod (객체 인스턴스 -> 매개변수)
        // 생성자 참조: ClassName::new (객체를 새로 생성할 때)
        Round round = new Round(inputView.readRoundCount());

        List<RoundResult> roundResults = new ArrayList<>();
        while(round.isRemain()){
            RoundResult roundResult = racingCarService.runRound(cars);
            roundResults.add(roundResult);
            round.decreaseCount();
        }
        outputView.printRoundResults(roundResults);
    }
}
