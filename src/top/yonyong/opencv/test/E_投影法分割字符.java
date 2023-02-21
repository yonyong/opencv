package top.yonyong.opencv.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import top.yonyong.opencv.utils.*;

import java.util.List;

/**
 * 投影法分割字符：二维投影到一维，根据一条线有无黑白分割切割
 */
public class E_投影法分割字符 {
    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        测试水平切割();
    }

    public static void 测试水平切割(){
        String imgPath = "E:\\mycode\\others\\opencv\\dist\\removeNoiseOrigin.png";
        String destPath = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        Mat src = GeneralUtils.matFactory(imgPath);
        src = GrayUtils.grayColByAdapThreshold(src);
        src = BinaryUtils.binaryzation(src);
        src = RemoveNoiseUtils.eghitRemoveNoise(src, 1);
        src = RemoveNoiseUtils.connectedRemoveNoise(src, 1.0);
        List<Mat> list = ImageOpencvUtils._cutImgX(src);
        for(int i = 0 ; i < list.size() ; i++) {
            ImageOpencvUtils.saveImg(list.get(i) , destPath + "X-" + i  + ".jpg");
        }
    }
}
