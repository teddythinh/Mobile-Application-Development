fun exercise7(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size - 1) {
        for (j in 0 until list.size - 1) {
            if (list[j] > list[j + 1]) {
                val number = list[j]
                list[j] = list[j + 1]
                list[j + 1] = number
            }
        }
    }
    return list
}

fun exercise8(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size - 1) {
        for (j in 0 until list.size - 1) {
            if (list[j] < list[j + 1]) {
                val number = list[j]
                list[j] = list[j + 1]
                list[j + 1] = number
            }
        }
    }
    return list
}

fun exercise9(list: MutableList<Int>, k: Int): MutableList<Int>? {
    if (k == 1) {
        return exercise7(list)
    } else if (k == 0) {
        return exercise8(list)
    }
    return null
}

fun exercise10(n: Int): Boolean {
    var number = n
    var reverse = 0
    while (number != 0) {
        var lastDigit = number % 10
        reverse = reverse * 10 + lastDigit
        number /= 10
    }
    return n == reverse
}

fun exercise11(n: Int): Boolean {
    if (n <= 1) {
        return false
    }
    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun exercise12(list: MutableList<Int>): List<Int> {
    var biggestNumber: Int = 0
    var biggestOddNumber: Int = 0
    var biggestEvenNumber: Int = 0
    var biggestPrimeNumber: Int = 0
    for (i in 0 until list.size) {
        if (list[i] > biggestNumber) {
            biggestNumber = list[i]
        }
        if (list[i] % 2 == 0) {
            if (list[i] > biggestEvenNumber) {
                biggestEvenNumber = list[i]
            }
        } else {
            if (list[i] > biggestOddNumber) {
                biggestOddNumber = list[i]
            }
        }
        if (exercise11(list[i])) {
            if (list[i] > biggestPrimeNumber) {
                biggestPrimeNumber = list[i]
            }
        }
    }
    var result: List<Int> =
            listOf(biggestNumber, biggestOddNumber, biggestEvenNumber, biggestPrimeNumber)
    return result
}

fun calculateTaxiFare(length: Double): Double {
    if (length <= 1) return 15000.0
    else if (length <= 5) return 15000 + (length - 1) * 13500
    else if (length <= 120)  return 15000 + 4 * 13500 + (length - 5) * 11000
    else return 15000 + 4 * 13500 + (length - 5) * 11000 * 0.9
}

fun calculateDeliveryFare(price: Double, quantity: Int, isDelivery: Boolean): Double {
    var result = price * quantity
    if (isDelivery) {
        if (result > 100000.0) {
            result += 20000.0
            result *= 0.9 // 10% discount
        } else result += 20000.0
    }
    return result
}

fun currencyConverter() {
    var amount: Double
    var result: Double
    var choice: Int
    try {
        print("Nh???p l???a ch???n (1: USD -> VND, 2: VND -> USD): ")
        choice = readLine()!!.toInt()
        print("Nh???p s??? ti???n: ")
        amount = readLine()!!.toDouble()
        if (choice == 1) {
            result = amount * 22700
            println("$amount USD = $result VND")
        } else if (choice == 2) {
            result = amount / 22700
            println("$amount VND = $result USD")
        } else {
            println("L???a ch???n kh??ng h???p l???")
            currencyConverter()
        }
    } 
    catch (e: NumberFormatException) { 
        println("S??? ti???n ph???i l?? s??? th???c")
        currencyConverter()
    }
}

fun exercise4(n: Int): Int {
    var s = 0
    var i = 1
    while (s <= n) {
        s += i
        i++
    }
    return i - 1
}

open class NhanVien constructor(_id: Int, _name: String, _dob: String, _address: String) {
    var id: Int = _id
    var name: String = _name
    var dob: String = _dob
    var address: String = _address

    open fun NhapThongTin() {
        println("Nh???p ID: ")
        id = readLine()!!.toInt()
        println("Nh???p t??n: ")
        name = readLine()!!.toString()
        println("Nh???p ng??y sinh: ")
        dob = readLine()!!.toString()
        println("Nh???p ?????a ch???: ")
        address = readLine()!!.toString()
    }

    open fun XuatThongTin() {
        val idToPrint = if (id != null) id else "no id"
        val nameToPrint = if (name != null) name else "no name"
        val dobToPrint = if (dob != null) dob else "no dob"
        val addressToPrint = if (address != null) address else "no address"

        println("ID: $idToPrint")
        println("T??n: $nameToPrint")
        println("Ng??y sinh: $dobToPrint")
        println("?????a ch???: $addressToPrint")
    }
}

class NhanVienSanXuat constructor(_id: Int, _name: String, _dob: String, _address: String, _quantity: Int) :
        NhanVien(_id, _name, _dob, _address) {
    var quantity: Int = _quantity

    constructor(): this(0, "", "", "", 0)
    constructor(_id: Int, _name: String, _dob: String, _address: String) : this(_id, _name, _dob, _address, 0)
    constructor(_id: Int, _name: String) : this(_id, _name, "", "", 0)
    constructor(_id: Int) : this(_id, "", "", "", 0)
    constructor(_name: String) : this(0, _name, "", "", 0)

    override fun NhapThongTin() {
        super.NhapThongTin()
        println("Nh???p s??? l?????ng s???n ph???m: ")
        quantity = readLine()!!.toInt()
    }

    fun TinhLuong(): Int {
        return quantity * 20000
    }

    override fun XuatThongTin() {
        super.XuatThongTin()
        println("L????ng: ${TinhLuong()}")
    }
}

class NhanVienCongNhat constructor(_id: Int, _name: String, _dob: String, _address: String, _day: Int) :
        NhanVien(_id, _name, _dob, _address) {
    var day: Int = _day

    constructor(): this(0, "", "", "", 0)
    constructor(_id: Int, _name: String, _dob: String, _address: String) : this(_id, _name, _dob, _address, 0)
    constructor(_id: Int, _name: String) : this(_id, _name, "", "", 0)
    constructor(_id: Int) : this(_id, "", "", "", 0)
    constructor(_name: String) : this(0, _name, "", "", 0)

    override fun NhapThongTin() {
        super.NhapThongTin()
        println("Nh???p s??? ng??y l??m vi???c: ")
        day = readLine()!!.toInt()
    }

    fun TinhLuong(): Int {
        return day * 300000
    }

    override fun XuatThongTin() {
        super.XuatThongTin()
        println("L????ng: ${TinhLuong()}")
    }
}

open class DocGia(_maDocGia: Int, _hoTen: String) {
    var maDocGia: Int = _maDocGia
    var hoTen: String = _hoTen

    open fun nhapThongTin() {
        try {
            print("Nh???p m?? ?????c gi???: ")
            maDocGia = readLine()!!.toInt()
            print("Nh???p h??? t??n: ")
            hoTen = readLine()!!
        } catch (e: NumberFormatException) {
            println("M?? ?????c gi??? ph???i l?? s??? nguy??n")
            nhapThongTin()
        }
    }

    open fun lePhi() {}

    open fun xuatThongTin() {
        println("Ma doc gia: $maDocGia")
        println("Ho ten: $hoTen")
    }
}

class DocGiaThuong(
        _maDocGia: Int,
        _hoTen: String,
        _ngayHetHan: String,
        _gioiTinh: String,
        _soSachMuon: Int
) : DocGia(_maDocGia, _hoTen) {
    var ngayHetHan: String = _ngayHetHan
    var gioiTinh: String = _gioiTinh
    var soSachMuon: Int = _soSachMuon

    constructor() : this(0, "", "", "", 0)
    constructor(_maDocGia: Int, _hoTen: String) : this(_maDocGia, _hoTen, "", "", 0)
    constructor(
            _maDocGia: Int,
            _hoTen: String,
            _ngayHetHan: String,
            _gioiTinh: String
    ) : this(_maDocGia, _hoTen, _ngayHetHan, _gioiTinh, 0)
    constructor(
            _maDocGia: Int,
            _hoTen: String,
            _soSachMuon: Int
    ) : this(_maDocGia, _hoTen, "", "", _soSachMuon)

    override fun nhapThongTin() {
        super.nhapThongTin()
        print("Nh???p ng??y h???t h???n: ")
        ngayHetHan = readLine()!!
        print("Nh???p gi???i t??nh: ")
        gioiTinh = readLine()!!
        print("Nh???p s??? s??ch m?????n: ")
        soSachMuon = readLine()!!.toInt()
    }

    override fun lePhi() {
        println("L??? ph??: ${soSachMuon * 5000}")
    }

    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Ng??y h???t h???n: $ngayHetHan")
        println("Gi???i t??nh: $gioiTinh")
        println("S??? s??ch m?????n: $soSachMuon")
    }
}

class DocGiaVip(_maDocGia: Int, _hoTen: String, _ngayHetHan: String, _gioiTinh: String) :
        DocGia(_maDocGia, _hoTen) {
    var ngayHetHan: String = _ngayHetHan
    var gioiTinh: String = _gioiTinh

    constructor() : this(0, "", "", "")
    constructor(_maDocGia: Int, _hoTen: String) : this(_maDocGia, _hoTen, "", "")
    constructor(
            _maDocGia: Int,
            _hoTen: String,
            _gioiTinh: String
    ) : this(_maDocGia, _hoTen, "", _gioiTinh)

    override fun nhapThongTin() {
        super.nhapThongTin()
        print("Nh???p ng??y h???t h???n: ")
        ngayHetHan = readLine()!!
        print("Nh???p gi???i t??nh: ")
        gioiTinh = readLine()!!
    }

    override fun lePhi() {
        println("L??? ph??: 50000")
    }

    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Ng??y h???t h???n: $ngayHetHan")
        println("Gi???i t??nh: $gioiTinh")
    }
}

fun main() {
    var list1: MutableList<Int> = mutableListOf(3, 5, 1, 2, 4)
    var list2: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var length = 150.2
    var price = 100000.0
    var quantity = 5
    var isDelivery = true

    println(calculateTaxiFare(length))
    println(calculateDeliveryFare(price, quantity, isDelivery))
    currencyConverter()
    print(exercise4(6))

    println("Exercise 7: " + exercise7(list1))

    println("Exercise 8: " + exercise8(list1))

    println("Exercise 9: " + exercise9(list1, 1))
    println("Exercise 9: " + exercise9(list1, 0))

    println("Exercise 10: " + exercise10(12321))
    println("Exercise 10: " + exercise10(12345))

    println("Exercise 11: " + exercise11(5))
    println("Exercise 11: " + exercise11(6))

    println("Exercise 12: " + exercise12(list2))

    var nv1: NhanVienSanXuat = NhanVienSanXuat(1, "Nguyen Van A", "01/01/2000", "Ha Noi", 100)
    var nv2: NhanVienCongNhat = NhanVienCongNhat(2, "Nguyen Van B", "02/02/2000", "Ha Noi", 100)
    var nv3 = NhanVienSanXuat()
    var nv4 = NhanVienCongNhat()

    nv1.XuatThongTin()
    nv1.TinhLuong()
    nv2.XuatThongTin()
    nv2.TinhLuong()
    nv3.NhapThongTin()
    nv3.XuatThongTin()
    nv3.TinhLuong()
    nv4.NhapThongTin()
    nv4.XuatThongTin()
    nv4.TinhLuong()

    var docgia1: DocGiaThuong = DocGiaThuong(1, "Nguyen Van A", "01/01/2021", "Nam", 3)
    var docgia2: DocGiaVip = DocGiaVip(2, "Nguyen Van B", "01/01/2021", "Nam")
    var docgia3 = DocGiaThuong()
    var docgia4 = DocGiaVip()

    docgia1.xuatThongTin()
    docgia1.lePhi()
    docgia2.xuatThongTin()
    docgia2.lePhi()
    docgia3.nhapThongTin()
    docgia3.xuatThongTin()
    docgia3.lePhi()
    docgia4.nhapThongTin()
    docgia4.xuatThongTin()
    docgia4.lePhi()
}
