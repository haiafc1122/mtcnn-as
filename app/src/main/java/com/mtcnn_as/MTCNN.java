package com.mtcnn_as;

/**
 * Created by hasee on 2017/12/19.
 */

public class MTCNN{
    //Face detection model import
    public native boolean FaceDetectionModelInit(String faceDetectionModelPath);

    //Face Detection
    public native int[] FaceDetect(byte[] imageDate, int imageWidth , int imageHeight, int imageChannel);

    public native int[] MaxFaceDetect(byte[] imageDate, int imageWidth , int imageHeight, int imageChannel);

    //Face detection model de-initialization
    public native boolean FaceDetectionModelUnInit();

    //Minimum face detection setting
    public native boolean SetMinFaceSize(int minSize);

    //Thread settings
    public native boolean SetThreadsNumber(int threadsNumber);

    //Cycle test times
    public native boolean SetTimeCount(int timeCount);

    static {
        System.loadLibrary("mtcnn");
    }
}
