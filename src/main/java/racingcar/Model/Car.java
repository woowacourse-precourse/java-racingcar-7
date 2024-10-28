package racingcar.Model;

public class Car {
    private static final String movement="-";
    private String position="";
    private String carName;

    public Car(String carName){
        this.carName=carName;
    }
    public void setPosition(){
        this.position+=movement;
    }
    public String getPosition(){return position;}
    public String getCarName(){return carName;}

}
