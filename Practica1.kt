import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.*

var nombre: String = ""

//Funcion principal
fun main() {
    val scanner = Scanner(System.`in`)
    var exit = false
    

    while (!exit) {
        println("\nMenu de opciones:")
        println("1. Suma tres numeros")
        println("2. Ingresa tu nombre completo")
        println("3. Calcula tiempo vivido")
        println("4. Salir")
        print("Seleccione una opcion: ")
        
        when (scanner.nextInt()) {
            1 -> sumarNumeros(scanner)
            2 -> ingresarNombre(scanner)
            3 -> calcularTiempoVivido(scanner)
            4 -> {
                println("Saliendo del programa...")
                exit = true
            }
            else -> println("Opción no valida. Intente de nuevo.")
        }
    }
    scanner.close()
}

// Función para sumar tres numeros
fun sumarNumeros(scanner: Scanner) {
    println("Ingrese tres numeros:")
    print("Número 1: ")
    var num1: Double = scanner.nextDouble()
    print("Número 2: ")
    var num2: Double = scanner.nextDouble()
    print("Número 3: ")
    var num3: Double = scanner.nextDouble()
    var suma: Double = num1 + num2 + num3
    println("La suma de los números es: $suma")
}

// Función para ingresar nombre completo
fun ingresarNombre(scanner: Scanner) {
    scanner.nextLine()
    print("Ingrese su nombre completo: ")
    nombre = scanner.nextLine()
    println("Nombre ingresado: $nombre")
}

// Función para calcular el tiempo vivido desde la fecha de nacimiento
fun calcularTiempoVivido(scanner: Scanner) {
    println("Ingrese su fecha de nacimiento en formato YYYY-MM-DD:")
    val fechaNacimiento = LocalDate.parse(scanner.next())
    val fechaActual = LocalDate.now()
    
    val period = Period.between(fechaNacimiento, fechaActual)
    val diasTotales = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
    val semanasTotales = diasTotales / 7
    val horasTotales = diasTotales * 24
    val minutosTotales = horasTotales * 60
    val segundosTotales = minutosTotales * 60
    
    if(nombre != ""){
        println("Usuario: $nombre")
    }
    println("Tiempo vivido hasta hoy:")
    println("Años: ${period.years}, Meses: ${period.months}, Días: ${period.days}")
    println("Total de semanas: $semanasTotales")
    println("Total de días: $diasTotales")
    println("Total de horas: $horasTotales")
    println("Total de minutos: $minutosTotales")
    println("Total de segundos: $segundosTotales")
}