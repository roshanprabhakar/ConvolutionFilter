
//Convolution kernels can only be squares
public class ConvolutionFilter {

    private short[][] kernel;
    private int weight;
    int totalBits;

    public int getWeight() {
        return weight;
    }

    public short[][] getKernel() {
        return kernel;
    }

    public ConvolutionFilter(short[][] kernel) {
        this.kernel = kernel;

        int sum = 0;
        totalBits = 0;

        for (int r = 0; r < kernel.length; r++) {
            for (int c = 0; c < kernel[r].length; c++) {
                sum += kernel[r][c];
                totalBits++;
            }
        }

        if (sum == 0) sum++;
        this.weight = sum;
    }

    public int[][] convolve(int[][] img) {

        int[][] out = deepClone(img);

        int pixelSum, kernelVal, pixelVal;

        for (int r = 0; r < img.length - kernel.length; r++) {
            for (int c = 0; c < img[r].length - kernel.length; c++) {

                pixelSum = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        kernelVal = kernel[i][j];
                        pixelVal = img[r + i][c + j];
                        pixelSum += kernelVal * pixelVal;
                    }
                }
                if (pixelSum < 0) {
                    pixelSum = 0;
                }
                pixelSum /= this.weight;
                out[r][c] = pixelSum;
            }
        }
        return out;
    }

    private int[][] deepClone(int[][] img) {
        int[][] out = img.clone();
        for (int r = 0; r < img.length; r++) {
            out[r] = img[r].clone();
        }
        return out;
    }
}
