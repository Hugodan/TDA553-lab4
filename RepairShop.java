import java.util.ArrayList;

public class RepairShop <T extends Car> implements CarCollection<T> {

    private ArrayList<T> parkedCars;
    private int capacity;
    protected double posX;
    protected double posY;


    public RepairShop(int capacity,double posX, double posY) {
        parkedCars = new ArrayList<>();
        this.capacity = capacity;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public ArrayList<T> getLoadedCars(){
        return parkedCars;
    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
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

