package racingcar.model;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class Car {
    private String name;
    private int distance;
    public Car(String name){
        this.name = name;
    }

    public Car(String name,int distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public void moveOrStop(){
        if(pickNumberInRange(0,9)<=4){
            distance++;
        }
    }

}
