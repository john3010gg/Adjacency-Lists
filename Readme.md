Integrantes:
Nazareth Colmenares 20-10017
John Garrido 20-10293

Este proyecto es una implementación de un grafo dirigido utilizando listas de adyacencia en Kotlin, que cumple con la interfaz Grafo<T> proporcionada. La estructura principal utiliza un MutableMap<T>, MutableList<T> donde cada vértice se asocia a una lista de sus sucesores.

1. Instrucciones de Ejecución
Requisitos
Kotlin 1.3+ o JDK 8+
Visual Studio, IntelliJ IDEA, o cualquier editor con soporte para Kotlin.

2. Compilación y Ejecución:
    a. Clonar el repositorio
    b. Abrir el proyecto en el IDE de preferencia.
    c. Los archivos principales son:
    Grafo.kt - Interfaz del grafo
    ListaAdyacenciaGrafo.kt - Implementación con listas de adyacencia
    d. Para probar la implementación, hemos creado PruebaGrafo.kt

3. Complejidad Computacional (Big O)

    Método: agregarVertice(v: T)         
    Complejidad: O(1)
    Justificacion: Inserta una nueva entrada en un MutableMap (operación constante en promedio)

    Método: conectar(desde: T, hasta: T)         
    Complejidad: O(n)
    Justificacion: Verifica existencia de vértices (O(1)) y busca en la lista de sucesores para evitar duplicados (O(n) en el peor caso)

    Método: contiene(v: T)         
    Complejidad: O(1)
    Justificacion: Verifica la existencia de una clave en un MutableMap (operación constante)

    Método: obtenerArcosSalida(v: T)         
    Complejidad: O(n)
    Justificacion: Devuelve una copia de la lista de sucesores (O(n) para copiar la lista)

    Método: obtenerArcosEntrada(v: T)         
    Complejidad: O(V + E)
    Justificacion: Filtra todas las entradas del mapa y verifica pertenencia en cada lista de sucesores

    Método: eliminarVertice(v: T)         
    Complejidad: O(V + E)
    Justificacion: Elimina el vértice del mapa (O(1)) y recorre todas las listas de sucesores para eliminar referencias (O(E) en total)

    Método: tamano()         
    Complejidad: O(1)
    Justificacion: Retorna el tamaño del mapa (operación constante)

    Método: subgrafo(vertices: Collection<T>)         
    Complejidad: O(V + E)
    Justificacion: Filtra vértices existentes (O(V)) y recorre arcos para reconstruir el subgrafo (O(E))

4. Decisiones de Implementación
    a. Estructura de Datos Principal
        a.1 Se eligió MutableMap<T>, MutableList<T> porque:
            a.1.1 Permite acceso rápido a la lista de sucesores de cada vértice (O(1))
            a.1.2 Facilita la verificación de existencia de vértices
            a.1.3 Se integra naturalmente con las características de nulabilidad de Kotlin

    b. Manejo de Nulabilidad
        Se utilizó el operador seguro ?. y el operador Elvis ?: para manejar vértices no existentes:
            b.1 En obtenerArcosSalida(): Retorna lista vacía si el vértice no existe
            b.2 En conectar(): Verifica nulidad antes de operar

    c. Evitación de Duplicados
        En agregarVertice(): Se verifica existencia previa con containsKey()
        En conectar(): Se verifica contains() en la lista de sucesores antes de agregar

    d. Implementación de obtenerArcosEntrada()
        Se utilizó la función filter de Kotlin para un código más declarativo y legible:
            adyacencias.filter { it.value.contains(v) }.keys.toList()
            Aunque tiene complejidad O(V + E), es más expresivo que una implementación manual con bucles.

    e. Implementación de subgrafo()
        Se decidió:
            e.1 Filtrar solo los vértices que existen en el grafo original
            e.2 Reconstruir solo los arcos donde ambos extremos están en el subgrafo
            e.3 Mantener la misma implementación de lista de adyacencia para consistencia


    f. Inmutabilidad en Retornos
        Los métodos obtenerArcosSalida() y obtenerArcosEntrada() retornan List<T> (inmutable) en lugar de MutableList<T>, previniendo modificaciones externas no controladas.






