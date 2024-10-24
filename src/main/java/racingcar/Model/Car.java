package racingcar.Model;

public class Car {
    public final String name;
    public int ongoingCount;

    public Car(String name) {
        this.name = name;
        ongoingCount = 0;
    }

    public String getName() {
        return name;
    }

    public void ongoing () {
        ongoingCount++;
    }

    public int getOngoingCount() {
        return ongoingCount;
    }

    //VIEW로 코드 옮겨야함
    public void showGameProgress(){
        System.out.println(name+" : "+"-".repeat(ongoingCount));
    }
}