package racingcar.dto;

public record MovementNumber(Integer value) {

    public static MovementNumber from(Integer value) {
        return new MovementNumber(value);
    }
}
