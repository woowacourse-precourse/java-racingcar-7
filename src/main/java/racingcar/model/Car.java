package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private String name;
    private int mileage;
    public Car(String name) {
        this.name = name;
        this.mileage = 0;
    }
    public String getName() {
        return name;
    }
    public int getMileage() {
        return mileage;
    }
    public void move(){
        int rand = Randoms.pickNumberInRange(0,9);
        if(rand >= 4){
            mileage++;
        }
    }
}