public class FlatBed {
    private double angle;
    protected double maxAngle;

    public FlatBed(double maxAngle) {
        this.angle = 0.0;
        this.maxAngle = maxAngle;
    }
    
    public double getAngle(){
        return angle;
    }
    
    private double getMaxAngel(){
        return maxAngle;
    }
    
    //Set angle of the flatbed. Cannot go bellow 0 or above max angle
    protected void setAngle(double newAngle){
        if(newAngle > getMaxAngel()) {
            angle = maxAngle;
        }
        else if(newAngle < 0) {
            angle = 0;
        }
        else{
            angle = newAngle;
        }
    }
    
    public void raiseAngle(double var){ 
        setAngle(getAngle()+var);
    }

    public void lowerAngle(double var){
        setAngle(getAngle()-var);
    }
}
