package racingcar.service;

import racingcar.config.GameConfig;
import racingcar.domain.Car;
import racingcar.util.GameUtil;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarService {

    private final InputView inputView;
    private final OutputView outputView;

    public CarService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 자동차 이름과 시도 횟수를 입력하는 메서드
     */
    public GameConfig initializeGame() {
        String inputCarName = inputView.inputCarName();

        List<String> carNames = GameUtil.prepareCarNames(inputCarName);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        int attemptCount = inputView.getAttemptCount();
        return new GameConfig(cars, attemptCount);
    }

    /**
     * 시도 횟수 만큼 랜덤숫자를 추출해 자동차를 움직이는 메서드
     * @param cars 경주하는 자동차들
     * @param count 시도 횟수
     */
    public void startRace(List<Car> cars, int count) {
        outputView.racingResult();

        for (int i = 0; i < count; i++) {
            cars.forEach(car -> car.move(RandomNumberGenerator.move()));
            outputView.racingView(cars);
        }
    }

    /**
     * 가장 많이 이동한 자동차들을 계산해서 출력 명령을 보내는 메서드
     * @param cars 경주하는 자동차들
     */
    public void showResults(List<Car> cars){
        List<String> winnerCarList = GameUtil.calculateWinners(cars);
        outputView.resultView(winnerCarList);
    }

}
