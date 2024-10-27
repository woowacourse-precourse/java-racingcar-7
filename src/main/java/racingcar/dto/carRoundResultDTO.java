package racingcar.dto;

public class carRoundResultDTO {
    private String carName;
    private Integer currentCount;

    public carRoundResultDTO(String carName, Integer currentCount){
        this.carName = carName;
        this.currentCount = currentCount;
    }

    public String getCarName(){
        return  carName;
    }

    public Integer getCurrentCount(){
        return currentCount;
    }
}
