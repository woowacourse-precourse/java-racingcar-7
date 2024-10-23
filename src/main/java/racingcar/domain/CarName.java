package racingcar.domain;

public record CarName(String name) {
    public CarName {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        if (!name.matches("[a-zA-Z0-9-_]+")) { // 영문자, 숫자, 대시(-), 밑줄(_)만 허용
            throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 대시(-), 밑줄(_)만 가능합니다.");
        }
    }

    public String value() {
        return name;
    }
}

