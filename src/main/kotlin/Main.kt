fun main(args: Array<String>) {

    /*Alumno: Jose Adrian Gonzalez Garcia*/

    /*Prueba 1*/
    println("Prueba 1: ${KataFizzBuzz(245)}")

    /*Prueba 2*/
    println("Prueba 2: ${KataFizzBuzz(666)}")

    /*Prueba 3*/
    println("Prueba 3: ${KataFizzBuzz(900000)}")

    /*Prueba 4*/
    println("Prueba 4: ${KataFizzBuzz(2227)}")

}

fun KataFizzBuzz(num: Int) : String{
    var message : String = ""
    if(num in 0..1000000){
        if (num%5==0 && num%3==0)
            message="FizzBuzz!"
        else if (num%3==0)
            message="Buzz!"
        else if (num%5==0)
            message="Fizz!"
        else
            message=convertir(num)
    }else{
        println("Número fuera del rango")
    }

    return message
}


var nombreEspecial= arrayOf<String>(
    "",
    " mil",
    " millon",
    " billion",
    " trillon",
    " cuatrillon",
    " quintillon"
)

var nombreDiecis= arrayOf<String>(
    "",
    " diez",
    " vente",
    " treinta",
    " cuarenta",
    " cincuenta",
    " sesenta",
    " setenta",
    " ochenta",
    " noventa"
)

var nombreNum= arrayOf<String>(
    "",
    " uno",
    " dos",
    " tres",
    " cuatro",
    " cinco",
    " seis",
    " siete",
    " ocho",
    " nueve",
    " diez",
    " once",
    " doce",
    " trece",
    " catorce",
    " quince",
    " dieciseis",
    " diecisiete",
    " dieciocho",
    " diecinueve"
)

fun convertirMenosDeMil(number: Int) : String {
    var current: String
    var num=number

    if (num % 100 < 20) {
        current = nombreNum[num % 100]
        num /= 100
    }else {
        current = nombreNum[num % 10]
        num /= 10
        current = nombreDiecis[num % 10] + current
        num /= 10
    }
    if (num == 0) return current
    return nombreNum[num] + " cientos" + current
}

fun convertir(number:Int): String {
    var num=number

    if (num == 0) { return "cero"; }

    var prefix: String=""

    if (num < 0) {
        num = -num;
        prefix = "negativo";
    }

    var current:String=""
    var place:Int=0

    do {
        var n:Int=num%1000
        if (n!=0){
            var s:String=convertirMenosDeMil(n)
            current=s+nombreEspecial[place]+current
        }
        place++
        num/=1000
    }while (num>0)

    return (prefix+current).trim()
}