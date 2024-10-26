# java-racingcar-precourse

## 🎯미션 조건,이해
    기본: 자동차 Class를 만들고, Main에서 객체를 생성해 관리한다. 

    확장성을 생각하면 (현 미션에서는 과하다고 생각이 들긴 하는데) '대회' Class를 만들어 참가 자동차를 필드로 가지는 구조로 만들면 좋을것 같다고 생각한다.

## 🚀기능구현 목록
- [x] A. Car, IO, Challenge 클래스 만들고 필드 작성하기
    - Car : name, distance
    - Challenge : Car을 ArrayList로 저장-> 대회에 참가한 자동차들
- [ ] B. IO class 구현
    - [x] inputCars()- Car 이름, 
    - [x] inputCount()- Move count 입력 받는 함수 구현
    - [ ] 입력의 유효성 검사(입력형식, 이름길이, 자동차의 동일이름 처리 등등)
- [x] C. Car class 함수 구현
    - 전진(moveCarFront) 기능 구현-> random 사용
- [x] D. Challenge 클래스에서 경주 진행하기
    - [x] addCar()- 자동차 등록하기
    - [x] makeWinnerList()- 우승자 선정하기
    - [x] printStep()- 중간과정 출력, printWinner()- 최종출력 함수 구현
    - [x] runChallenge()- 입력한 숫자만큼 car move 수행하는 함수 구현
- [ ] E. main 에서 경주 구현하기
    - 입력객체 생성후 입력받기
    - 입력에 따라 Car 객체를 생성하기-> ArrayList에 저장
    - Challenge객체 만들기-> 대회 생성
    - 우승자 구하고 출력하기
- [ ] F. Exception 처리하기
