package racingcar.domain;

public class Car {
    private String name;
    private int state;
    public Car(String name){
        this.name = name;
    }

    public Car(String name,int state){
        this.name = name;
        this.state = state;
    }

    public String getName(){
        return name;
    }

    public int getState(){
        return state;
    }

    public void move(int number){
        if(number>=4){
            state++;
        }
    }

}
