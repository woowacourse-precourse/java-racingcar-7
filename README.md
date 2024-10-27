# java-racingcar-precourse

 ## MVC 패턴 적용 전
- [x] 자동차 클래스 
  - 속성 - 이름(carName), 이동한 칸수(position)
  - getCarName - 자동차 이름을 return하는 함수
  - getPosition - 자동차가 이동한 칸 수를 return하는 함수
  - getCurrentPositionString - 이동 칸 수를 "--" 과 같은 형식으로 return 하는 함수
  - makeCarArrayList - 입력받은 차 이름으로 자동차 클래스 리스트 만들어 주는 함수


- [x] 경주 클래스
  - run - 사용자의 입력을 받고, 경주를 시작하는 함수
  - raceStart - 시도할 횟수만큼 각 자동차의 이동을 진행하는 함수
  - runCarOnce - 특정 자동차의 경주 1회 시도하는 함수 
    - shouldMove - 무작위 값을 돌려 전진 여부를 결정하는 함수
    - printOneCarResult - 실행 결과 출력하는 함수
  - getWinner - 경주가 완료된 이후 우승자를 계산하는 함수
  - printWinners - 우승자를 출력하는 함수