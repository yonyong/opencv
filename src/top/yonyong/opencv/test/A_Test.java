package top.yonyong.opencv.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

/**
 * opencv 初体验
 */
public class A_Test {

    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File imgFile = new File("E:\\mycode\\others\\opencv\\dist\\img1.jpg");
        String dest = "E:\\desktop\\opencv";
        Mat src = Imgcodecs.imread(imgFile.toString(), Imgcodecs.IMREAD_GRAYSCALE);

        Mat dst = new Mat();

        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold" + imgFile.getName(), dst);
    }
}
