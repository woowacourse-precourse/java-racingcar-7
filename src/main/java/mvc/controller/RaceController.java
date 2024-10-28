package mvc.controller;

import java.util.List;
import mvc.model.CarModel;
import mvc.view.RaceView;
import racingcar.Car;

public class RaceController {
    RaceView raceView;
    CarModel carModel;

    public RaceController(){
        raceView = new RaceView();
        carModel = new CarModel();
    }

    public void runRace(){

        int stage = this.configRace();

        for(int i = 0; i< stage; ++i) {
            this.raceView.printStageState(i+1);
            this.carModel.tryMoveAllCars();
            List<Car> playerList = this.carModel.findAll();
            playerList.forEach(player->{
                this.raceView.printCarState(player);
            });
        }

        raceView.printRaceResult(this.carModel.findWinner(stage));
    }


    int configRace(){
        this.registerCars();
        int stage = this.configRaceStage();

        return stage;
    }

    void registerCars(){
        List<String> carList = raceView.showRegistrationPage();

        for(String name : carList) {
            Car newCar = this.carModel.createCar(name);
            this.carModel.insertCar(newCar);
        }
    }

    int configRaceStage(){
        return raceView.showRaceStageSettingPage();
    }




}
