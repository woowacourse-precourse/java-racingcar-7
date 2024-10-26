package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView input;

    public RacingCarController(InputView input){
        this.input = input;
    }

    public void proceed(){
        String carNames = input.inputCarsName();
        Cars.register(separateName(carNames));
        int tryNumber = Integer.parseInt(input.inputTryNumber());
        for(int i=0;i<tryNumber;i++){
            Cars.moveForward(); // output 하기
        }
    }

    public List<String> separateName(String carNames){
        List<String> nameList = new ArrayList<>();
        nameList.add(Arrays.toString(carNames.split(",")));
        return nameList;
    }
}
