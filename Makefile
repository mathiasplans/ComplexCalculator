all: run

.PHONY: compile clean

SRC = src/cCalculator/cCalculator.java src/cCalculator/GrammarCheck.java src/cCalculator/CalculatorFrame.java
CLASSPATH = lib/jep-java-3.4-trial.jar

compile:
	javac -cp .:$(CLASSPATH) -d bin $(SRC)

run: compile
	cd bin && java -cp ../$(CLASSPATH):. cCalculator/cCalculator

clean:
	rm -rf bin/cCalculator/cCalculator
