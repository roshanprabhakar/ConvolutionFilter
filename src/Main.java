public class Main {

    public static void main(String[] args) {

        ConvolutionFilter filter = new ConvolutionFilter(
                new short[][]{
                        {-1,0,1},
                        {-1,0,1},
                        {-1,0,1},
                }
        );

        ImageProcessor imageProcessor = new ImageProcessor("convolutionTest.jpg");

        int[][] array = imageProcessor.getRGBarray();
        array = filter.convolve(array);
        imageProcessor.setRGBvalues(array);
        imageProcessor.display(1000, 1200);
    }
}
