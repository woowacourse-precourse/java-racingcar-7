package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int distance;
    public Car (String name){
        this.name = name;
    }
    public boolean judge (int random){
        if(random >= 4){
            return true;
        }
        return false;
    };

    public int random (){
        return Randoms.pickNumberInRange(0, 9);
    };
}
