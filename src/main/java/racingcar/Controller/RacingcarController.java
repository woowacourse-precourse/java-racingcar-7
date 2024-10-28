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
        // 1. 입력 받은 경주에 참가한 Car 객체를 리스트에 넣는다.

        // Car 객체만 멤버로 받는 List
        // 타입 안전성을 보장할 수 있다.
        List<Car> cars = inputView.readCarName().stream()
                .map(Car::new)
                .toList();
        // 정적 메서드 참조 : ClassName::staticMethod
        // 인스턴스 메서드 참조 : instance::method
        // 특정 객체의 메서드 참조 : ClassName::instanceMethod (객체 인스턴스 -> 매개변수)
        // 생성자 참조: ClassName::new (객체를 새로 생성할 때)

        // 2. 입력 받은 경주에 정해진 Round를 변수에 넣고 시작 한다.
        Round round = new Round(inputView.readRoundCount());

        // 3. 게임 시작
        List<RoundResult> roundResults = new ArrayList<>();
        while(round.isRemain()){
            RoundResult roundResult = racingCarService.runRound(cars);
            roundResults.add(roundResult);
            round.decreaseCount();
        }
        // 4. 결과 출력
        List <String> winners = racingCarService.pickOutWinners(cars);
        outputView.printRoundResults(roundResults);
        outputView.printWinners(winners);
    }

}
