JavaGuesser.class: JavaGuesser.java
	javac -g JavaGuesser.java

JavaGuesserRecursive.class: JavaGuesserRecursive.java
	javac -g JavaGuesserRecursive.java

clean:
	rm *.class

run: JavaGuesser.class
	java JavaGuesser

runR: JavaGuesserRecursive.class
	java JavaGuesserRecursive

debug: JavaGuesser.class
	jdb JavaGuesser
