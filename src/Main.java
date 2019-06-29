import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("sketch.jpg"));
            ImageProcessor processor = new ImageProcessor(image, ConvolutionLib.identity);

            //alter processor

            processor.apply();
            processor.display();


        } catch (IOException e) {
            System.err.println("Could not read image file!");
        }
    }
}
