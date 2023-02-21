package top.yonyong.opencv.test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import top.yonyong.opencv.utils.BinaryUtils;
import top.yonyong.opencv.utils.GeneralUtils;
import top.yonyong.opencv.utils.GrayUtils;
import top.yonyong.opencv.utils.RemoveNoiseUtils;

public class D_腐蚀和膨胀处理 {
    public static void main(String[] args) {
        // 这个必须要写,不写报java.lang.UnsatisfiedLinkError
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
