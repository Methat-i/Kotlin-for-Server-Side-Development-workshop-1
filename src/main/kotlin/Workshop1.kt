package org.example

// Workshop #1: Simple Console Application - Unit Converter

fun main() {
    // 2. ใช้ while (true) เพื่อให้โปรแกรมทำงานวนซ้ำ
    while (true) {
        // 1. แสดงเมนูให้ผู้ใช้เลือก
        println("===== Unit Converter =====")
        println("โปรดเลือกหน่วยที่ต้องการแปลง:")
        println("1. Celsius to Fahrenheit")
        println("2. Kilometers to Miles")
        println("พิมพ์ 'exit' เพื่อออกจากโปรแกรม")
        print("เลือกเมนู (1, 2, or exit): ")
        val choice = readln()
        // 2. รับข้อมูลตัวเลือกจากผู้ใช้

        when (choice) {
            "1" -> {
                print("ป้อนอุณหภูมิ (°C): ")
                val input = readln()
                val celsius = input.toDoubleOrNull()
                if (celsius == null) {
                    println("❌ กรุณาป้อนตัวเลขที่ถูกต้อง")
                    continue
                }
                val fahrenheitResult = celsiusToFahrenheit(celsius)
                println("ผลลัพธ์: $celsius °C เท่ากับ ${"%.2f".format(fahrenheitResult)} °F")
            }

            "2" -> {
                print("ป้อนระยะทาง (km): ")
                val input = readln()
                val km = input.toDoubleOrNull()
                if (km == null) {
                    println("❌ กรุณาป้อนตัวเลขที่ถูกต้อง")
                    continue
                }
                val milesResult = kilometersToMiles(km)
                println("ผลลัพธ์: $km km เท่ากับ ${"%.2f".format(milesResult)} miles")
            }

            "exit" -> break

            else -> println("❌ เลือกไม่ถูกต้อง กรุณาลองใหม่")
        }
        // 3. ควบคุมการทำงานด้วย when expression
        // เลือก 1 เพื่อแปลง Celsius เป็น Fahrenheit: convertCelsiusToFahrenheit()
        // เลือก 2 เพื่อแปลง Kilometers เป็น Miles: convertKilometersToMiles()
        // เลือก 'exit' เพื่อออกจากโปรแกรม
        // 🚨


        println() // พิมพ์บรรทัดว่างเพื่อความสวยงาม
    }
}

// แปลง Celsius เป็น Fahrenheit
fun celsiusToFahrenheit(celsius: Double): Double {
    return celsius * 9.0 / 5.0 + 32
}

// แปลง Kilometers เป็น Miles
fun kilometersToMiles(kilometers: Double): Double {
    return kilometers * 0.621371
}

fun convertKilometersToMiles(km: Double): Double {
    return km * 0.621371
}

// 4. สร้างฟังก์ชันแยกสำหรับการแปลงหน่วย Celsius to Fahrenheit: celsiusToFahrenheit
// สูตร celsius * 9.0 / 5.0 + 32
// 🚨


// 4. สร้างฟังก์ชันแยกสำหรับการแปลงหน่วย Kilometers to Miles: kilometersToMiles
// สูตร kilometers * 0.621371
// 🚨



