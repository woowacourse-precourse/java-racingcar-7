package racingcar;

public class RacingGameOutPutConsole implements GameResultView {
    private final Cars cars;

    public RacingGameOutPutConsole(Cars cars) {
        this.cars = cars;
    }

    @Override
    public void printRoundResult() {
        StringBuilder result = new StringBuilder();
        result.append("\n실행 결과\n");

        for (Car car : cars.getCars()) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        System.out.println(result);
    }
}
