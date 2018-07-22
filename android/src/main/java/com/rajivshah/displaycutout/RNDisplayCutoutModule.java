
package com.rajivshah.displaycutout;

import android.view.Window;
import android.view.WindowInsets;
import android.view.View;
import android.app.Activity;
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

import java.util.List;

public class RNDisplayCutoutModule extends ReactContextBaseJavaModule {
  private WindowInsets insets;
  private DisplayCutout displayCutout;

  public RNDisplayCutoutModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNDisplayCutout";
  }

  /**
   * Sets mode
   * See https://developer.android.com/reference/android/R.attr#windowLayoutInDisplayCutoutMode
   * @param mode
   * @param promise
   */
  @ReactMethod
  public void activate(final int mode) {
      final Activity activity = getCurrentActivity();
      if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    LayoutParams params = new LayoutParams();
                    params.layoutInDisplayCutoutMode = mode;
                    activity.getWindow().setAttributes(params);
                }
            });
        }
  }

  /**
   * Gets bounding rectangles for non-functional areas on the display
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getBoundingRects()
   * @param promise
   */
  @ReactMethod
  public void getBoundingRects(final Promise promise) {
    List<Rect> rects = displayCutout.getBoundingRects();
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
    promise.resolve(displayCutout.getSafeInsetBottom());
  }

  /**
   * Gets inset from the left which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetLeft()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetLeft(final Promise promise) {
    promise.resolve(displayCutout.getSafeInsetLeft());
  }

  /**
   * Gets inset from the right which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetRight()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetRight(final Promise promise) {
    promise.resolve(displayCutout.getSafeInsetRight());
  }

  /**
   * Gets inset from the top which avoids the cutout
   * Represented as pixels
   * See https://developer.android.com/reference/android/view/DisplayCutout.html#getSafeInsetTop()
   * @param promise
   */
  @ReactMethod
  public void getSafeInsetTop(final Promise promise) {
    promise.resolve(displayCutout.getSafeInsetTop());
  }

  public void onApplyWindowInsets(WindowInsets insets) {
    displayCutout = insets.getDisplayCutout();
  }

}
