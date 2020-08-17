package com.zhoucj.flutterfly.flutterplugin;

/**
 * @author changjin.zhou
 * @since 2020-08-17
 */
public class FlutterpluginService {

    private static volatile FlutterpluginService mInstance = null;

    private String appVersion = "";

    private FlutterpluginService() {
    }

    public static FlutterpluginService getInstance() {
        if (mInstance == null) {
            synchronized (FlutterpluginService.class) {
                if (mInstance == null) {
                    mInstance = new FlutterpluginService();
                }
            }
        }

        return mInstance;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
