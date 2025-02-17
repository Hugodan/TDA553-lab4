import java.util.Collection;

public interface CarCollection<T extends Car> {
    void loadCar(T car);
    Collection<T> getLoadedCars();
}