plugins {
  java
  application
  id("org.hypertrace.docker-java-application-plugin")
  id("org.hypertrace.docker-publish-plugin")
}

dependencies {
  implementation(platform(project(":hypertrace-core-graphql-platform")))

  implementation("com.typesafe:config")
  implementation("org.hypertrace.core.serviceframework:platform-service-framework:0.1.20")
  implementation("org.slf4j:slf4j-api")

  implementation("org.eclipse.jetty:jetty-server:9.4.36.v20210114")
  implementation("org.eclipse.jetty:jetty-servlet:9.4.36.v20210114")
  implementation("org.eclipse.jetty:jetty-servlets:9.4.36.v20210114")

  implementation("com.graphql-java-kickstart:graphql-java-servlet")
  implementation(project(":hypertrace-core-graphql-impl"))
  implementation(project(":hypertrace-core-graphql-spi"))

  runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl")
}

application {
  mainClassName = "org.hypertrace.core.serviceframework.PlatformServiceLauncher"
}
tasks.run<JavaExec> {
  jvmArgs = listOf("-Dservice.name=${project.name}")
}
