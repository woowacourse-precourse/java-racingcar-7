package racingcar.model;

class TestCar extends Car {
    private int randomNumber = 0;

    public TestCar(String name) {
        super(name);
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    protected int getRandomNumber() {
        return randomNumber;
    }
}
