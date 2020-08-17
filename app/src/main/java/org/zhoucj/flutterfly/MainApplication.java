package org.zhoucj.flutterfly;

import android.app.Application;
import android.content.pm.PackageInfo;

import com.zhoucj.flutterfly.flutterplugin.FlutterpluginService;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;


/**
 * @author changjin.zhou
 * @since 2020-08-14
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Instantiate a FlutterEngine.
        FlutterEngine flutterEngine = new FlutterEngine(this);
        // Configure an initial route.
        flutterEngine.getNavigationChannel().setInitialRoute("/");
        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        // Cache the FlutterEngine to be used by FlutterActivity or FlutterFragment.
        FlutterEngineCache.getInstance().put("my_engine_id", flutterEngine);

        try {
            PackageInfo pi = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            FlutterpluginService.getInstance().setAppVersion(pi.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
