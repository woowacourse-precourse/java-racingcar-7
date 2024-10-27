package racingcar.model;

public class Car {
    private String name;
    private Integer currentCount;

    public Car(String name){
        this.name = name;
        this.currentCount = 0;
    }

    public String getName(){
        return name;
    }

    public Integer getCurrentCount(){
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount){
        this.currentCount = currentCount;
    }
}
