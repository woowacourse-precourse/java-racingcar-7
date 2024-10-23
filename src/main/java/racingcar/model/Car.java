package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String nameInput){
        this.name = nameInput;
        this.position = 0;
    }

    public void moveFoward(){
        position++;
    }
    public int getPosition(){
        return position;
    }
}
