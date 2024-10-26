package racingcar.domain.random;

import java.util.List;

public class FixedRandomGenerator implements RandomGenerator{
    private final List<Integer> fixRandomValue;
    private int randomValueIndex = 0;

    public FixedRandomGenerator(List<Integer> fixRandomValue) {
        this.fixRandomValue = fixRandomValue;
    }

    @Override
    public int getRandomSingleDigit(){
        if(randomValueIndex>=fixRandomValue.size()) randomValueIndex = 0;
        return fixRandomValue.get(randomValueIndex++);
    }
}
