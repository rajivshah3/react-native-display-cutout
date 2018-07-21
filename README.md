
# DeviceCutout for React Native

[![GitHub version](https://badge.fury.io/gh/rajivshah3%2Freact-native-device-cutout.svg)](https://badge.fury.io/gh/rajivshah3%2Freact-native-device-cutout) [![Maintainability](https://api.codeclimate.com/v1/badges/dfa536260a3131540826/maintainability)](https://codeclimate.com/github/rajivshah3/react-native-device-cutout/maintainability) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/de3c4e6e440f4cdf93492ddd5b41ace1)](https://app.codacy.com/app/rajivshah3/react-native-device-cutout?utm_source=github.com&utm_medium=referral&utm_content=rajivshah3/react-native-device-cutout&utm_campaign=badger)

## Getting started

`$ npm install react-native-device-cutout --save`

or

`$ yarn add react-native-device-cutout`

### Mostly automatic installation

`$ react-native link react-native-device-cutout`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.rajivshah.devicecutout.RNDeviceCutoutPackage;` to the imports at the top of the file
  - Add `new RNDeviceCutoutPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-device-cutout'
  	project(':react-native-device-cutout').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-device-cutout/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-device-cutout')
  	```


## Usage

See the full documentation [here](https://rajivshah3.github.io/react-native-device-cutout/)

```javascript
import RNDeviceCutout from 'react-native-device-cutout';

// TODO: What to do with the module?
```
