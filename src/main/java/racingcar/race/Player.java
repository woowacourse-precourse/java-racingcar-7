package racingcar.race;

public interface Player<T> extends Comparable<T> {

    String getPlayerName();

    void play();

    default boolean isLoser(T compared) {
        return this.compareTo(compared) < 0;
    }

}
