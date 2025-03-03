import java.awt.*;

public class FlatBedCar extends Car {
    
    public FlatBed flatBed;

    public FlatBedCar(int doors, Color carColor, int power, String model, double maxAngle){
        super(doors,carColor,power,model);
        this.flatBed = new FlatBed(maxAngle);
    }

    //Cannot start engine if angle is not 0. would indicate ramp is up for car transport
    @Override
    public void startEngine(){
        if (flatBed.getAngle() == 0){
            engineOn = true;
        }       
    }

    public double getAngle(){
        return flatBed.getAngle();
    }

    protected void setAngle(double var){
        flatBed.setAngle(var);
    }

    protected void raiseAngle(double var){
        if (getCurrentSpeed() == 0){
            flatBed.raiseAngle(var);
        }
    }

    protected void lowerAngle(double var){
        if (getCurrentSpeed() == 0){
            flatBed.lowerAngle(var);
        }   
    }
}
