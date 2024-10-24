package racingcar.vehicle;

public class Car {
    private String name;
    private int cnt;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        cnt = 0;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public void run(int randomNum) {
        if (randomNum < 4) {
            System.out.println(toString());
            return;
        }
        cnt++;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + " : " + printCnt();
    }

    public String printCnt() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
