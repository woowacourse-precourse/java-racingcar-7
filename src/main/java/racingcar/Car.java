package racingcar;

public class Car {
    String name;
    int randomNum;

    public Car(String name, int randomNum) {
        this.name = name;
        this.randomNum = randomNum;
    }

    public String getName() {
        return name;
    }
    public int getRandomNum() {
        return randomNum;
    }

    public void occurRandomNum(){
        this.randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0,9);
    }
}
