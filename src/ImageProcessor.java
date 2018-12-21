import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcessor {
    private String path;
    private BufferedImage image;

    public ImageProcessor(String path) {
        this.path = path;
        this.image = loadImageFromFile(path);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void loadImage(BufferedImage image) {
        this.image = image;
    }

    public void display(int width, int height) {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(resize(image, width, height))));
        frame.pack();
        frame.setVisible(true);
    }

    public int[][] getRGBarray() {
        int[][] out = new int[image.getHeight()][image.getWidth()];
        for (int r = 0; r < image.getHeight(); r++) {
            for (int c = 0; c < image.getWidth(); c++) {
                out[r][c] = image.getRGB(c, r);
            }
        }
        return out;
    }

    public void setRGBvalues(int[][] rgbValues) {
        for (int r = 0; r < rgbValues.length; r++) {
            for (int c = 0; c < rgbValues[r].length; c++) {
                image.setRGB(c, r, rgbValues[r][c]);
            }
        }
    }

    private BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private BufferedImage loadImageFromFile(String filepath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filepath));
        } catch (Exception e) {
            System.err.println("Error while loading image from file");
        }
        return image;
    }
}
