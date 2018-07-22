/* eslint-disable import/no-unresolved */
import { NativeModules } from 'react-native';
/* eslint-enable import/no-unresolved */

const { RNDisplayCutout } = NativeModules;

/**
 * Constant for default mode
 * See https://developer.android.com/reference/android/R.attr#windowLayoutInDisplayCutoutMode
 * @type {Number}
 */
export const LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0;
export const LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1;
export const LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2;

/**
 * Sets layout if there is a cutout
 * @param  {Number} [mode=0]
 * @return {Function}
 * @throws {Error}
 */
export const layoutInDisplayCutoutMode = (mode = 0) => {
  if (mode >= 0 && mode <= 2) {
    return RNDisplayCutout.activate(mode);
  }

  throw new Error(`"${mode}" is not a valid value for parameter mode`);
};

/**
 * Gets bounding rectangles, if any
 * @return {Promise} Resolves to an empty array or an array of objects
 */
export const getBoundingRects = () => {
  RNDisplayCutout.getBoundingRects().then((rects) => {
    if (rects === null) {
      return [];
    }
    return rects;
  });
};

/**
 * Gets inset from the bottom which avoids the cutout
 * Represented as pixels
 * @return {Promise} Resolves to an integer
 */
export const getSafeInsetBottom = () => RNDisplayCutout.getSafeInsetBottom();

/**
 * Gets inset from the left which avoids the cutout
 * Represented as pixels
 * @return {Promise} Resolves to an integer
 */
export const getSafeInsetLeft = () => RNDisplayCutout.getSafeInsetLeft();

/**
 * Gets inset from the right which avoids the cutout
 * Represented as pixels
 * @return {Promise} Resolves to an integer
 */
export const getSafeInsetRight = () => RNDisplayCutout.getSafeInsetRight();

/**
 * Gets inset from the top which avoids the cutout
 * Represented as pixels
 * @return {Promise} Resolves to an integer
 */
export const getSafeInsetTop = () => RNDisplayCutout.getSafeInsetTop();
