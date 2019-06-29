import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ImageProcessor {

    private BufferedImage image;
    int[][] convolutionFilter;

    public ImageProcessor(BufferedImage image, int[][] convolutionFilter) {
        this.image = image;
        this.convolutionFilter = convolutionFilter;
    }

    public void apply() {
        int[][] image = new int[this.image.getHeight()][this.image.getWidth()];
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = this.image.getRGB(c, r);
            }
        }
        ConvolutionFilter filter = new ConvolutionFilter(image, convolutionFilter);
        int[][] convolved = filter.getConvolved();
        for (int r = 0; r < convolved.length; r++) {
            for (int c = 0; c < convolved[r].length; c++) {
                this.image.setRGB(c, r, convolved[r][c]);
            }
        }
    }

    public void display() {
        JFrame frame = new JFrame("convolution filter");
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}
