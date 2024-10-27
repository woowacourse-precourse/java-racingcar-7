package racingcar.view.output;


import racingcar.dto.response.RacingResponseDTO;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceResult(RacingResponseDTO racingResponseDTO) {
        System.out.println(OutputResolver.resolveRacingResult(racingResponseDTO));
    }
}
