package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        printWinner();
    }
    // 라운드를 진행하고 결과를 출력하는 메서드
    private void runRoundAndPrintResults() {
        playRound();
        OutputView.printRaceStatus(cars);  // 라운드 결과 출력
    }

    //라운드 진행
    private void playRound(){
        racingService.moveCars(cars);
    }

    //최종 우승자 출력
    private void printWinner(){
        List<String> winners = getWinners();
        OutputView.printWinners(winners);
    }

    //우승자 목록 반환하는 메서드
    private List<String> getWinners(){
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

