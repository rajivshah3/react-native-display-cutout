
package com.rajivshah.devicecutout;

import android.support.annotation.NonNull;
import android.app.Activity;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Promise;

import java.io.IOException;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.lang.IllegalArgumentException;
import java.lang.Error;

public class RNDeviceCutoutModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final ReactApplicationContext baseContext;
  private final Activity activity;

  public RNDeviceCutoutModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.baseContext = getReactApplicationContext();
    this.activity = getCurrentActivity();
  }

  @Override
  public String getName() {
    return "RNDeviceCutout";
  }

  

}
