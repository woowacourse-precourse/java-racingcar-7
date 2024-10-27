package racingcar.view;

import java.util.List;
import racingcar.dto.RacingCarInfoDto;

public class OutputView {
    private static final String FINAL_MESSAGE = "최종 우승자 : ";

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printRoundResult(List<RacingCarInfoDto> racingCarPresentInfoList) {

        for(RacingCarInfoDto racingCarPresentInfo: racingCarPresentInfoList){
            System.out.println(racingCarPresentInfo.toString());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners){
        System.out.print(FINAL_MESSAGE);
        System.out.println(String.join(", ", winners));
    }
}
