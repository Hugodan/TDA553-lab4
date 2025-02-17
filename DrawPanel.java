import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private static class CarImage {
        
        BufferedImage image;
        Point position;

        CarImage(String imagePath, int x, int y) {
            try {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
                position = new Point(x, y);
            } catch (IOException | NullPointerException e) {
                System.err.println("Error loading image: " + imagePath);
                e.printStackTrace();
            }
        }
    }

    private final List<CarImage> carImages = new ArrayList<>();
    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(300, 300);



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        carImages.add(new CarImage("pics/Volvo240.jpg", 0, 0));
        carImages.add(new CarImage("pics/Saab95.jpg", 0, 100));
        carImages.add(new CarImage("pics/Scania.jpg", 0, 200));

        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading workshop image.");
            e.printStackTrace();
        }

    }

    public void moveit(int index, int x, int y) {
        if (index >= 0 && index < carImages.size()) {
            carImages.get(index).position.setLocation(x, y);
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CarImage car : carImages) {
            if (car.image != null) {
                g.drawImage(car.image, car.position.x, car.position.y, null);
            }
        }

        // Draw the workshop image
        if (volvoWorkshopImage != null) {
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }
    }
}
