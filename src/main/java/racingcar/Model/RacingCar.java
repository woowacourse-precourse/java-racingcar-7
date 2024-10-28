package racingcar.Model;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    String name;
    int score;

    public RacingCar(int score, String name) {
        validateName(name);
        this.score = score;
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(RacingCar o) {
        return this.score - o.score;
    }
}
