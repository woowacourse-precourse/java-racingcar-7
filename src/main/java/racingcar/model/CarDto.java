package racingcar.model;

public class CarDto {
    private String name="car";
    private int id = 1;
    private int forward = 0;

    public CarDto() {}

    public CarDto(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public CarDto(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public CarDto(String name, int id, int forward) {
        this.name = name;
        this.id = id;
        this.forward = forward;
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getForward() {
        return forward;
    }
}
