package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;


public class RaceGame {
    String[] carNamesList;
    int totalCars;
    int totalRounds;
    PriorityQueue<RacingCar> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    ArrayList<String> winners = new ArrayList<String>();

    //사용자의 입력을 받아들이는 메서드
    String getUserInput() throws IOException{
        String userInput;

        userInput = readLine();

        return userInput;
    }

    //사용자의 입력에서 이름을 추출해 배열로 저장하는 메서드
    void getNamesList(String input)throws Exception{
        //null 예외 처리 성공
        //comma 기준으로 구분 성공
        try{
            carNamesList = input.split(",");
            totalCars = carNamesList.length;
        } catch (NullPointerException e){
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }

        if (totalCars <= 1){
            throw new IllegalArgumentException("자동차가 2개 이상일 때 부터 자동차 경주를 진행할 수 있습니다.");
        }

        //이름의 앞,뒤 공백 제거 완료
        //빈 문자열일 경우 예외 처리, 빈 문자열이 리스트 중간에 있어도 예외 처리
        //공백으로 이루어진 문자열일 경우 예외 처리, 공백 문자열이 리스트 중간에 있어도 예외 처리
        for (int i = 0; i < totalCars; i++){
            carNamesList[i] = carNamesList[i].trim();

            if (carNamesList[i].isEmpty()){
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }

            if (carNamesList[i].matches("^( )+$")){
                throw new IllegalArgumentException("입력값이 공백으로 이루어져 있습니다.");
            }
        }
    }

    void getTotalRounds(String userInput){
        try{
            this.totalRounds = Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 정수 형태가 아닙니다.");
        }

        if (totalRounds < 1){
            throw new IllegalArgumentException("입력값이 1 이상이어야 합니다.");
        }
    }

    RacingCar[] registerCar(String[] carNamesList, int totalCars){
        RacingCar[] carList = new RacingCar[totalCars];

        for (int i = 0; i < totalCars; i++){
            carList[i] = new RacingCar();
            //carList[i].carName = carNamesList[i];
            try {
                carList[i].setCarName(carNamesList[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return carList;
    }

    void playOneRound(RacingCar[] carList){
        for (RacingCar car : carList){
            car.checkForwardCondition();
            if (car.forwardCondition){
                car.moveForward();
            }
        }
    }

    void printRoundResult(RacingCar[] carList){
        for (RacingCar car : carList){
            System.out.println(car.carName+" : "+car.currentLocation);
        }
    }

    String[] findWinningCars(RacingCar[] carList){
        for (RacingCar car : carList){
            priorityQueue.offer(car);
        }

        RacingCar max = priorityQueue.poll();
        int maxDistance = Objects.requireNonNull(max).currentDistance;
        winners.add(max.carName);

        RacingCar test = priorityQueue.poll();
        while(Objects.requireNonNull(test).currentDistance == maxDistance){
            winners.add(test.carName);
            test = priorityQueue.poll();
        }

        int listSize = winners.size();

        return winners.toArray(new String[listSize]);
    }

}
