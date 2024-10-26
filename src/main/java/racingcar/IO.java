package racingcar;

public class IO {
    public String[] InputCars(){
        String inputCarData = camp.nextstep.edu.missionutils.Console.readLine();
        String[] carNames = inputCarData.split(",");
        return carNames;
    }

    public int InputCount()
    {
        String inputMoveCnt = camp.nextstep.edu.missionutils.Console.readLine();
        int cnt = Integer.parseInt(inputMoveCnt);
        return cnt;
    }
}
