package racingcar.model;

public class Car {

    private String name;

    private int score;

    public Car(final String name){
        this.name = name;
        this.score = 0;
    }

    public void plusCount(){
        this.score++;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

}
