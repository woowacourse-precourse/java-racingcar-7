package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int position;
    Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move(){
        if(this.randomNumber() >= 4){
            this.position++;
        }
    }

    public String printPositionString(){
        String positionString = this.name + " : ";
        for (int i = 0; i < this.position; i++){
            positionString += "-";
        }
        return positionString + "\n";
    }
}
