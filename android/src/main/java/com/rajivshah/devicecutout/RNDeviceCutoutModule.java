
package com.rajivshah.devicecutout;

import android.view.WindowManager.LayoutParams;
import android.view.DisplayCutout;
import android.graphics.Rect;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Promise;

public class RNDeviceCutoutModule extends ReactContextBaseJavaModule {

  public RNDeviceCutoutModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNDeviceCutout";
  }

  /**
   * Sets mode to default (0)
   * See https://developer.android.com/reference/android/R.attr#windowLayoutInDisplayCutoutMode
   * @param promise
   */
  @ReactMethod
  public void layoutInDisplayCutoutMode(final Promise promise) {
    try {
      LayoutParams.layoutInDisplayCutoutMode();
      promise.resolve();
    } catch(Exception e) {
      promise.reject(e);
    }
  }

  /**
   * Sets mode
   * See https://developer.android.com/reference/android/R.attr#windowLayoutInDisplayCutoutMode
   * @param mode
   * @param promise
   */
  @ReactMethod
  public void layoutInDisplayCutoutMode(final int mode, final Promise promise) {
    try {
      LayoutParams.layoutInDisplayCutoutMode(mode);
      promise.resolve();
    } catch(Exception e) {
      promise.reject(e);
    }
  }

  /**
   * Gets bounding rectangles for non-functional areas on the display
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getBoundingRects()
   * @param promise
   */
  @ReactMethod
  public void getBoundingRects(final Promise promise) {
    List<Rect> rects = DisplayCutout.getBoundingRects();
    if (rects.isEmpty()) {
      promise.resolve(null);
    } else {
      WritableArray rectsArray = new WritableNativeArray();
      for (Rect rect : rects) {
        WritableMap rectangle = new WritableNativeMap();
        rectangle.putInt("top", rect.top);
        rectangle.putInt("bottom", rect.bottom);
        rectangle.putInt("left", rect.left);
        rectangle.putInt("right", rect.right);
        rectsArray.pushMap(rectangle);
      }
      promise.resolve(rectsArray);
    }
  }

  /**
   * Gets inset from the bottom which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetBottom()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetBottom(final Promise promise) {
    promise.resolve(DisplayCutout.getSafeInsetBottom());
  }

  /**
   * Gets inset from the left which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetLeft()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetLeft(final Promise promise) {
    promise.resolve(DisplayCutout.getSafeInsetLeft());
  }

  /**
   * Gets inset from the right which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetRight()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetRight(final Promise promise) {
    promise.resolve(DisplayCutout.getSafeInsetRight());
  }

  /**
   * Gets inset from the top which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetTop()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetTop(final Promise promise) {
    promise.resolve(DisplayCutout.getSafeInsetTop());
  }

}
