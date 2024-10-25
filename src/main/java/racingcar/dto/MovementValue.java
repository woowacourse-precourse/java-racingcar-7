package racingcar.dto;

public record MovementValue(Integer value) {

    public static MovementValue from(Integer value) {
        return new MovementValue(value);
    }
}
