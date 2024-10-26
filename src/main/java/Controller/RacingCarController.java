package Controller;

import Service.RacingCarService;
import util.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarController {
    private List<String> carName;
    private List<Integer> process;
    private int numTry;
    private String result;

    public RacingCarController(List<String> carName, int numTry) {
        this.carName = carName;
        this.numTry = numTry;
    }

    public void run() {
        this.process = new ArrayList<>(Collections.nCopies(this.carName.size(), 0));
        this.result = RacingCarService.run(this.carName, this.process, this.numTry);
    }

    public String result() {
        String winner = Result.printWinner(this.carName, this.process);

        return result + winner;
    }
}
