package racingcar.model;

public class CarDto {
    private String name;
    private int id;
    private int forward = 0;

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
