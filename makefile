# Usado para compilar o projeto em um arquivo .jar
# Para compilar, abra o terminal no diretório deste arquivo e digite:
# make
# Para executar o sistemaBiblioteca.jar, abra o terminal e execute:
# java -jar sistemaBiblioteca.jar

all: windows

windows: criar-jar clean-windows

linux: criar-jar clean-linux

criar-jar:
	javac -d build -encoding utf-8 src/App.java
	cd build && \
	jar -c -e src/App -f ../sistemaBiblioteca.jar *

clean-windows:
	del /S /Q build > NUL
	rmdir /S /Q build

clear-linux:
	rm -r -d build