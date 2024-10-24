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

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4){
            this.position++;
        }
    }
    public String getPositionString(){
        String positionString = this.name + " : ";
        for (int i = 0; i < this.position; i++){
            positionString += "-";
        }
        return positionString;
    }
}







