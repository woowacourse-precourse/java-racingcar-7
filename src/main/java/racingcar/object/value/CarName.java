package racingcar.object.value;

public record CarName(String name) implements Comparable<CarName> {

    public CarName {
        if (name == null) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        name = name.strip();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(CarName other) {
        if (other == null) {
            throw new IllegalArgumentException("null과는 비교할 수 없습니다.");
        }
        return name.compareTo(other.name);
    }

}
