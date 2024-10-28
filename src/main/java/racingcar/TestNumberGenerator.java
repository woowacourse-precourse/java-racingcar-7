package racingcar;

public class TestNumberGenerator implements RandomGenerator{

    private int number;

    public TestNumberGenerator(int number){
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}
