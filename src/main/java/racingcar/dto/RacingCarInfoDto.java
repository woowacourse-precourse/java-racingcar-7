package racingcar.dto;

public class RacingCarInfoDto {
    private String name;
    private int movedDistance;

    private RacingCarInfoDto(String name, int movedDistance){
        this.name = name;
        this.movedDistance = movedDistance;
    }

    public static RacingCarInfoDto of(String name, int movedDistance){
        return new RacingCarInfoDto(name, movedDistance);
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(movedDistance);
    }



}
