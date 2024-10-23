package racingcar.domain;

public record CarName(String name) {
    public CarName {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public String value() {
        return name;
    }
}

