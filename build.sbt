val sharedSettings = Seq(scalaVersion := "3.2.2")

lazy val core =
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Pure)
    .settings(sharedSettings)
    .settings(
      libraryDependencies ++= Seq(
        "dev.zio" %%% "zio" % "2.0.13",
        "dev.zio" %%% "zio-streams" % "2.0.13",
      )
    )

// Optional in sbt 1.x (mandatory in sbt 0.13.x)
lazy val coreJS     = core.js
lazy val coreJVM    = core.jvm
lazy val coreNative = core.native

lazy val runtime =
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Pure)
    .settings(sharedSettings)

// Optional in sbt 1.x (mandatory in sbt 0.13.x)
lazy val runtimeJS = runtime.js
lazy val runtimeJVM = runtime.jvm
lazy val runtimeNative = runtime.native

// runtimeJS.dependsOn(coreJS)
// runtimeJVM.dependsOn(coreJVM)
// runtimeNative.dependsOn(coreNative)
