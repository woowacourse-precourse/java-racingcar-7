package racingcar.dto;

public record UserInput(String cars,
                        String rounds) {

    public static UserInput of(String cars, String rounds) {
        return new UserInput(cars, rounds);
    }
}
