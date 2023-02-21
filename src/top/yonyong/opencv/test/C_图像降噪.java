package top.yonyong.opencv.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import top.yonyong.opencv.utils.BinaryUtils;
import top.yonyong.opencv.utils.GeneralUtils;
import top.yonyong.opencv.utils.GrayUtils;
import top.yonyong.opencv.utils.RemoveNoiseUtils;

public class C_图像降噪 {
    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        测试连通域降噪();
    }

    /**
     * 即9宫格中心被异色包围，则同化
     */
    public static void 测试8邻域降噪(){
        String imgPath = "E:\\mycode\\others\\opencv\\dist\\removeNoiseOrigin.png";
        String destPath = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        Mat src = GeneralUtils.matFactory(imgPath);
        src = GrayUtils.grayColByPartAdapThreshold(src);
        src = BinaryUtils.binaryzation(src);
        // 8邻域降噪
        src = RemoveNoiseUtils.eghitRemoveNoise(src , 1);

        GeneralUtils.saveImg(src , destPath + "eghitRemoveNoise.png");
    }


    public static void 测试连通域降噪(){
        String imgPath = "E:\\mycode\\others\\opencv\\dist\\removeNoiseOrigin.png";
        String destPath = "E:\\mycode\\others\\opencv\\dist\\temp\\";

        Mat src = GeneralUtils.matFactory(imgPath);
        src = GrayUtils.grayColByPartAdapThreshold(src);
        src = BinaryUtils.binaryzation(src);
        // 连通域降噪
        src = RemoveNoiseUtils.connectedRemoveNoise(src , 1);

        GeneralUtils.saveImg(src , destPath + "connectedRemoveNoise.png");
    }
}
