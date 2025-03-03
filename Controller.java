import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller extends CarEventHandler {

    private final CarController cc;
    private final CarRepairShopController crsc;
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;

  
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        CarRepairShopController crsc = new CarRepairShopController(5,0,400);
        Controller con = new Controller(cc, crsc);

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

        Controller con = new Controller();
        con.frame = new CarView("CarSim 1.0", con);  // Ensure it's initialized


        // Start a new view and send a reference of self
       
    
        new CarEventHandler();

        // Start the timer
        con.timer.start();
    }   

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            ArrayList<Car> carsToRemove = new ArrayList<>();
            ArrayList<Integer> idsToRemove = new ArrayList<>();
            for (Car car : cc.cars) {
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                if(x < 0 || x > 700 || y < 0 || y > 500){
                    car.turnLeft();
                    car.turnLeft();
                }
                if(car instanceof Volvo240 && crsc.checkInShop(car.getPosX(), car.getPosY(), crsc.volvoRepairShop.getPosX(), crsc.volvoRepairShop.getPosY())){
                    crsc.volvoRepairShop.loadCar((Volvo240)car);
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
            cc.cars.removeAll(carsToRemove);
        }
    }
    
}
