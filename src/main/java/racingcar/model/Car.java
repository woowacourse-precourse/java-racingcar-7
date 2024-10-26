package racingcar.model;

public class Car {
    static int INITPOSITION=0;
    String name;
    int position;

    public Car(String name){
        this.name=name;
        this.position=INITPOSITION;
    }

    public void settingPosition(int position){
        this.position =position;
    }
}
