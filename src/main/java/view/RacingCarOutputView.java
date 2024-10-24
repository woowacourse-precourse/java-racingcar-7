package view;

import dto.RaceOutputDTO;

public class RacingCarOutputView{
    private final RaceOutputDTO raceOutputDTO;
    private static final String OUTPUT_RACING_STATUS = "실행결과";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";

    public RacingCarOutputView(RaceOutputDTO raceOutputDTO) {
        this.raceOutputDTO = raceOutputDTO;
    }

    public void raceResult(){
        System.out.println(OUTPUT_RACING_STATUS);
        System.out.println(raceOutputDTO.raceStatus());
        System.out.println(OUTPUT_WINNER + raceOutputDTO.raceWinner());
    }
}
