import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel implements Observer {
    private static class CarImage {
        BufferedImage image;
        Car car;
        Point position;
        CarImage(String imagePath, Car car) {
            try {
                System.out.println("Loading image from: " + imagePath);
                image = ImageIO.read(getClass().getResource(imagePath));
                if(image == null) {
                    System.out.println(" Image not found at: " + imagePath);
                } else {
                    System.out.println(" Image loaded successfully: " + imagePath);
                }
                position = new Point((int) car.getPosX(), (int) car.getPosY());
                this.car = car;
            } catch (IOException | NullPointerException e) {
                System.err.println("Error loading image: " + imagePath);
                e.printStackTrace();
            }
        }
    }
    private final CarController carController;
    private final List<CarImage> carImages = new ArrayList<>();
    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(0, 400);
    public DrawPanel(CarController carController, int x, int y) {
        this.carController = carController;
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(x, y));
        setBackground(Color.green);
        carController.addObserver(this);
        for (Car car : carController.getCars()) {
            String imagePath = getCarImagePath(car);
            carImages.add(new CarImage(imagePath, car));
        }
        try {
            volvoWorkshopImage = ImageIO.read(getClass().getResource("/pics/VolvoBrand.jpg"));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private String getCarImagePath(Car car) {
        if (car instanceof Volvo240) return "/pics/Volvo240.jpg";
        if (car instanceof Saab95) return "/pics/Saab95.jpg";
        if (car instanceof Scania) return "/pics/Scania.jpg";
        return "/pics/default.jpg";
    }
    public void removeCar(Car car) {
        carImages.removeIf(carImage -> carImage.car.equals(car));
        repaint();
    }
    @Override
    public void update() {
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Car> cars = carController.getCars();
        for (int i = 0; i < Math.min(cars.size(), carImages.size()); i++) {
            Car car = cars.get(i);
            CarImage carImage = carImages.get(i);
            carImage.position.setLocation(car.getPosX(), car.getPosY());
            g.drawImage(carImage.image, carImage.position.x, carImage.position.y, null);
        }
        if (volvoWorkshopImage != null) {
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }
    }
}
