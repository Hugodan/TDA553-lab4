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

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Car> carsToRemove = new ArrayList<>();
            ArrayList<Integer> idsToRemove = new ArrayList<>();
    
            int index = 0; // Track car index
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
                    idsToRemove.add(index);
                }
    
                frame.drawPanel.moveit(index, x, y);
                frame.drawPanel.repaint();
    
                index++; 
                }

                for(Integer i : idsToRemove){
                    frame.drawPanel.removeCar(i);
    
                carController.getCars().removeAll(carsToRemove);
            
            }
        }
    }
    
    
        
    

    public static void main(String[] args) {
        CarController carController = new CarController();
        CarRepairShopController repairShopController = new CarRepairShopController(5, 0, 400);
        CarView frame = new CarView("Car Sim 1.0");
        new Controller(carController, repairShopController, frame);
       

        
        new CarEventHandler(carController, frame);

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
