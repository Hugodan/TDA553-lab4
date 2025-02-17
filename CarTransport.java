import java.awt.*;
import java.util.*;

public class CarTransport<T extends Car> extends FlatBedCar implements CarCollection<T> {
    Stack<T> carTransportBed = new Stack<>();
    private int capacity;

    public CarTransport(){
        super(2,Color.green,100,"MercedesLPS338",1 );
        capacity = 4;
        setHeavyVehicle();
    }

    //angle 0 means the ramp is raised
    
    public void raiseAngle(){
        setAngle(0);
    }

    //Angle 1 means ramp is lowered. cannot lower if moving
    public void lowerAngle(){
        if (getCurrentSpeed() == 0){
            setAngle(1);
        }

    }


    //Car transport capacity is 4 cars. If car is within +- meter of transport loading is permitted.
    @Override
    public void loadCar(T car){
        if (carTransportBed.size() <= capacity && getAngle() == 1 && car.getPosX() > getPosX() - 1 && car.getPosX() < getPosX() + 1 && car.getPosY() > getPosY() - 1 && car.getPosY() < getPosY() + 1 && car.getHeavyVehicle() == false){ 
            carTransportBed.push(car);
        }
    }
    @Override
    public Stack<T> getLoadedCars(){
        return carTransportBed;
    }

    //If ramp is down and the bed is not empty, unload the last car that was loaded
    public T unloadCar(){
        if (!carTransportBed.isEmpty() && getAngle() == 1 ){
            return carTransportBed.pop();
        }
        return null;
    }

    //Move the cars on the bed when the car transport moves
    public void move() {
        super.move();
        double transportX = getPosX();
        double transportY = getPosY();

        for (int i = 0; i < carTransportBed.size();i++){
            carTransportBed.get(i).setPos(transportX,transportY);
        }
    }
}