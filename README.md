# java-racingcar-precourse

## Features

- [x] implement car
    - [x] randomly move or stop
    - [x] set name
    - [x] print status
- [x] implement game
    - [x] set cars
    - [x] move cars
    - [x] find winners
- [x] implement cli
    - [x] parse user input
    - [x] print status and result
    - [x] handle exceptions

## Spec

- A set of cars either move or stop a given number of times.
- Each car has a name. The name should be displayed while showing each progresssion.
- Car names are separated by commas (,) and can have a maximum length of 5 characters.
- The user can determine how many times the car will progress.
- Car moves if the random number between 0 to 9 is greater than or equal to 4.
- The winner is displayed at the end of the game, and there can be multiple winners.
- If there is more than one winner, display the winners' names seperated by commas (,).
- Throw an IllegalArgumentException and exit application if the user provides invalid input.

## Example

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
