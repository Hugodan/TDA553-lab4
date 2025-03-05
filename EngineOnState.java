public class EngineOnState implements EngineState {
    @Override
    public void startEngine(Car car) {
        //Engine is on already
    }

    @Override
    public void stopEngine(Car car) {
        car.setEngineState(new EngineOffState());
        car.engineOn = false;
    }
}

