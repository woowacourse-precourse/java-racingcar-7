package racingcar;

public class Car {
    String name;
    int randomNum;
    int countAdvence;

    public Car(String name, int randomNum, int countAdvence) {
        this.name = name;
        this.randomNum = randomNum;
        this.countAdvence = countAdvence;
    }

    public String getName() { return name; }
    public int getRandomNum() {
        return randomNum;
    }
    public int getCountAdvence() { return countAdvence; }

    public void occurRandomNum(){
        this.randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0,9);
    }
}
