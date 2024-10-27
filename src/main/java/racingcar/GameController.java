package racingcar;

import static racingcar.InputHandler.inputCarName;
import static racingcar.InputHandler.inputTryCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    public static final Map<Integer, List<CarDto>> carRacingInfo = new HashMap<>();

    public static List<CarDto> startRacing(List<String> carNames){
        List<CarDto> carInfoList = new ArrayList<>();

        for (String carName : carNames) {
            CarDto carDto = getCarDto(carName);
            carInfoList.add(carDto);
        }
        return carInfoList;
    }

    public static CarDto getCarDto(String  carName){
        int moveValue = DuringRacing.getMoveValue();
        boolean move = DuringRacing.move(moveValue);
        return new CarDto(carName, move);
    }

}
