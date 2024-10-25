package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final List<Car> cars = new ArrayList<>();
    private int tryNumber;

    // 컨트롤러 실행
    public void run() {
        inputInfo();
        startRace();
    }

    // 입력 기능
    public void inputInfo(){
        String input = InputView.inputCarNames();
        tryNumber = Integer.parseInt(InputView.inputTryNumber());
        String[] carArr = Utils.splitDelimiterCars(input);

        for(String name : carArr){
            cars.add(new Car(name));
        }
    }

    // 경주 시작
    public void startRace(){
        while(tryNumber > 0){
            advanceCar();
            runResult(cars);
            tryNumber--;
        }
    }

    // 차량 전진
    public void advanceCar(){
        for(Car car : cars){
            moveCarAllowed(car);
        }
    }

    // 전진 조건 만족하는 지 검사
    public void moveCarAllowed(Car car){
        if(Utils.advanceConditions()){
            car.move();
        }
    }
    public void runResult(List<Car> cars){
        OutputView.printRunResult(cars);
    }
}
