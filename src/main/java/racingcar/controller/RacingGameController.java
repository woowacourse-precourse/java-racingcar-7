package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

import java.util.List;

// 경주 게임의 주제어를 담당하는 클래스
public class RacingGameController {
    private final CarInputHandler carInputHandler; // 자동차 이름 입력 처리기
    private final TrialCountInputHandler trialCountInputHandler; // 시도 횟수 입력 처리기
    private final GameRunner gameRunner; // 게임 실행기

    // 생성자: 입력 처리기와 게임 실행기를 초기화
    public RacingGameController() {
        OutputView outputView = new OutputView(); // 출력 뷰 객체 생성
        this.carInputHandler = new CarInputHandler(); // 자동차 이름 입력 처리기 초기화
        this.trialCountInputHandler = new TrialCountInputHandler(); // 시도 횟수 입력 처리기 초기화
        this.gameRunner = new GameRunner(outputView); // 게임 실행기 초기화
    }

    // 게임 시작 메서드
    public void start() {
        List<Car> cars = carInputHandler.getCarNames(); // 자동차 이름 입력 받기
        int trialCount = trialCountInputHandler.getTrialCount(); // 시도 횟수 입력 받기
        RacingGame racingGame = new RacingGame(cars, trialCount); // 경주 게임 객체 생성

        gameRunner.run(racingGame); // 게임 실행
    }
}
