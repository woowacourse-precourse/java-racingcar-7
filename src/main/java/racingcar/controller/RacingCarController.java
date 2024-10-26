package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView input;
    private final OutputView output;

    public RacingCarController(InputView input, OutputView output){
        this.input = input;
        this.output = output;
    }

    public void proceed(){
        String carNames = input.inputCarsName();
        Cars.register(separateName(carNames));
        int tryNumber = Integer.parseInt(input.inputTryNumber());
        for(int i=0;i<tryNumber;i++){
            output.printResult(Cars.moveForward());
        }
        //winner 찾아서 출력
    }

    public List<String> separateName(String carNames){
        List<String> nameList = new ArrayList<>();
        nameList.add(Arrays.toString(carNames.split(",")));
        return nameList;
    }
}
