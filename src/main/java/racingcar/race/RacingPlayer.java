package racingcar.race;

public interface RacingPlayer<T> extends Player<RacingPlayer<T>> {

    int move();

    int getTotalDistance();

    @Override
    default void play() {
        move();
    }

    @Override
    default int compareTo(RacingPlayer<T> compared) {
        return this.getTotalDistance() - compared.getTotalDistance();
    }

}
