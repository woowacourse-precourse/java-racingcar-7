# 자동차 경주
## 기능 목록
### view package
- output class
    + [0] 경기 시도 횟수 만큼 실행결과를 출력하는 기능 - printRacingResult
    + [0] 최종 우승자를 출력하는 기능 - printFinalWinner
  
- input class
    + [0] 경주할 자동차 이름을 입력받는 기능 - inputCarName
    + [0] 경주 시도 횟수를 입력받는 기능 - inputTryCount
  
### model package
- GameLogicTransform class
    + [0] view가 받은 경주할 자동차 이름을 map으로 전환 - mapByCarName
    + [0] 경기 결과에 따른 map value 수정 - updateMapByResult
    + [0] 0부터 9사이의 무작위 값 중 4이상 값이 나오는지 판단하는 기능 isNumberMoreFour
  
- GameLogicValidation class
    + [0] 최종 우승자를 판단하는 기능 findRacingWinner
  
### service package
- racingCarGameRunner class : model 기능을 통해 게임 로직 구현, map 저장 위치
    + [0] 게임 1회 시도 후 변경된 map 반환  getOneTryResult
    + [0] 최종 우승자 반환 - getFinalWinner

### controller package
- racingCarGameManager class
    + [] 게임 진행 기능 - runGame
  
### validation package
- validateException class
    + [0] 자동차 이름에 대한 검증 메서드 - isCarNameValid
      + [0] 자동차 이름이 5자 이하인지 검증 - isCarNameLengthValid
      + [0] 자동차 이름이 입력되었는지 검증 - isCarNameEmpty
   + [0] 경주 횟수에 대한 검증 메서드 - isTryCountValid
      + [0] 경주 횟수가 입력되었는지 검증 - isTryCountEmpty
      + [0] 경주 횟수가 1이상인지 검증 - isTryCountNaturalNumber
      + [0] 경주 횟수가 숫자인지 검증 - isTryCountNumber

  
## 구현 규칙
- indent(들여쓰기) depth를 2단계로 제한한다.
- 3항 연산자 사용 금지
- 하나의 메서드는 하나의 일을 한다
- 각 메서드에 대한 테스트 코드를 작성한다
- 커밋 메시지를 의미있게 작성한다
- 의도를 가진 네이밍 사용
- 축약하지 말것
- 필요한 부분에만 주석 사용하기

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.