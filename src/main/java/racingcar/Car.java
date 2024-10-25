package racingcar;

public class Car {
    String name;
    int randomNum;
    int countAdvance;

    public Car(String name, int randomNum, int countAdvance) {
        this.name = name;
        this.randomNum = randomNum;
        this.countAdvance = countAdvance;
    }

    public String getName() { return name; }
    public int getRandomNum() {
        return randomNum;
    }
    public int getCountAdvance() { return countAdvance; }

    public void occurRandomNum(){
        this.randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0,9);
    }
}
