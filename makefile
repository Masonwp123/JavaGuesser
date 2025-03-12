JavaGuesser.class: JavaGuesser.java
	javac -g JavaGuesser.java

clean:
	rm *.class

run: JavaGuesser.class
	java JavaGuesser

debug: JavaGuesser.class
	jdb JavaGuesser
