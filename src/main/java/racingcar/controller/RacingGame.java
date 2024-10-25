package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int attemptCount;
    public RacingGame(){
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
    public void run(){
        int attemptCount = InputView.getAttemptCount();
    }
}

