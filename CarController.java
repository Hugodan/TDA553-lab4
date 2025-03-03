import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    ArrayList<Car> cars = new ArrayList<>();
    
    //methods:


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars
                ) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars
                ) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }    

    void raiseFlatbed(float amount) {
        for (Car car : cars
                ) {
            if(car instanceof Scania){
                ((Scania)car).raiseAngle(amount);
            }
        }
    }    

    void lowerFlatbed(float amount) {
        for (Car car : cars
                ) {
            if(car instanceof Scania){
                ((Scania)car).lowerAngle(amount);
            }
        }
    }        

    void startEngine() {
        for (Car car : cars
                ) {
            car.startEngine();
        }
    } 

    void stopEngine() {
        for (Car car : cars
                ) {
            car.stopEngine();
        }
    } 

}
