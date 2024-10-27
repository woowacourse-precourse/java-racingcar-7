package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class OutputViewTest {

    private List<Round> rounds = new ArrayList<>();
    private List<String> names = new ArrayList<>();


    @BeforeEach
    public void set() {
        Round round1 = new Round();
        Round round2 = new Round();
        Round round3 = new Round();

        round1.addCarLocation("pobi",1);
        round1.addCarLocation("woni",0);
        round1.addCarLocation("jun",1);

        round2.addCarLocation("pobi",2);
        round2.addCarLocation("woni",1);
        round2.addCarLocation("jun",2);

        round3.addCarLocation("pobi",3);
        round3.addCarLocation("woni",2);
        round3.addCarLocation("jun",2);


        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        names.add("pobi");
        names.add("woni");

    }

    @Test
    public void testPrintStep(){
        OutputView outputView = new OutputView();
        outputView.printStep(rounds);
    }

    @Test
    public void testGetWinner(){
        OutputView outputView = new OutputView();
        outputView.printWinner(names);


    }

}