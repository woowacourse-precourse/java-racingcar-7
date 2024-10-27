package racingcar;

class Car {
    private String name;
    private int currentLocation;

    public Car(String name){
        this.name = name;
        currentLocation = 0;
    }

    public void move(){
        currentLocation++;
    }

    public void rename(String newName){
        name = newName;
    }

    public String name(){
        return name;
    }

    public int currentLocation(){
        return currentLocation;
    }
}
