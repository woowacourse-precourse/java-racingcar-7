package racingcar.controller.handler;

import racingcar.dto.RaceResultDTO;

public class ConsoleOutputHandler {

    public void displayResult(RaceResultDTO raceResultDTO) {
        System.out.println(raceResultDTO.convertWinnersToString());
    }
}
