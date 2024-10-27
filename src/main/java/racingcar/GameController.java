package racingcar;

import static racingcar.InputHandler.*;
import static racingcar.OutputHandler.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    protected static final Map<Integer, List<CarDto>> carRacingInfo = new HashMap<>();

    public static void runRacing(){
        OutputHandler.outputStartInfo();
        String carName = inputCarName();
        OutputHandler.outputAskTryValue();
        int tryCountValue = Integer.parseInt(inputTryCount());
        System.out.println();
        System.out.println("실행결과");
        List<String> carNames = BeforeRacing.divideCarName(carName);
        for(int i = 1; i <= tryCountValue; i++){
            List<CarDto> carDtos = createCarDtos(carNames);
            raceResultRecord(i, carDtos);
        }

        String raceResult = AfterRacing.getRaceResult(carRacingInfo);
        outputRacingRecult(raceResult);
        List<String> winner = AfterRacing.getWinner();
        ouputRAcingWinner(winner);

    }

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

    public static void raceResultRecord(int tryCount ,List<CarDto> carDto) {
        carRacingInfo.put(tryCount, carDto);
    }
}
