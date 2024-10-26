package racingcar.mock.service.dependency.random_maker;

import racingcar.service.dependency.random_maker.RandomNumberMaker;

import java.util.List;

/**
 * RandomNumberMaker 의 Mock 클래스
 * <p>
 * 랜덤 숫자를 정해진 순서대로 반환한다.
 */
public class MockedRandomNumberMaker implements RandomNumberMaker {

    private final List<Integer> numbers;
    private int index = 0;

    public MockedRandomNumberMaker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int makeRandomNumber() {
        return numbers.get(index++);
    }
}
