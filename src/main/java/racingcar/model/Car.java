package racingcar.model;

public class Car {
    private String name;
    private Integer currentMoveCount;

    public Car(String name){
        this.name = name;
        this.currentMoveCount = 0;
    }

    public String getName(){
        return name;
    }

    public Integer getCurrentMoveCount(){
        return currentMoveCount;
    }

    public void setCurrentMoveCount(Integer currentCount){
        this.currentMoveCount = currentCount;
    }
}
