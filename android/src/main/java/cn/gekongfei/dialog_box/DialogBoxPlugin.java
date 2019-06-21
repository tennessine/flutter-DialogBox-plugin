package cn.gekongfei.dialog_box;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** DialogBoxPlugin */
public class DialogBoxPlugin implements MethodCallHandler {
  Activity context;
  MethodChannel methodChannel;

  public DialogBoxPlugin(Activity context, MethodChannel methodChannel) {
    this.context = context;
    this.methodChannel = methodChannel;
    this.methodChannel.setMethodCallHandler(this);
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "dialog_box");
    channel.setMethodCallHandler(new DialogBoxPlugin(registrar.activity(), channel));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + Build.VERSION.RELEASE);
    } else if (call.method.equalsIgnoreCase("showAlertDialog")) {
      Dialog dialog = new Dialog(context);
      dialog.setTitle("Hi, My Name is Flutter");
      dialog.show();
    } else {
      result.notImplemented();
    }
  }
}
