package racingcar.dto;

public class CarPositionDTO {
    private String name;
    private int position;

    public CarPositionDTO(String name, int position) {
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
