public class ConvolutionLib {

    public static final int[][] identity = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    public static final int[][] sharpenFilter = new int[][]{
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
    };

    public static final int[][] blurFilter = new int[][]{
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, 8, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
    };

    public static final int[][] edgeFilter = new int[][]{
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
    };

    public static final int[][] mitigatedEdgeFilter = new int[][] {
            {0,1,0},
            {1,-4,1},
            {0,1,0}
    };


}
