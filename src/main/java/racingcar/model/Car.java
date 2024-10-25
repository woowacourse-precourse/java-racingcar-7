package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String nameInput){
        this.name = nameInput;
        this.position = 0;
    }
    public String getName(){
        return name;
    }

    public void moveForward(){
        position++;
    }
    public int getPosition(){
        return position;
    }
}
