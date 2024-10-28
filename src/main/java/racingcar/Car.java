package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private int position;
    private String name;
    public Car(String name){
        this.position=0;
        this.name=name;
    }

    public Car(String name, int position){
        this.position=position;
        this.name=name;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void move(){
        int random;
        random = pickNumberInRange(0,9);
        if(random>=4) {
            position++;
        }
    }
}
