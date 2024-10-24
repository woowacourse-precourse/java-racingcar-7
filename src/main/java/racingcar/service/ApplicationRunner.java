package racingcar.service;

import racingcar.domain.Cars;
import racingcar.endpoint.InputInterface;
import racingcar.endpoint.OutputInterface;

public abstract class ApplicationRunner {
    protected static void run(){
        String firstLine;
        String secondLine;
        try (InputInterface inputInterface=new InputInterface()) {
            OutputInterface.printMessage(OutputInterface.ENTER_PLAYER_NAME);
            firstLine = inputInterface.readLine();
            OutputInterface.printMessage(OutputInterface.ENTER_NUMBER_OF_TRIALS);
            secondLine = inputInterface.readLine();
        }
        CarFactory carFactory = new CarFactory();
        Cars cars=carFactory.createCars(firstLine);

        RacingService racingService = new RacingService(cars);
        racingService.playGame(secondLine);
    }
}
