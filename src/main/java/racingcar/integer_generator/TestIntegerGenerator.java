package racingcar.integer_generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TestIntegerGenerator implements IntegerGenerator {

    private final List<Integer> randomNumberList;
    private final int carCount;
    private int currentIndex;

    public TestIntegerGenerator(int carCount) {
        this.carCount = carCount;
        this.randomNumberList = createRandomNumberList();
        this.currentIndex = 0;
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }

    @Override
    public Integer generate() {
        int lastIndex = randomNumberList.size() - 1;
        if (currentIndex > lastIndex) {
            currentIndex = 0;
        }
        return randomNumberList.get(currentIndex++);
    }

    private List<Integer> createRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            randomNumberList.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumberList;
    }
}
