package racingcar.dto;

public class GameStartDTO {
    private String carsInput;
    private String roundInput;

    public GameStartDTO(String carsInput, String roundInput){
        this.carsInput = carsInput;
        this.roundInput = roundInput;
    }

    public String getCarsInput(){
        return carsInput;
    }

    public String getRoundInput(){
        return roundInput;
    }
}
