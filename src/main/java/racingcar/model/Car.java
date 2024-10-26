package racingcar.model;

public class Car {

    private String name;

    private int count;

    public Car(final String name){
        this.name = name;
        this.count = 0;
    }

    public void plusCount(){
        this.count++;
    }

    public String getName(){
        return this.name;
    }

    public int getCount(){
        return this.count;
    }

}
