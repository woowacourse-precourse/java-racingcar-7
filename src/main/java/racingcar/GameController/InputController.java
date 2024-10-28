package racingcar.GameController;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Input.NameInput;

public class InputController {

  private NameInput nameInput;
  private int gameRound;


  public InputController(){
    getInput();
  }

  public void getInput(){
    setNameInput();
    setGameRoundInput();
  }

  public void setNameInput(){
    NameInput nameInput = new NameInput();
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String names = Console.readLine();
    if(nameInput.validateInput(names)){
      nameInput.setName(names);
    }else {
      throw new IllegalArgumentException();
    }
    this.nameInput = nameInput;
  }

  public void setGameRoundInput(){
    System.out.println("시도할 횟수는 몇 회인가요?");
    this.gameRound = Integer.parseInt(Console.readLine());
  }

  public int getGameRound() {
    return this.gameRound;
  }

  public NameInput getNameInput() {
    return this.nameInput;
  }
}
