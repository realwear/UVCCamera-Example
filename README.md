# What is the UVC Camera Example App?

This is an example application that demonstrates how to use the methods from the UVC Camera library to interact with an external camera.

The preview format used here is supported by the thermal camera available through RealWear, and other USB cameras may require other format types.

# What is the UVC Camera Library?

This library allows access to a UVC camera from an Android device.

The version we're using in this project has an added format for our thermal camera, but the original library can be found [here](https://github.com/saki4510t/UVCCamera) authored by t_saki@serenegiant.com under an Apache license. For more sample projects and information about the use of this library, please see the original repository.

# JitPack

The UVC Camera library is currently hosted on JitPack.

To install the library into your project add the JitPack repository to your root build.gradle file, at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

And add the dependency in your apps build.gradle file:

```
dependencies {
     implementation 'com.realwear.UVCCamera:libuvccamera:v1.0.0'
}
```
