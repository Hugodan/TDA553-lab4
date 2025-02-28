import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    private final RepairShop<Volvo240> volvoRepairShop = new RepairShop<>(5,0,400);
    
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        //Set initial positions
        volvo.setPos(0,0);
        saab.setPos(0,100);
        scania.setPos(0,200);

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania );


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim gigidogidi", cc);

        new CarEventHandler(cc, cc.frame);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            ArrayList<Car> carsToRemove = new ArrayList<>();
            ArrayList<Integer> idsToRemove = new ArrayList<>();
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                if(x < 0 || x > 700 || y < 0 || y > 500){
                    car.turnLeft();
                    car.turnLeft();
                }
                if(car instanceof Volvo240 && checkInShop(car.getPosX(), car.getPosY(), volvoRepairShop.getPosX(), volvoRepairShop.getPosY())){
                    volvoRepairShop.loadCar((Volvo240)car);
                    carsToRemove.add(car);
                    idsToRemove.add(count);
                    
                }
                frame.drawPanel.moveit(count,x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                count++;
            }
            for(Integer i : idsToRemove){
                frame.drawPanel.removeCar(i);
            }
            cars.removeAll(carsToRemove);
        }
    }

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

    boolean checkInShop(double posX, double posY, double shopX, double shopY){
        return shopX <= posX && shopX + 101 >= posX &&  shopY <= posY && shopY + 96 >= posY;
    }
}
