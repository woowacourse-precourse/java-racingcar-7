package racingcar.service;

import racingcar.constant.Message;
import racingcar.dto.CarsDto;
import racingcar.model.Car;
import racingcar.model.Separator;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public CarsDto raceSetting(String inputCars) {
        Separator separator = new Separator();
        return new CarsDto(separator.separateCars(inputCars));
    }

    public CarsDto playOneRound(CarsDto carsDto) {
        for (Car car : carsDto.getCars()) {
            car.goRound();
        }
        return carsDto;
    }

    public int roundService(String round) {
        int roundCount = 0;
        if (round.isEmpty()) {
            throw new IllegalArgumentException(Message.ROUND_EMPTY_VALIDATION_MESSAGE.getMessage());
        }
        try{
            roundCount = Integer.parseInt(round);
        }catch (Exception e){
            throw new IllegalArgumentException(Message.ROUND_COUNT_SHOUL_BE_NUMBER_VALIDATION_MESSAGE.getMessage());
        }
        return roundCount;
    }
    public List<String> raceResult(CarsDto carsDto) {
        int maxWin = 0;
        List<String> winCars = new ArrayList<>();
        for (Car car : carsDto.getCars()) {
            if (car.getWinStack() > maxWin) {
                maxWin = car.getWinStack();
            }
        }
        for(Car car : carsDto.getCars()) {
            if(car.getWinStack() == maxWin) {
                winCars.add(car.getName());
            }
        }
        return winCars;
    }
}
