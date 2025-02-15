package racingcar.domain;

public record CarName(String name) {
    public CarName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있거나 공백만 포함할 수 없습니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백을 포함할 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        if (!name.matches("[a-zA-Z0-9가-힣-_]+")) {
            throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 대시(-), 밑줄(_) 및 완성된 한글만 가능합니다.");
        }
    }

    public String value() {
        return name;
    }
}

