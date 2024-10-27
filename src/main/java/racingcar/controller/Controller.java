package racingcar.controller;

import racingcar.model.Car.Car;
import racingcar.model.Car.move.MoveStrategy;
import racingcar.view.InputView.Input;
import racingcar.view.OutputView.Output;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Input input;
    private Output output;
    private MoveStrategy moveStrategy;
    private List<Car> cars;
    private int RaceNum;

    public Controller(Input input, Output output, MoveStrategy moveStrategy) {
        this.input=input;
        this.output=output;
        this.moveStrategy=moveStrategy;
        cars=new ArrayList<>();
        RaceNum=0;
    }

    //경기장 세팅하기
    public void ready() {
        List<String> carsNames = input.inputCarNames();
        RaceNum = input.inputRaceNum();

        for(int i=0; i<carsNames.size(); i++){
            Car newCar = new Car(carsNames.get(i));
            cars.add(newCar);
        }
    }

    //경기 진행하기
    public void runRace() {
        for(int i=0; i<RaceNum; i++){
            moveStrategy.move(cars);
            output.printRaceResult(cars);
        }
    }

    //경기 결과
    public void RaceResult(){
        output.printWinner(cars);
    }
}
