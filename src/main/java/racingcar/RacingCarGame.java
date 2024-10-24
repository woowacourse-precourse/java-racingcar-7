package racingcar;

import java.util.List;

public class RacingCarGame {
    public void run() {
        try{
            ApplicationOutputView.outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(, ) 기준으로 구분)");

            List<String> carNames = Parser.select(CarNameParser.class).parse(ApplicationInputView.input());
            List<Car> cars = carNames.stream().map(Car::new).toList();

            ApplicationOutputView.outputLine("시도할 횟수는 몇 회인가요?");
            int trial = ApplicationInputView.getInt();

            RacingCarGameSimulator simulator = new RacingCarGameSimulator();
            SimulationResult<String> textResult = simulator.simulate(cars, trial);

            textResult.getResult().forEach(ApplicationOutputView::outputLine);
        }catch (ReflectiveOperationException e){
            System.out.println("[Debug] Parser 클래스에서 에러가 발생하였습니다. 원인은 나도모름 ㅋㅋ");
        }
    }
}
