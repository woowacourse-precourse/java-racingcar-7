package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Service.CarService;
import racingcar.Service.Input;

public class carController {

    Input inputMethod = new Input();
    CarService carService = new CarService();

    public void start(){
        String input = Console.readLine();
        String[] carNames = inputMethod.getInput(input);
        Car[] cars = carService.convertToCar(carNames);
    }
}
