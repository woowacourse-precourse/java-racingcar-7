package racingcar.controller;

import net.bytebuddy.asm.Advice;
import racingcar.model.Car;
import racingcar.model.ExceptionClass;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionClass exceptionClass;
    public RacingController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.exceptionClass = ExceptionClass.getInstance();
    }

    public void process(){
        //자동차 이름 입력
        String[] vehicleNames = inputView.getVehicleName();
        List<Car> carList = new ArrayList<>();

        exceptionClass.validateString(vehicleNames);

        //유효한 경우 정상 진행
        for(String vehicleName : vehicleNames){
            //자동차 이름으로 추가
            carList.add(new Car(vehicleName));
        }

        int moveCnt = inputView.getMoveCount();

        System.out.println("실행 결과");
        for(int i = 0; i<moveCnt; i++){
            for(Car car : carList){
                //자동차 이동
                car.move();
            }
            //중간 결과 출력
            outputView.printInterimResult(carList);
        }
        outputView.printResult(carList);
    }
}
