public class CarRepairShopController {
    private RepairShop<Volvo240> volvoRepairShop;

    public CarRepairShopController(int capacity, double posX, double posY) {
        this.volvoRepairShop = new RepairShop<>(capacity, posX, posY);
    }


    public boolean checkInShop(Car car) {
        double posX = car.getPosX();
        double posY = car.getPosY();
        double shopX = volvoRepairShop.getPosX();
        double shopY = volvoRepairShop.getPosY();

        return shopX <= posX && shopX + 101 >= posX && shopY <= posY && shopY + 96 >= posY;
    }

    public void loadCar(Volvo240 car) {
        volvoRepairShop.loadCar(car);
    }
}

