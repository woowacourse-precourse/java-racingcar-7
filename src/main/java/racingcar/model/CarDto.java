package racingcar.model;

public class CarDto {
    private String name;
    private int id;
    private int position = 0;

    public CarDto(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    public int getPosition() {
        return position;
    }
}
