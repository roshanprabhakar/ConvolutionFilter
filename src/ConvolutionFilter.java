import java.awt.*;
import java.util.Arrays;

public class ConvolutionFilter {

    private int[][] image;
    private int[][] weights;
    private double[][] doubleWeights;

    private int[][] convolved;

    public ConvolutionFilter(int[][] image, int[][] weights) {

        this.image = image;
        this.weights = weights;

        convolve();
    }

    public void convolve() {

        int sum;
        int[][] convolved = new int[image.length][image[0].length];

        for (int r = 0; r < convolved.length - weights.length - 1; r++) {
            for (int c = 0; c < convolved[r].length - weights.length - 1; c++) {
                sum = 0;
                for (int i = 0; i < weights.length; i++) {
                    for (int j = 0; j < weights[i].length; j++) {
                        sum += image[r + i][c + j] * weights[i][j];
                    }
                }
                convolved[r][c] = sum / weight();
            }
        }

        this.convolved = convolved;
    }

    public int numWeights() {
        return weights.length * weights[0].length;
    }

    public int weight() {
        int sum = 0;
        for (int r = 0; r < weights.length; r++) {
            for (int c = 0; c < weights[r].length; c++) {
                sum += weights[r][c];
            }
        }
        if (sum == 0) return 1; else return sum;
    }

    public int[][] getConvolved() {
        return convolved;
    }

}
