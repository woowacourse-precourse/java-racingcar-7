package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name){
        isOver6OrEmpty(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber){
        if(randomNumber > 3){
            distance++;
        }
    }

    public String getDistanceString(){
        return "-".repeat(distance);
    }

    public void isOver6OrEmpty(String name){
        if (name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
