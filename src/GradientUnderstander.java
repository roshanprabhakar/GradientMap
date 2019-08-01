import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GradientUnderstander {

    public static void main(String... args) throws InterruptedException {
        try {
            BufferedImage image = ImageIO.read(new File("gradient.png"));

//            for (int r = 0; r < image.getHeight(); r++) {
////                System.out.println(image.getRGB(0, r));
//                System.out.println(r);
//            }

//            System.out.println(image.getHeight() - 769);

            String map = "const map = new Map([";
            for (int r = 0; r < 77; r++) {
                int row = r * (image.getHeight() / 77);
//                System.out.println("r: " + r + " row: " + row + " @ " + image.getRGB(0, row));
//                System.out.println(image.getRGB(0, row));
                map += "[" + (r + 1) + ", " + image.getRGB(0, row) + "], ";
                displayColor(image.getRGB(0, row));
            }
            map += "]);";
            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayColor(int color) throws InterruptedException {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        for (int r = 0; r < image.getHeight(); r++) {
            for (int c = 0; c < image.getWidth(); c++) {
                image.setRGB(c, r, color);
            }
        }
        JFrame frame = new JFrame("color: " + color);
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(10);
        frame.setVisible(false);

    }
}
