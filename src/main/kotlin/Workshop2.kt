package org.example

// 1. กำหนด data class สำหรับเก็บข้อมูลสินค้า
data class Product(val name: String, val price: Double, val category: String)

fun main() {
    // 2. สร้างรายการสินค้าตัวอย่าง (List<Product>)
    val products: List<Product> = listOf(
        Product(name = "Laptop", price = 35000.0, category = "Electronics"),
        Product(name = "Smartphone", price = 25000.0, category = "Electronics"),
        Product(name = "T-shirt", price = 450.0, category = "Apparel"),
        Product(name = "Monitor", price = 7500.0, category = "Electronics"),
        Product(name = "Keyboard", price = 499.0, category = "Electronics"),
        Product(name = "Jeans", price = 1200.0, category = "Apparel"),
        Product(name = "Headphones", price = 1800.0, category = "Electronics")
    )
    // สินค้า name = "Laptop", price = 35000.0, category = "Electronics"
    // สินค้า name = "Smartphone", price = 25000.0, category = "Electronics"
    // สินค้า name = "T-shirt", price = 450.0, category = "Apparel"
    // สินค้า name = "Monitor", price = 7500.0, category = "Electronics"
    // สินค้า name = "Keyboard", price = 499.0, category = "Electronics" // ราคาไม่เกิน 500
    // สินค้า name = "Jeans", price = 1200.0, category = "Apparel"
    // สินค้า name = "Headphones", price = 1800.0, category = "Electronics" // ตรงตามเงื่อนไข


    println("รายการสินค้าทั้งหมด:")
    products.forEach { println(it) }
    println("--------------------------------------------------")


    // --- โจทย์: จงหาผลรวมราคาสินค้าทั้งหมดในหมวด 'Electronics' ที่มีราคามากกว่า 500 บาท ---

    // 3. วิธีที่ 1: การใช้ Chaining กับ List โดยตรง
    // กรองสินค้าหมวด Electronics
    // กรองสินค้าที่ราคามากกว่า 500
    // ดึงเฉพาะราคาออกมาเป็น List<Double>
    // หาผลรวมของราคา
//🚨    val totalElecPriceOver500 = ?
    val totalElecPriceOver500 = products.filter { it.category == "Electronics" && it.price > 500 }
        .fold(0.0) { acc, product -> acc + product.price }






    println("วิธีที่ 1: ใช้ Chaining กับ List")
    println("ผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท: $totalElecPriceOver500 บาท")
    println("--------------------------------------------------")


    // 4. (ขั้นสูง) วิธีที่ 2: การใช้ .asSequence() เพื่อเพิ่มประสิทธิภาพ
    // แปลง List เป็น Sequence ก่อนเริ่มประมวลผล
//🚨    val totalElecPriceOver500Sequence = ?

    println("วิธีที่ 2: ใช้ .asSequence() (ขั้นสูง)")
    val totalElecPriceOver500Sequence = products.asSequence().filter { it.category == "Electronics" && it.price > 500 }
        .fold(0.0) { acc, product -> acc + product.price }
    println("ผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท: $totalElecPriceOver500Sequence บาท")
    println("--------------------------------------------------")

    data class Product(val name: String, val price: Double, val category: String)

    fun calculateTotalElectronicsPriceOver500(products: List<Product>): Double {
        return products
            .filter { it.category == "Electronics" && it.price > 500 }
            .sumOf { it.price }
    }

    fun countElectronicsOver500(products: List<Product>): Int {
        return products.count { it.category == "Electronics" && it.price > 500 }
    }



    val group = products.groupBy {
        when {
            it.price < 1000 -> "<1000"
            it.price < 9999 && it.price > 1000 -> "<9999"
            else -> ">10000"
        }
    }

    group.forEach { (range, items) ->

            println("$range: ")
            items.forEach { println("${it.name} ${it.price}") }

    }




}

fun totalElecPriceOver500Sequences(products: List<Product>): Double {
    val totalElecPriceOver500s =  products
        .asSequence()
        .filter { it.category == "Electronics" }
        .filter { it.price > 500.0 }
        .map { it.price }
        .fold(0.0) { acc, it -> acc + it }
    return totalElecPriceOver500s
}

fun totalElecPriceOver500(products: List<Product>): Int {
    val totalElecPriceOver500s =  products
        .filter { it.category == "Electronics" && it.price > 500.0 }
        .size
    return totalElecPriceOver500s
}