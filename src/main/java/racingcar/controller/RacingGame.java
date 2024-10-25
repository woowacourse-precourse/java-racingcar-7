package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int attemptCount;
    private RacingService racingService;
    public RacingGame(){
        this.racingService = new RacingService();
        initialize();
    }

    //게임 시작시 필요한 초기 설정 수행
    private void initialize(){
        String[] carNames = InputView.getCarNames();
        this.attemptCount = InputView.getAttemptCount();
        this.cars = new ArrayList<>();
        for(String name : carNames){
            cars.add(new Car(name.trim()));
        }
    }

    //게임 시작
    public void start(){
        for(int i =0; i<attemptCount; i++){
            runRoundAndPrintResults();

        }
    }
    // 라운드를 진행하고 결과를 출력하는 메서드
    private void runRoundAndPrintResults() {
        playRound();
//        OutputView.printRaceStatus(cars);  // 라운드 결과 출력
    }

    //라운드 진행
    private void playRound(){
        racingService.moveCars(cars);
    }
}

