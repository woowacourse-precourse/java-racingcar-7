package racingcar;

public class Car {
    private final String name;
    private final StringBuilder dist;

    public Car(String name) {
        this.name = name;
        this.dist = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getDist() {
        return dist.toString();
    }

    public void addDist() {
        if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
            dist.append("-");
        }
    }
}
