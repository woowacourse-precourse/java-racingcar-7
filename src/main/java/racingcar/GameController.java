package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    protected static final Map<Integer, List<CarDto>> carRacingInfo = new HashMap<>();

    public static List<CarDto> createCarDtos(List<String> carNames){
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
