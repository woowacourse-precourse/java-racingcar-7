package racingcar.dto;

public class CarStatusDto {

    private final String name;
    private final int position;

    public CarStatusDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
