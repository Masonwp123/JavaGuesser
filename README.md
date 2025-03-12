# JavaGuesser
use 'make run' to run the standard version
use 'make runR' to run the recursive version

## Thoughts

- Need a printMenu method
- To get the computer to do a half algorithm, i could just assume a max and min possible from the high/low output, then guess halfway by doing (max + min) / 2
- I will also need input from the user
- The computers first guess is always 50
- Lowest and highest guess need to be recorded
- too low will use the previous guess as min and the highest guess or 100 as max
- too high will use the previous guess as max and the lowest guess or 1 as min
- if upper or lower is equal to guess than the player does not have a correct guess
- in the case of floating point values, it should be rounded to nearest value (for best guessing accuracy)
- can use some math to convert Math.Random() from 0-1 to 1-100
- Math.floor(Math.random() * 100) + 1 use cast to get an int

## Classes

### JavaGuesser.java

**static void main():**
```
static void main():
	make new JavaGuesser()
```

**JavaGuesser()**
```
JavaGuesser():
	make bool keepGoing
	set response to empty string
	while (keepGoing):
		call printMenu() put result in response
		if response is 0:
			set keepGoing to false
		elseif response is 1:
			call humanGuesser()
		elseif response is 2:
			call computerGuesser()
		else:
			print "Invalid Input, please try again"
	
```

**String printMenu()**
```
String printMenu():
	print "0) Exit"
	print "1) Human Guesser"
	print "2) Computer Guesser"
	make boolean keepGoing
	get input from player as choice
	return choice
```

**void humanGuesser()**
```
void humanGuesser():
	get random number between 1 and 100
	make int round as 1
	make bool keepGoing
	while (keepGoing):
		print round + ") Please Enter a number: "
		get player input as string
		convert player input to int
		if guess is geater than correct:
			print "too high!"
		elseif guess is less than correct:
			print "too low!"
		else:
			print "Correct!"
			set keepGoing to false
		add 1 to round

	if round is less than 7:
		print "Fantastic Job!"
	elseif round is 7:
		print "Well done."
	else:
		print "Maybe you should try again..."

```

**int getMean(int x, int y)**
```
int getMean(x, y):
	cast x + y to float to get true value
	return (float)(x + y) / 2 round to nearest int
```

**void computerGuesser()**
```
void computerGuesser():
	
	make int lower as 1
	make int upper as 100
	make int guess using getMean(lower, upper)
	make int round as 1
	make bool keepGoing
	while (keepGoing):
		print round + ") Too (H)igh, too (L)ow, or (C)orrect?"
		get player input as lowercase string
		if input is "h":
			set upper to guess
			set guess using getMean(lower, upper)
		elseif input is "l":
			set lower to guess
			set guess using getMean(lower, upper)
		elseif input is "c":
			keepGoing = false
		else:
			print "Invalid Input"
		if upper is equal to guess or lower is equal to guess:
			print "There is no correct answer"
			keepGoing = false
		add 1 to round
		
```
