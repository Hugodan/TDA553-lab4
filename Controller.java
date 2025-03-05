import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private final CarController carController;
    private final CarRepairShopController repairShopController;
    private final int delay = 50;
    private Timer timer;
    private CarView frame;

    public Controller(CarController carController, CarRepairShopController repairShopController, CarView frame) {
        this.carController = carController;
        this.repairShopController = repairShopController;
        this.frame = frame;
        this.timer = new Timer(delay, new TimerListener());

        // Start simulation
        timer.start();
    }

    public void gas(int amount) {
        carController.gas(amount);
    }

    public void brake(int amount) {
        carController.brake(amount);
    }

    public void turboOn() {
        carController.turboOn();
    }

    public void turboOff() {
        carController.turboOff();
    }

    public void raiseFlatbed(float amount) {
        carController.raiseFlatbed(amount);
    }

    public void lowerFlatbed(float amount) {
        carController.lowerFlatbed(amount);
    }

    public void startEngine() {
        carController.startEngine();
    }

    public void stopEngine() {
        carController.stopEngine();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Car> carsToRemove = new ArrayList<>();
    
            for (Car car : carController.getCars()) {
                car.move();
    
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
    
                if (x < 0 || x > frame.getWidth() - 100) { 
                    car.turnLeft();
                    car.turnLeft(); 
                }
                if (y < 0 || y > frame.getHeight() - 200) {
                    car.turnLeft();
                    car.turnLeft();
                }
    
            
                if (repairShopController.checkInShop(car) && car instanceof Volvo240) {
                    repairShopController.loadCar((Volvo240) car);
                    carsToRemove.add(car);
                }
    
                }

                for(Car car : carsToRemove){
                    frame.drawPanel.removeCar(car);
                }
                carController.getCars().removeAll(carsToRemove);
                carController.notifyObservers();
            
            }
        }

    
    
        
    

    public static void main(String[] args) {
        CarController carController = new CarController();
        CarRepairShopController repairShopController = new CarRepairShopController(5, 0, 400);
        CarView frame = new CarView("Car Sim 1.0", carController);
        Controller controller = new Controller(carController, repairShopController, frame);
       

        
        new CarEventHandler(controller, frame);

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        volvo.setPos(0, 0);
        saab.setPos(0, 100);
        scania.setPos(0, 200);

        carController.addCar(volvo);
        carController.addCar(saab);
        carController.addCar(scania);
    }
}
