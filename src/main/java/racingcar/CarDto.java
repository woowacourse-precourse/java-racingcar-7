package racingcar;

public record CarDto(String name, int position) {
    /**
     * Returns a car's information in the format: {@code "[name] : ['-' repeated by position]\n"}
     *
     * @return a string representing a car
     */
    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(position)
                + "\n";
    }
}
