package racingcar.domain;

public record CarName(String name) {

    public CarName(String name) {
        String trimName = name.trim();
        validateName(name);
        this.name = trimName;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 필수입니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
        }
    }
}
