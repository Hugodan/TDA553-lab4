import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarEventHandler {
    private CarController carC;
    private CarView carUI;

    public CarEventHandler(CarController carC, CarView carUI) {
        this.carC = carC;
        this.carUI = carUI;
        attachListeners();
    }

    private void attachListeners(){
        carUI.getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
        
        
        carUI.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(carUI.getGasAmount());
            }
        });

        carUI.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(carUI.getGasAmount());
            }
        });

        carUI.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });

        carUI.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        carUI.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.raiseFlatbed(70);
            }
        });

        carUI.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerFlatbed(0);
            }
        });

        carUI.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startEngine();
            }
        });

        carUI.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopEngine();
            }
        });
    }
}