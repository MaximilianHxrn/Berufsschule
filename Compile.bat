javac MainClass.java
jar cfm MainClass.jar manifest.txt *.class
Remove-Item -path ".\*.class"