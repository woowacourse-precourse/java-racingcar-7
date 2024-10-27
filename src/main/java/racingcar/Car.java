package racingcar;

class Car {
    String name;
    int currentLocation;

    public Car(String name){
        this.name = name;
        currentLocation = 0;
    }
    public void move(){
        currentLocation++;
    }
}
