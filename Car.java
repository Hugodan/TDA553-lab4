import java.awt.*;


public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double posX;
    private double posY;
    private int direction;
    private boolean heavyVehicle;
    
    public Car(int doors, Color carColor, int power, String model){
        nrDoors = doors;
        color = carColor;
        enginePower = power;
        modelName = model;
        posX = 0;
        posY = 0;
        direction = 0;
        heavyVehicle = false;
        stopEngine();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public int getDirection(){
        return direction;
    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
    }

    protected void setPos(double x, double y){
        posX = x;
        posY = y;
    }

    private void setDirection(int newDirection){
        direction = newDirection;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.01; 
    }

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            if(getCurrentSpeed() + speedFactor() * amount <= getEnginePower()){
                incrementSpeed(amount);
            }
        }            
    }


    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }

    public void move(){
        direction = getDirection();
        posX = getPosX();
        posY = getPosY();
        currentSpeed = getCurrentSpeed();
        if (direction == 0) {
            setPos(posX, posY+currentSpeed);
        }
        else if (direction == 1) {
            setPos(posX+currentSpeed, posY);
        }
        else if (direction == 2) {
            setPos(posX, posY-currentSpeed);
        }
        else if (direction == 3) {
            setPos(posX-currentSpeed, posY);
        }
    }

    public void turnLeft() {
        int[] directions = {0, 1, 2, 3};
        int newDirection = (direction - 1 + directions.length) % directions.length;
        setDirection(directions[newDirection]);
    }
    
    public void turnRight() {
        int[] directions = {0, 1, 2, 3};
        int newDirection = (direction + 1) % directions.length;
        setDirection(directions[newDirection]);
    }
    protected boolean getHeavyVehicle(){
        return heavyVehicle;
    }

    protected void setHeavyVehicle(){
        heavyVehicle = true;
    }
    
}
