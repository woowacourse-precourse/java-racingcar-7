package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 이상입니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name)
                .append(" : ")
                .append("-".repeat(position)).toString();
    }

    @Override
    public int compareTo(Car o) {
        return o.position - position;
    }

    public int getPosition() {
        return position;
    }
}
