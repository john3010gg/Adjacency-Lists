class ListaAdyacenciaGrafo<T> : Grafo<T> {
    private val adyacencias: MutableMap<T, MutableList<T>> = mutableMapOf () //El mapa donde vamos a guardar. Key = Vertice, Value = Lista de Sucesores

    override fun agregarVertice(v: T): Boolean {
        if (contiene(v)) return false
        adyacencias[v] = mutableListOf() //Para iniciar el vertice con una lista vacia de sucesores
        return true
    }

    override fun conectar(desde: T, hasta: T): Boolean {
        val listaSucesores = adyacencias[desde] /: return false //Usando la nulidad de kotlin podemos verificar que ambos existen
        if (!adyacencias.containsKey(hasta)) return false

        if (listaSuceros.contains(hasta)) return false //Evitamos duplicados si no es un multigrafo

        return listaSucesores.add(hasta)
    }
    override fun contiene(v: T): Boolean = adyacencias.containsKey(v)

    override fun tamano(): Int = adyacencias.size

    override fun obtenerArcosSalida(v: T): List<T> {
        return adyacencias[v]?.toList() ?: emptyList() // Si el vertice existe, retornamos su lista, si no, lista vacía
    }

    override fun obtenerArcosEntrada(v: T): List<T> {
        return adyacencias.filter { it.value.contains(v) }.keys.toList() // Filtramos las llaves del mapa donde su lista de sucesores contenga a 'v'
    }
    

    override fun eliminarVertice(v: T): Boolean {
        if (!contiene(v)) return false

        adyacencias.remove(v) // Eliminamos el vertice y sus arcos de salida

        adyacencias.values.forEach { lista ->  // Eliminamos los arcos de entrada 
            lista.remove(v)
        }

        return true
    }
}

