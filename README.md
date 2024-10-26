# java-racingcar-precourse

## 🎯미션 조건,이해
기본: 자동차 Class를 만들고, Main에서 객체를 생성해 관리한다. 

확장성을 생각하면 (현 미션에서는 과하다고 생각이 들긴 하는데) '대회' Class를 만들어 참가 자동차를 필드로 가지는 구조로 만들면 좋을것 같다고 생각한다.

## 🚀기능구현 목록
- [x] A. Car, IO, Challenge 클래스 만들고 필드 작성하기
    - Car : name, distance
    - Challenge : Car을 ArrayList로 저장-> 대회에 참가한 자동차들
- [x] B. IO class 구현
    - [x] inputCars()- Car 이름, 
    - [x] inputCount()- Move count 입력 받는 함수 구현
- [x] C. Car class 함수 구현
    - 전진(moveCarFront) 기능 구현-> random 사용
- [x] D. Challenge 클래스에서 경주 진행하기
    - [x] addCar()- 자동차 등록하기
    - [x] makeWinnerList()- 우승자 선정하기
    - [x] printStep()- 중간과정 출력, printWinner()- 최종출력 함수 구현
    - [x] runChallenge()- 입력한 숫자만큼 car move 수행하는 함수 구현
- [x] E. main 에서 경주 구현하기
    - 입력객체 생성후 입력받기
    - Challenge객체 만들기-> 대회 생성
    - 입력에 따라 Car 객체를 생성하기-> ArrayList에 저장
    - 대회 진행후, 우승자 구하고 출력하기
- [x] F. Exception 처리하기
    - [x] Car 이름 입력형식 오류 -> 공백은 제거함, 길이가 5를 넘어갈 경우 예외처리
    - [x] 시도횟수 입력오류-> 양의 Int 정수만 가능함

## 미션 과정
- 최대한 주석을 사용하지 않아도 될 만큼의 쉽고 직관적인 이름을 생각하려 했다.
- 코드 포매팅 단축키를 알게되었다... 이걸 그동안 왜 몰랐지
- String.join이 1주차 피드백에 있어서 바로 사용했다.
- 조금 고민인 부분은, README.md에 기능 목록을 작성하고 프로그래밍 하면서 중간에 Commit 하는것이 아직 어색하다. 그래도 습관이 생기도록 연습해야지. 
- 커밋 메시지에 일관성을 주려 노력했다. 그래도 아직 어색하다. 
- 미션 구현 자체는 솔직히 쉬웠다.