package racingcar;

import static util.Extractor.extractCarList;
import static util.Input.getInput;
import static util.Race.startRacing;

import dto.RacingInput;
import repository.CarRepository;
import util.Output;

public class Application {
    public static void main(String[] args) {
        // 여기서 사용되지 않는 코드는 필요 없는 코드가 아닐까?
        // 절차지향으로 TDD 한 뒤에 리팩토링 하면서 함수 쪼개고 TDD 하기

        // 입력 기능
        RacingInput input = getInput();

        CarRepository.cars = extractCarList(input.cars());
        CarRepository.repeatCount = Integer.parseInt(input.repeatCount());

        // 입출력 기능 리팩토링중
        startRacing(CarRepository.repeatCount);

        Output.printRacingResult();
        Output.printWinningCars();
    }

}
