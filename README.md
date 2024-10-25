# java-racingcar-precourse

# controller
## 1) GameController 
* createCars //Car 객체 생성하기, Car객체를 Cars로 묶기
* RunningGame //n번 게임 실행시키기
* outputResult //결과 출력하기
---
# model
## 1) Car
* settingCarPosition // 자동차 위치 정하기
* checkCarNameAvailable // 자동차 이름 길이 확인

## 2) Cars
* chooseWinningCars // 우승차들 고르기

## 3) WinningCars

## 4) Move
* createRandomValue //랜덤 값 생성하기
* checkMovable //n 이상 나오면 true 반환하기
* moveCar //자동차 위치 변경하기

---
# view
## 1)  InputView
* inputCarsName //차 이름들 입력받기
* inputTrialCount //시도횟수 입력받기
## 2) OutputView
* printTrialResult //시도결과 출력
* createTrialResult //시도결과 출력문 만들기
* printWinningCars //최종 우승자 출력
* createWinningCars //최종 우승자 출력문 만들기
