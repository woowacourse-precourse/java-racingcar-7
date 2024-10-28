# java-racingcar-precourse

# Init Implement

## Car class

- abstract car in assignment requirement
- have only responsibility saving field and method of car.  

## Main Logic

- implement main logic of assignment requirement
- provide follow functions
  - user interface
  - race car 
  - give results

# Restructure as MVC pattern

## Model

### CarModel

- have responsibility to process main logic and update Car data
- provide interface for service logic and accessing Car data list
- return copied car data which is not same reference with repository of model

## Controller

### RaceController

- have responsibility to handle user request and send request to View and Model
- provide interface to user for request


## View

### RaceView

- have responsibility to interact with User and validate input or output
- provide interface for UI

## Main Application

- run and manage controller
- handle Exception