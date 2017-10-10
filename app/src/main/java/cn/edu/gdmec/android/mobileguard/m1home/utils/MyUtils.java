package cn.edu.gdmec.android.mobileguard.m1home.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.io.File;
import java.net.HttpRetryException;

/**
 * Created by zcr on 2017/9/27.
 */

public abstract class MyUtils {
    public  static  String getVersion(Context context){
        PackageManager packageManager=context.getPackageManager();
        try{
            PackageInfo packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            return  packageInfo.versionName;
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return "";
        }

    }
    public static void installApk(Activity activity){
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(new File("/mnt/sdcard/mobilesafe2.0apk")),"application/vnd.android.package-archive");
        activity.startActivityForResult(intent,0);
    }

    public abstract void onSuccess(ResolveInfo arg0);

    public abstract void onSuccess(ResolveInfo<File> arg0);

    public abstract void onLoadding(long total, long current, boolean isUploading);

    public abstract void onFailure(HttpRetryException arg0, String arg1);
}
