package racingcar.model;

public class Car {
    private static int INITPOSITION=0;
    private String name;
    private int position;

    public Car(String name){
        this.name=name;
        this.position=INITPOSITION;
    }

    public void settingPosition(int position){
        this.position =position;
    }

    public int getPosition() {
        return position;
    }
}
