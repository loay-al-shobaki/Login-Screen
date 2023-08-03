[33mcommit d4e65e3894ae31f911caa65171ef91421cb598d8[m[33m ([m[1;36mHEAD -> [m[1;32msachin/architecture[m[33m)[m
Author: Loay Al Shobaki <107764558+loay-al-shobaki@users.noreply.github.com>
Date:   Tue Aug 1 10:28:21 2023 +0300

    Pushing all the files in git

[1mdiff --git a/.gitignore b/.gitignore[m
[1mnew file mode 100644[m
[1mindex 0000000..aa724b7[m
[1m--- /dev/null[m
[1m+++ b/.gitignore[m
[36m@@ -0,0 +1,15 @@[m
[32m+[m[32m*.iml[m
[32m+[m[32m.gradle[m
[32m+[m[32m/local.properties[m
[32m+[m[32m/.idea/caches[m
[32m+[m[32m/.idea/libraries[m
[32m+[m[32m/.idea/modules.xml[m
[32m+[m[32m/.idea/workspace.xml[m
[32m+[m[32m/.idea/navEditor.xml[m
[32m+[m[32m/.idea/assetWizardSettings.xml[m
[32m+[m[32m.DS_Store[m
[32m+[m[32m/build[m
[32m+[m[32m/captures[m
[32m+[m[32m.externalNativeBuild[m
[32m+[m[32m.cxx[m
[32m+[m[32mlocal.properties[m
[1mdiff --git a/.idea/.gitignore b/.idea/.gitignore[m
[1mnew file mode 100644[m
[1mindex 0000000..26d3352[m
[1m--- /dev/null[m
[1m+++ b/.idea/.gitignore[m
[36m@@ -0,0 +1,3 @@[m
[32m+[m[32m# Default ignored files[m
[32m+[m[32m/shelf/[m
[32m+[m[32m/workspace.xml[m
[1mdiff --git a/.idea/.name b/.idea/.name[m
[1mnew file mode 100644[m
[1mindex 0000000..34dfa8a[m
[1m--- /dev/null[m
[1m+++ b/.idea/.name[m
[36m@@ -0,0 +1 @@[m
[32m+[m[32mLogin Screen[m
\ No newline at end of file[m
[1mdiff --git a/.idea/compiler.xml b/.idea/compiler.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b589d56[m
[1m--- /dev/null[m
[1m+++ b/.idea/compiler.xml[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="CompilerConfiguration">[m
[32m+[m[32m    <bytecodeTargetLevel target="17" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/gradle.xml b/.idea/gradle.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..4dcd98f[m
[1m--- /dev/null[m
[1m+++ b/.idea/gradle.xml[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="GradleMigrationSettings" migrationVersion="1" />[m
[32m+[m[32m  <component name="GradleSettings">[m
[32m+[m[32m    <option name="linkedExternalProjectsSettings">[m
[32m+[m[32m      <GradleProjectSettings>[m
[32m+[m[32m        <option name="testRunner" value="GRADLE" />[m
[32m+[m[32m        <option name="distributionType" value="DEFAULT_WRAPPED" />[m
[32m+[m[32m        <option name="externalProjectPath" value="$PROJECT_DIR$" />[m
[32m+[m[32m        <option name="gradleHome" value="$PROJECT_DIR$/../android studio gradle/gradle-8.0.2-all/gradle-8.0.2" />[m
[32m+[m[32m        <option name="gradleJvm" value="jbr-17" />[m
[32m+[m[32m        <option name="modules">[m
[32m+[m[32m          <set>[m
[32m+[m[32m            <option value="$PROJECT_DIR$" />[m
[32m+[m[32m            <option value="$PROJECT_DIR$/app" />[m
[32m+[m[32m          </set>[m
[32m+[m[32m        </option>[m
[32m+[m[32m      </GradleProjectSettings>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/inspectionProfiles/Project_Default.xml b/.idea/inspectionProfiles/Project_Default.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..44ca2d9[m
[1m--- /dev/null[m
[1m+++ b/.idea/inspectionProfiles/Project_Default.xml[m
[36m@@ -0,0 +1,41 @@[m
[32m+[m[32m<component name="InspectionProjectProfileManager">[m
[32m+[m[32m  <profile version="1.0">[m
[32m+[m[32m    <option name="myName" value="Project Default" />[m
[32m+[m[32m    <inspection_tool class="PreviewAnnotationInFunctionWithParameters" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewApiLevelMustBeValid" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewDimensionRespectsLimit" enabled="true" level="WARNING" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewFontScaleMustBeGreaterThanZero" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewMultipleParameterProviders" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewMustBeTopLevelFunction" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewNeedsComposableAnnotation" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewNotSupportedInUnitTestFiles" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m    <inspection_tool class="PreviewPickerAnnotation" enabled="true" level="ERROR" enabled_by_default="true">[m
[32m+[m[32m      <option name="composableFile" value="true" />[m
[32m+[m[32m      <option name="previewFile" value="true" />[m
[32m+[m[32m    </inspection_tool>[m
[32m+[m[32m  </profile>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/kotlinc.xml b/.idea/kotlinc.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..e1eea1d[m
[1m--- /dev/null[m
[1m+++ b/.idea/kotlinc.xml[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="KotlinJpsPluginSettings">[m
[32m+[m[32m    <option name="version" value="1.7.20" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..8978d23[m
[1m--- /dev/null[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -0,0 +1,9 @@[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="ExternalStorageConfigurationManager" enabled="true" />[m
[32m+[m[32m  <component name="ProjectRootManager" version="2" languageLevel="JDK_17" default="true" project-jdk-name="jbr-17" project-jdk-type="JavaSDK">[m
[32m+[m[32m    <output url="file://$PROJECT_DIR$/build/classes" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="ProjectType">[m
[32m+[m[32m    <option name="id" value="Android" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/vcs.xml b/.idea/vcs.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..94a25f7[m
[1m--- /dev/null[m
[1m+++ b/.idea/vcs.xml[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32m<?xml version="1.0"