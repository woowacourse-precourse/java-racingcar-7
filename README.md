# java-racingcar-precourse

# 프리코스 목표 설정

- **객체지향적인 설계를 생각해보자**
- **테스트 주도 개발(TDD)를 익혀보자**
- **리펙터링 습관화를 하자**

# 기능 목록

## Class Diagram

## Application Class

- [ ] 입력 값 추가
- [ ] Race 객체 생성
- [ ] 사용자 인터페이스 추가

## Validator Class

- [x]  테스트 코드 작성
    - [x] validate 테스트 코드 작성
- [x] 정규식 작성
    - [x] 사용자 입력(경기 횟수) 정규식 작성
    - [x] 사용자 입력(자동차들) 정규식 작성
- [x] validate 메소드 구현

## Car Class

- [x] 테스트 코드 작성
    - [x] move 테스트 코드 작성
    - [x] increaseDistance 테스트 코드 작성
    - [x] getName 테스트 코드 작성
- [x] move 메소드 구현
- [x] increaseDistance, getDistance 메소드 구현
- [x] getName 메소드 구현
- [x] isMovable 메소드 구현

## Util Class

- [x] 사용자 입력 메소드 구현
- [x] 랜덤 값 추출 메소드 구현

## Judge Class

- [x] 테스트 코드 작성
    - [x] judge 테스트 코드 작성
    - [x] getWinnerName 테스트 코드 작성
- [x] judge 메소드 구현
- [x] show 메소드 구현
- [x] getWinnerName 메소드 구현

## Race Class

- [x] 테스트 코드 작성
    - [x] setup 테스트 코드 작성
    - [x] separateInputCars 테스트 코드 작성
- [ ] run 메소드 구현
- [ ] startGame 메소드 구현
- [ ] moveCar 메소드 구현
- [x] setup 메소드 구현
- [ ] show 메소드 구현
- [x] getCars 메소드 구현
- [x] separateInputCars 메소드 구현