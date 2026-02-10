fun main() {
    println("Pruebas del Grafo\n")

    val grafo = ListaAdyacenciaGrafo<String>()

    //Agregar vertices

    println("Agregar Vertices: ")
    grafo.agregarVertice("A")
    grafo.agregarVertice("B")
    grafo.agregarVertice("C")
    grafo.agregarVertice("D")
    println(" Tamaño del grafo: ${grafo.tamano()}")

    //Conectar vertices

    println(" Conectar vertices: \n")
    grafo.conectar("A", "B")
    grafo.conectar("A", "C")
    grafo.conectar("B", "C")
    grafo.conectar("C", "D")
    grafo.conectar("D", "A")

    //Visualizar grafo

    println(" Grafo Completo: \n")
    println(grafo)

    //Subgrafo

    println(" Crear subgrafo con {A, B, C}: \n")
    val subgrafo = grafo.subgrafo(listOf("A", "B", "C"))
    println(" Subgrafo:")
    println(subgrafo)
    println(" Tamaño del subgrafo: ${subgrafo.tamano()}")

    //Eliminar vertices

    println(" Eliminar vertice 'B': \n")
    grafo.eliminarVertice("B")
    println(" Grafo despues de eliminar 'B':")
    println(grafo)

    //Grafo Vacio
    
    println(" Grafo vacio: \n")
    val grafoVacio = ListaAdyacenciaGrafo<Int>()
    println(" Tamaño: ${grafoVacio.tamano()}")
    println(" Obtener arcos de salida de 1: ${grafoVacio.obtenerArcosSalida(1)}")
    
    //Consultas de entradas y salidas
    println(" Consultas: \n")
    println(" Contiene 'A'?: ${grafo.contiene("A")}")
    println(" Arcos salida de 'A'?: ${grafo.obtenerArcosSalida("A")}")
    println(" Arcos salida de 'C'?: ${grafo.obtenerArcosSalida("C")}")
}