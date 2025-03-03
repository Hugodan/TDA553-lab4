

public class CarEventHandler {
    private final CarController carController;
    private final CarView carUI;

    public CarEventHandler(CarController carController, CarView carUI) {
        this.carController = carController;
        this.carUI = carUI;
        attachListeners();
    }

    private void attachListeners() {
        carUI.getGasButton().addActionListener(e -> carController.gas(carUI.getGasAmount()));
        carUI.getBrakeButton().addActionListener(e -> carController.brake(carUI.getGasAmount()));
        carUI.getTurboOnButton().addActionListener(e -> carController.turboOn());
        carUI.getTurboOffButton().addActionListener(e -> carController.turboOff());
        carUI.getLiftBedButton().addActionListener(e -> carController.raiseFlatbed(70));
        carUI.getLowerBedButton().addActionListener(e -> carController.lowerFlatbed(0));
        carUI.getStartButton().addActionListener(e -> carController.startEngine());
        carUI.getStopButton().addActionListener(e -> carController.stopEngine());
    }
}
