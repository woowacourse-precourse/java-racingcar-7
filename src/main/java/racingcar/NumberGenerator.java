package racingcar;

public interface NumberGenerator {
    default int generateNumber(int num) {
        return generate(num);
    }

    int generate(int num);
}
