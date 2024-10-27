package racingcar.View;

import java.util.HashMap;
import racingcar.DTO.RaceFinalWinnerDTO;
import racingcar.DTO.RaceResultDTO;
import racingcar.Util.Message.IOMessage;

public class OutputView {
    HashMap<String, Integer> carList;

    public void printRaceResult() {
        System.out.println(IOMessage.RACING_RESULT.getMessage());
    }

    public void displayRaceProgress(RaceResultDTO raceResultDTO) {
        carList = raceResultDTO.getCarList();

        for (String car : carList.keySet()) {
            String position = convertPositionToDashes(carList.get(car));
            System.out.println(car + IOMessage.SEPARATOR.getMessage() + position);
        }
        System.out.print(IOMessage.NEW_LINE.getMessage());
    }

    public String convertPositionToDashes(Integer currentPosition) {
        StringBuilder raceBar = new StringBuilder();

        while(currentPosition > 0) {
            raceBar.append("-");
            currentPosition--;
        }

        return raceBar.toString();
    }

    public void printFinalWinners(RaceFinalWinnerDTO raceFinalWinnerDTO) {
        String finalWinners = String.join(", ", raceFinalWinnerDTO.getFinalWinner());
        System.out.print(IOMessage.RESULT_MESSAGE.getMessage() + finalWinners);
    }
}
