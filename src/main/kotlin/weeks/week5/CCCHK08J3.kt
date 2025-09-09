package weeks.week5

/*
Nowadays, the systems in mobile phones are very user friendly.
There is a shortcut button labelled Favourite for the most frequent dialed phone number so that
you can make a phone call to that friend in a very short amount of time.
The cellphone is smart enough to update the button dynamically.

Your job is to determine which phone number should be stored as the Favourite.

<Input Specification>

The input consists of two parts.
The first part is the phone book showing the name of friends and their phone numbers.
The second part is the phone numbers that have been dialed. The first integer N in the input (<= 10_000)
represents the total number of records in the phone book. Then each of the N records follows on its own line.
Each record starts with a name with no more than 20 characters (without any whitespace) and
then a phone number with exactly 8 digits. Next, another integer D (<= 10_000) in the input represents the total number
of phone numbers that have been dialed. Finally, these phone numbers are listed, one per line.

<Output Specification>
For the most frequently dialed phone number, output the corresponding name.
If there are two such numbers, output the one with the smaller phone number (where smaller mean numerically less than).
*/

private fun inputInt(value: String, range: IntRange): Int {
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("invalid int: $value")
    if (result !in range) throw IllegalArgumentException("out of range $range: $result")
    return result
}

fun ccchk08j3() {
    val input = System.`in`.bufferedReader()

    val phoneBook = mutableMapOf<String, String>()

    var i = 0
//    records 부분 - "Name PhoneNumber" 형식
    val N = input.readLine().let { inputInt(it, 1..10_000) }
    while (i < N) {
        val records = input.readLine().split(' ')

        if (records.size != 2) throw IllegalArgumentException("invalid records size: ${records.size}")

        val (name, phoneNumber) = records

        if (name.length > 20 || name.isEmpty()) throw IllegalArgumentException("invalid name: ${name}")
        if (phoneNumber.length != 8 || !phoneNumber.all { it.isDigit() })
            throw IllegalArgumentException("invalid phone number: ${phoneNumber}")

        phoneBook[name] = phoneNumber
        i++
    }

//    dialed 부분 - 8자리 전화번호 입력 및 유효성 검사
    i = 0
    val D = input.readLine().let { inputInt(it, 1..10_000) }
    val dialed = mutableMapOf<String, Int>()
    while (i < D) {
        val phoneNumber = input.readLine().let {
            if (it.length != 8 || !it.all { it.isDigit() }) throw IllegalArgumentException("invalid phone number: $it")
            it
        }

        dialed[phoneNumber] = dialed.getOrDefault(phoneNumber, 0) + 1
        i++
    }

    var maxCount = 0
    var maxPhoneNumber = ""
//    dialed 순회하면서 가장 많이 전화 건 번호 찾기 (동률일 경우 숫자가 더 적은 것으로)
    for ((phoneNumber, count) in dialed) {
        if (count > maxCount || (count == maxCount && phoneNumber < maxPhoneNumber)) {
            maxCount = count
            maxPhoneNumber = phoneNumber
        }
    }


    for ((name, phoneNumber) in phoneBook) {
        if (phoneNumber == maxPhoneNumber)
            println(name)
    }
}