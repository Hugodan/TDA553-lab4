import java.util.ArrayList;

public class RepairShop <T extends Car> implements CarCollection<T> {

    private ArrayList<T> parkedCars;
    private int capacity;

    public RepairShop(int capacity) {
        parkedCars = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public ArrayList<T> getLoadedCars(){
        return parkedCars;
    }


    @Override
    public void loadCar(T car) {
        if(parkedCars.size() >= capacity){
            throw new IndexOutOfBoundsException("shop is full");
        }
        parkedCars.add(car);
    }

    public boolean unloadCar(T car) {
        return parkedCars.remove(car); 
    }
}

