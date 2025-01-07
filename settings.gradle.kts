rootProject.name = "demo"

/**
 * build.gradle.kts 的 plugins里的version现在无法引用properties
 * 先暂时在 settings 用 pluginManagement 来管理插件的版本（参考： https://github.com/gradle/gradle/issues/9830)
 */
pluginManagement {

    plugins {}

}