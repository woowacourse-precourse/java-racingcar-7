package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void moveCar(int randomNumber){
        if (randomNumber > 3) {
            position ++;
        }
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
