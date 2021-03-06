@echo off

rem ----------------------------------------------------------------------
rem ----- Customizable Variables -----------------------------------------
rem ----------------------------------------------------------------------
rem set JAVA_HOME=
set LIGHT_HOME=%~dp0\..
set LIGHT_CONFIG=%LIGHT_HOME%\..\config\light.conf
set LIGHT_LOG_CONFIG=%LIGHT_HOME%\..\config\log4j2.xml
rem ----------------------------------------------------------------------

rem ----------------------------------------------------------------------
rem ----- Do not touch below this line!-----------------------------------
rem ----------------------------------------------------------------------
rem cd %LIGHT_HOME%
set PATH=%JAVA_HOME%\bin;%PATH%
set JAVA_OPTS=
set JAVA_OPTS=%JAVA_OPTS% -javaagent:%LIGHT_HOME%\light.agent-0.0.1.jar
set JAVA_OPTS=%JAVA_OPTS% -Xms256m -Xmx512m
set JAVA_OPTS=%JAVA_OPTS% -Dlight.config=%LIGHT_CONFIG%
set JAVA_OPTS=%JAVA_OPTS% -Dlog4j.configurationFile=%LIGHT_LOG_CONFIG%
rem --- use chcp command
rem set JAVA_OPTS=%JAVA_OPTS% -Dfile.encoding=UTF-8

if "%1"=="start" (
start cmd /c call light-demo.bat run
) else if "%1"=="run" (
title Light Demo
java %JAVA_OPTS% -jar light.demo-0.0.1.jar start
PAUSE
) else if "%1"=="stop" (
java %JAVA_OPTS% -jar light.demo-0.0.1.jar stop
) else (
echo Usage: light-demo [command]
echo Available command : start, stop
)
