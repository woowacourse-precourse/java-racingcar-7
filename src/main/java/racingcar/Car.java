package racingcar;

public class Car {
    String name;
    int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for (int k = 0; k < location ; k++) {
            sb.append("-");
        };
        sb.append("\n");

        return sb.toString();
    }
}
