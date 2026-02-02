class ListaAdyacenciaGrafo<T> : Grafo<T> {
    private val adyacencias: MutableMap<T, MutableList<T>> = mutableMapOf () //El mapa donde vamos a guardar. Key = Vertice, Value = Lista de Sucesores

    override fun agregarVertice(v: T): Boolean {
        if (contiene(v)) return false
        adyacencias[v] = mutableListOf() //Para iniciar el vertice con una lista vacia de sucesores
        return true
    }

    
    
}