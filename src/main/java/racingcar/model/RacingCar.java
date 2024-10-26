package racingcar.model;

public class RacingCar {

    private final String name;
    private Integer position;

    public RacingCar(String name){
        this.name = name;
        this.position = 0;
    }

    public Integer move(Integer randomNumber){
        if (randomNumber >= 4){
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }
}
