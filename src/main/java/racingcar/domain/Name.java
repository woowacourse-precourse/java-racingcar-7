package racingcar.domain;

public record Name(String value) {

    public Name {
        value = nameTrim(value);
        validationNameLength(value);
    }

    private void validationNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private String nameTrim(String value) {
        return value.trim();
    }
    
}
