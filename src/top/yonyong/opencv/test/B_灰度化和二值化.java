package top.yonyong.opencv.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import top.yonyong.opencv.utils.BinaryUtils;

import java.io.File;

public class B_灰度化和二值化 {
    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        openCv自带二值化测试();
    }

    public static void 灰度化测试1(){
        File imgFile = new File("E:\\mycode\\others\\opencv\\dist\\img1.jpg");
        String dest = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        Mat src = Imgcodecs.imread(imgFile.toString(), Imgcodecs.IMREAD_GRAYSCALE);
        Imgcodecs.imwrite(dest + "/toGray" + imgFile.getName(), src);
    }

    public static void 灰度化测试2(){
        File imgFile = new File("E:\\mycode\\others\\opencv\\dist\\img1.jpg");
        String dest = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        //方式二
        Mat src = Imgcodecs.imread(imgFile.toString());
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        src = gray;
        //保存灰度化的图片
        Imgcodecs.imwrite(dest + "/toGray2" + imgFile.getName(), src);
    }

    public static void 二值化测试1(){
        File imgFile = new File("E:\\mycode\\others\\opencv\\dist\\img1.jpg");
        String dest = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        //先经过一步灰度化
        Mat src = Imgcodecs.imread(imgFile.toString());
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        src = gray;
        //二值化
        BinaryUtils.binaryzation(src);
        Imgcodecs.imwrite(dest + "/binaryzation" + imgFile.getName(), src);
    }

    public static void openCv自带二值化测试(){
        File imgFile = new File("E:\\mycode\\others\\opencv\\dist\\img1.jpg");
        String dest = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        Mat src = Imgcodecs.imread(imgFile.toString(), Imgcodecs.IMREAD_GRAYSCALE);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold1" + imgFile.getName(), src);

        Mat dst = new Mat();
        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold2" + imgFile.getName(), dst);

        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold3" + imgFile.getName(), dst);

        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold4" + imgFile.getName(), dst);

        Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY_INV, 13, 5);
        Imgcodecs.imwrite(dest + "/AdaptiveThreshold5" + imgFile.getName(), dst);
    }
}
