## 기능 목록 

### 입력 기능 
  
  >입력에서는 camp.nextstep.edu.missionutils에서 제공하는 Console API의 readLine()을 반드시 활용 해야 한다."

  - 경주할 자동차 이름 입력 ','구분자
    - 요구 예외 상황: 이름이 6자 이상이면 IllegalArgumentException을 발생하고 프로그램을 종료시킨다.
    
  - 시도할 횟수 입력 (숫자만)
    - 요구 예외 사항: 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생하고 프로그램을 종료시킨다.

### 경주 진행
  >"camp.nextstep.edu.missionutils에서 제공하는 Randoms API의 pickNumberInRange 를 반드시 활용하여 랜덤한 값을 가져와야 한다"

  - 시도 횟수별 각 실행 결과를 보여 준다.
  - 자동차는 0-9사이의 무작위 값에서 4이상일 경우 전진한다

### 우승자 판정
  - 우승자 판단 후 출력
  - 우승자가 2명 이상일 수 있으며 ','로 구분하여 우승자들을 출력한다