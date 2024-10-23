package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Service.CarService;
import racingcar.Service.Input;
import racingcar.Service.Output;

public class carController {

    Input inputMethod = new Input();
    CarService carService = new CarService();
    Output outputMethod = new Output();

    public void start(){

        outputMethod.firstPrint();
        String input = Console.readLine();
        String[] carNames = inputMethod.getCarInput(input);
        Car[] cars = carService.convertToCar(carNames);

        outputMethod.cntPrint();
        int cnt = inputMethod.getCntInput(Console.readLine());

        carService.startRace(cars,cnt);
    }
}
