import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarController {
    private final ArrayList<Car> cars = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();


    public void addCar(Car car) {
        cars.add(car);
        notifyObservers();
    }

    public void removeCar(Car car) {
        cars.remove(car);
        notifyObservers();
    }

    public void addRandomCar() {
        ArrayList<Car> cars = getCars();
        if (cars.size() < 11){
            Car[] array = {CarFactory.createCar("Volvo240") ,CarFactory.createCar("Saab95"), CarFactory.createCar("Scania")};
            Random random = new Random();
            Car randomCar = array[random.nextInt(array.length)];
            cars.add(randomCar);
            notifyObservers();
        }
    }

    public void removeRandomCar() {
        ArrayList<Car> cars = getCars();
        if (cars.size() > 0){
            Random random = new Random();
            int randomIndex = random.nextInt(cars.size());
            cars.remove(cars.get(randomIndex));
            notifyObservers();
        }    
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void raiseFlatbed(float amount) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseAngle(amount);
            }
        }
    }

    public void lowerFlatbed(float amount) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerAngle(amount);
            }
        }
    }

    public void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
        notifyObservers();
    }
}
