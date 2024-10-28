package racingcar;

public class Application {
    public static void main(String[] args) {
        String carNames = InputHandler.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = Parser.parseCar(carNames);

        String playCountInput = InputHandler.readLine("시도할 횟수는 몇 회인가요?");
        PlayCount playCount = Parser.parsePlayCount(playCountInput);
    }
}
