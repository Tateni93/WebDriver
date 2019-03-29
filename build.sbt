name := "WebDriver"
organization:="Tateni93"
version := "0.1"
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium"     %  "selenium-support"        % "3.9.1",
  "org.seleniumhq.selenium"     % "selenium-java"            % "3.6.0",
  "com.typesafe.play"          %%  "play-json"               % "2.5.12",
  "org.scalatest"              %%  "scalatest"               % "3.0.5"   % "test",
  "org.pegdown"                 % "pegdown"                  % "1.6.0"   % "test",
  "info.cukes"                 %% "cucumber-scala"           % "1.2.5"   % "test",
  "io.cucumber"                  % "cucumber-junit"           % "2.0.0",
  "info.cukes"                  % "cucumber-picocontainer"   % "1.2.5"   % "test",
  "junit"                       % "junit"                    % "4.12"    % "test",
  "com.novocode"                % "junit-interface"          % "0.11"    % "test",
  "ch.qos.logback"              % "logback-classic"          % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging"            % "3.8.0"
)