package racingcar.model.random;

// 테스트를 위한 고정 숫자 반환기
public class FixedNumberGenerator implements NumberGenerator{
    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
