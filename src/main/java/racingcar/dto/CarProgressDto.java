package racingcar.dto;

public class CarProgressDto {
    private final String name;
    private final int position;

    private CarProgressDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarProgressDto of(String name, int position) {
        return new CarProgressDto(name, position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}