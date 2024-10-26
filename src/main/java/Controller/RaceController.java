package Controller;

import VO.CarVO;
import DAO.RaceDAO;
import Service.RaceService;
import View.RaceView;

import java.util.List;

public class RaceController {
    private RaceView raceView = new RaceView();
    private RaceDAO raceDAO = new RaceDAO();


    public void raceMain(){
        try{
        String[] carNames = raceView.userInputCarName();

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            if(carNames[i].isEmpty()) {
                throw new IllegalArgumentException("입력하신 자동차 이름을 다시 확안하시고 입력해주세요.");
            }
            raceDAO.inputCar(new CarVO(carNames[i]));
        }

        int round = raceView.userInputRaceRound();
        if(round <= 0) {
            throw new IllegalArgumentException("경주 횟수를 잘못입력하셨습니다.확인 후 다시 입력해주세요.");
        }

        List<CarVO> cars = raceDAO.Carlist();
        RaceService raceService = new RaceService(cars,round);


        raceService.roundStart();

        raceView.raceWinner(raceService.winnerCars());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
