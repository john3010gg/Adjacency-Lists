all: compile run

compile:
	kotlinc Grafo.kt ListaAdyacenciaGrafo.kt PruebaGrafo.kt -include-runtime -d ProyectoGrafo.jar

run:
	java -jar ProyectoGrafo.jar

clean:
	del ProyectoGrafo.jar