package racingcar.model;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;
// Race의 전반적인 흐름을 관리하는 RaceManager 입니다.
public class RaceManager {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RaceManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // Race의 전체작인 흐름을 담담하는 메서드
    public void run() {
        prepareRace();
        startRace();
        showWinner();
    }

    // Race를 준비하는 메서드입니다, 입력받은 이름들로 자동차를 생성하고 시도 횟수를 생성하여 이를 이용해 Race를 생성합니다.
    private void prepareRace() {
        Cars cars = Cars.from(inputView.inputCarNames());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());
        race = new Race(cars, tryCount);
    }
    // Race가 시작되면 각 라운드를 시도 횟수만큼 반복해서 진행하고 결과를 출력하게하는 메서드
    // 아래 메서드에서 각 라운드를 진행하고 바로 결과를 출력하는데 이런 상황이면 해당 메서드가 2가지 일을 한다고 봐야할까?
    // 아니면 개념적으로 Race를 시작하서 진행되는 과정이기 때문에 하나의 일은 한다고 봐야할까? 고민중...
    private void startRace() {
        outputView.printRoundHeader();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.round();
            outputView.printRoundResult(displayRoundResult());
        }
    }
    // Race의 Round가 모두 끝나면 우승자를 보여줍니다.
    private void showWinner() {
        Winners winners = race.createWinner();
        String result = displayWinners(winners.getWinners());
        outputView.printWinners(result);
    }
    // 각 차의 상태에 따라서 라운드별 결과 display를 만들어주는 메서드
    private String displayRoundResult() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Car> cars = race.getPlayers();

        cars.forEach(car -> {
            stringBuilder.append(car.getCarName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, car.getCurrentLocation())));
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    // 최종 우승자의 display를 만들어주는 메서드
    private String displayWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getCarName());
            if (i < winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.toString();
    }
}
