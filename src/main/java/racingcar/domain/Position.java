package racingcar.domain;

public class Position {

    private String value;

    public Position() {
        this.value = "";
    }

    public void add(int distance) {
        for (int i = 0; i < distance; i++) {
            this.value += "-";
        }
    }

    @Override
    public String toString() {
        return this.value;
    }

    public boolean isMoreFar(Position position) {
        return this.value.length() > position.value.length();
    }

    public boolean isSame(Position position) {
        return this.value.length() == position.value.length();
    }
}
