package racingcar.dto;

import java.util.List;

public class roundResultDTO {
    private List<carRoundResultDTO> carRoundResults;

    public roundResultDTO(List<carRoundResultDTO> carRoundResults){
        this.carRoundResults = carRoundResults;
    }

    public List<carRoundResultDTO> getCarRoundResults(){
        return carRoundResults;
    }
}
