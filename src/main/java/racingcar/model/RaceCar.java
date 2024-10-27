package racingcar.model;

import racingcar.validator.RaceCarValidator;

class RaceCar {
    private static final int MOVE_THRESHOLD = 4;
    private static final int INIT_POSITION = 0;

    private final String name;
    private int position;

    private RaceCar(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static RaceCar fromName(String name) {
        String trimmedName = trimName(name);
        RaceCarValidator.validate(trimmedName);
        return new RaceCar(trimmedName, INIT_POSITION);
    }

    public void move() {
        position++;
    }

    public boolean isWinner(int winPosition) {
        return this.position == winPosition;
    }

    public boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    private static String trimName(String name) {
        return name.trim();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
