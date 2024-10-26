package domain;

import iohandler.InputHandler;
import iohandler.OutputHandler;
import strategy.MoveStrategy;

import java.util.List;

public class CarRacing {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final MoveStrategy moveStrategy;
    private List<Car> cars;

    public CarRacing(InputHandler inputHandler, OutputHandler outputHandler, MoveStrategy moveStrategy) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.moveStrategy = moveStrategy;
    }

    public void run(){
        cars = inputHandler.inputCars();
        int attempts = inputHandler.inputAttempt();

        for(int i = 0 ; i<attempts; i++){
            carMove(cars);
            outputHandler.printResult(cars);
        }

        outputHandler.printWinners(cars);
    }

    private void carMove(List<Car> cars){
        for (Car car : cars) {
            car.move(moveStrategy.isPossibleToMove());
        }
    }


}
