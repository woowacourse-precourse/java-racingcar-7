package racingcar.view;

import racingcar.constants.RacingConstant;
import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CAR_MOVE_NUMBER = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_AND_LOCATION = "%s : %s\n";
    private static final String CAR_WINNER = "최종 우승자 : %s\n";

    public void startRacing(){
        System.out.println(INPUT_CAR_NAMES);
    }

    public void moveNumber(){
        System.out.println(INPUT_CAR_MOVE_NUMBER);
    }

    public void printCarsInfo(List<CarDto> carDtoList){
        for(CarDto carDto : carDtoList){
            String location = convertLocation(carDto.getPosition());
            System.out.printf(CAR_NAME_AND_LOCATION, carDto.getName(), location);
        }
        System.out.println();
    }

    public String convertLocation(int location) {
        return RacingConstant.CAR_MOVE_CHARACTER.repeat(location);
    }

    public void printWinner(List<String> winner){
        System.out.printf(CAR_WINNER, String.join(", ", winner));
    }

}
