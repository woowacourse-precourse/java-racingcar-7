# java-racingcar-precourse

## 구현할 기능 목록


### 1. Car 클래스를 생성 후 차 이름 변수와 움직인 거리 변수, 차 이름을 파라미터로 갖는 생성자를 정의한다.

### 2. RacingProgram 클래스를 생성 후 List형태로 Car 클래스 정보를 저장하는 변수, 게임을 실행할 횟수의 정보를 갖고있는 변수를 선언한다.

### 3. RacingProgram 클래스에서 사용자에게 ","로 구분되는 차량이름이 담긴 문자열을 입력받고 리스트 객체에 값을 할당한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;3-a. getCarNamesFromUser 메서드를 생성한다

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자로부터 자동차 이름들을 받고
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아래의 splitName 메서드를 통해 리스트에 Car 객체를 집어넣는다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;3-b. splitName 메서드를 생성한다

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;입력받은 문자열을 파라미터로 넘긴다.
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"," 기준으로 문자열을 분해 후 나온 이름들에 대해 공백이 있는 경우 공백을 지운 후 아래의 validateCarName, validateDuplication 메서드를 호출후 최종적으로 리스트 객체를 반환한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;3-c.  validateCarName, validateDuplication 메서드를 생성한다

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;validateCarName 메서드를 통해 차 이름이 공백이거나 글자수가 넘는 경우인지 확인한다.
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;validateDuplication 메서드를 통해 차 이름에 중복이 있는지 확인한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;3-d. createCar메서드를 생성한다

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;위의 조건들을 만족한 차량 이름으로 차 객체를 생성한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;3-e. RacingProgram 클래스에 대해 assertj를 활용해 테스트 코드를 작성한다.

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;올바른 입력, 문자열 내에 공백이 있는 경우, 문자열내에 중복이 있는 경우, 차 이름의 글자수가 5자를 넘어가는 경우에 대해 확인을 한다.

### 4. getAttemptFromUser메서드를 통해 사용자로부터 게임을 진행할 횟수를 입력받는다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;4-a. parseStringToNumber, validatePositive 메서드를 작성한다.

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;getAttemptFromUser 메서드 내에서 parseStringToNumber 메서드를 통해 문자열을 양수로 바꾸고 validatePositive 메서드를 통해 형식에 맞는지 등을 체크해서 클래스 변수에 집어넣는다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;4-b. RacingProgram 클래스에 대해 assertj를 활용해 횟수 입력 관련 테스트 코드를 작성한다.

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;올바른 입력, 문자열 내에 공백이 있는 경우, 문자열내에 중복이 있는 경우, 차 이름의 글자수가 5자를 넘어가는 경우에 대해 확인을 한다.

### 5. Car 클래스에 변수에 게임 구현에 필요한 변수와 메서드를 추가로 구현한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;5-a. 각 회차마다 얼마나 이동했는지 표시를 위한 view 변수, 생성자에 추가한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;5-b. getter 메서드, playCar 메서드, printDistance 메서드를 추가한다.
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; playCar 메서드 내에서 Randoms API를 활용하여 조건을 만족시 거리와 뷰에 연산을 처리후 printDistance 호출을 통해 회차마다 이동한 거리를 표시한다.

  #### &nbsp;&nbsp;&nbsp;&nbsp;5-c. getter 메서드, playCar 메서드, printDistance 메서드를 추가한다.

### 6. RacingProgram 클래스에 이전에 받은 게임 수행 횟수만큼 게임을 진행한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;6-a. gameStart 메서드와 moveCars 메서드를 추가한다.

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; moveCars 메서드 내에는 Car 클래스에서 정의했던 playCar 메서드를 통해 랜덤값을 이용하여 움직인다.

### 7. RacingProgram 클래스에 위에서 진행한 gameStart를 통해 경주가 완료된 차량들에 대해 gameResult 메서드로 최종 결과를 출력한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;7-a. gameResult 내에서 getMaxDistance 메서드를 통해 가장 많이 이동한 거리값을, getWinnerIfMaxDistance 와 printWinnerName 메서드를 통해 최종 결과값을 출력한다.

  ####  &nbsp;&nbsp;&nbsp;&nbsp;7-b. 위에서 작성한 코드의 테스트를 위해 Car에 생성자 추가 및 테스트 코드를 작성한다. 

### 8. RacingProgram 클래스 내에 Play 메서드를 통해 위의 전체 과정을 한번에 진행하도록 하고 Application 클래스에서 RacingProgram 객체 생성 후 play 메서드를 통해 프로그램을 실행한다.

### 9. validateCarName, validateDuplication, validateDuplication 메서드를 Validator 클래스로 옮기고 domain과 util 디렉토리 생성을 통해 refactoring을 진행한다. 
