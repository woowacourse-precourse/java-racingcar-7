package racingcar;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void print() {
        System.out.println(getCarName() + " : " + getDistanceAsDash());
    }

    private String getDistanceAsDash(){
        StringBuilder dash = new StringBuilder();
        for(int i = 0; i<distance; i++){
            dash.append("-");
        }
        return dash.toString();
    }


}
