import java.util.ArrayList;

public class CarController {
    private final ArrayList<Car> cars = new ArrayList<>();


    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
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
}
