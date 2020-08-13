# What is the UVC Camera Example App?

This is an example application that demonstrates how to use the methods from the UVC Camera library to interact with an external camera.

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
