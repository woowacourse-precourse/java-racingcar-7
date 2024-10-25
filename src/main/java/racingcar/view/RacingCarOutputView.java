package racingcar.view;

import racingcar.dto.RacingOutputDTO;

public class RacingCarOutputView{
    private final RacingOutputDTO racingOutputDTO;
    private static final String OUTPUT_RACING_STATUS = "실행결과";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";

    public RacingCarOutputView(RacingOutputDTO racingOutputDTO) {
        this.racingOutputDTO = racingOutputDTO;
    }

    public void printRacingResult(){
        System.out.println(OUTPUT_RACING_STATUS);
        System.out.println("\n");
        System.out.println(racingOutputDTO.raceStatus());
        System.out.println(OUTPUT_WINNER + racingOutputDTO.raceWinner());
    }
}
