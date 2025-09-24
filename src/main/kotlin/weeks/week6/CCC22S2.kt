package weeks.week6

/*
A class has been divided into groups of three.
This division into groups might violate two types of constraints: some students must work together in the same group,
and some students must work in separate groups.

Your job is to determine how many of the constraints are violated.

<Input Specification>
The first line will contain an integer X with X >= 0.
The next X lines will each consist of two different names, separated by a single space.
These two students must be in the same group.

The next line will contain an integer Y with Y >= 0.
The next Y lines will each consist of two different names, separated by a single space.
These two students must not be in the same group.

Among these X + Y lines representing constraints, each possible pair of students appears at most once.

The next line will contain an integer G with G >= 1.
The last G lines will each consist of three different names, separated by single spaces.
These three students have been placed in the same group.

Each name will consist of between 1 and 10 uppercase letters.
No two students will have the same name and each name appearing in a constraint will appear in exactly one of the G groups.

<Output Specification>
Output an integer between 0 and X + Y which is the number of constraints that are violated.
 */

private val inputInt: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid value ${value}")
    if (result !in range) throw IllegalArgumentException("out of range: ${range}")
    result
}

// 이름을 한 개의 공백으로 나누어 반환한다.
private val splitNames: (String) -> List<String> = { value ->
    val split = value.split(' ')
    if (split.size != 2) throw IllegalArgumentException("이름은 한 개의 공백으로 나뉘어져 있어야 합니다.")
    if (split[0] == split[1]) throw IllegalArgumentException("이름은 서로 달라야 합니다.")
    split
}

// 이름 조합 데이터 클래스
private data class PersonPair(val person1: String, val person2: String)

fun ccc22s2() {
    val input = System.`in`.bufferedReader()

    val X = input.readLine().let { inputInt(it, 0..100_000) }
    val sameGroup = mutableListOf<PersonPair>()
//    같은 그룹에 속해도 되는 이름 조합 유효성 검사 및 추가
    var i = 0
    while (i < X) {
        val names = input.readLine().let { splitNames(it) }

        sameGroup.add(PersonPair(names[0], names[1]))
        i++
    }

    val Y = input.readLine().let { inputInt(it, 0..100_000) }
    val diffGroup = mutableListOf<PersonPair>()
//    다른 그룹에 속해야 하는 이릅 조합 유효성 검사 및 추가
    i = 0
    while (i < Y) {
        val names = input.readLine().let { splitNames(it) }

        diffGroup.add(PersonPair(names[0], names[1]))
        i++
    }


    val G = input.readLine().let { inputInt(it, 1..100_000) }
//    인덱스를 활용하여 같은 그룹인지 체크 <name, group index>
    val groups = mutableMapOf<String, Int>()
//    실제로 구성된 그룹 부분
    i = 0
    while (i < G) {
        val names = input.readLine().split(' ').let {
            if (it.size != 3) throw IllegalArgumentException("이름은 3개여야 합니다.")
            if (it[0] == it[1] || it[1] == it[2] || it[2] == it[0])
                throw IllegalArgumentException("이름은 서로 달라야 합니다.")
            if (it.any { name -> name.length !in 1..10 } || it.any { name -> name != name.uppercase() })
                throw IllegalArgumentException("이름은 1..10 길이의 대문자여야 합니다.")
            it
        }

        if (names.any { name -> groups.containsKey(name) }) throw IllegalArgumentException("G그룹 이름은 중복될 수 없습니다.")

        for (name in names) {
            groups[name] = i
        }

        i++
    }

//    G에 X 이름이 있는지 유효성 검사
    i = 0
    while (i < sameGroup.size) {
        if (!groups.containsKey(sameGroup[i].person1) || !groups.containsKey(sameGroup[i].person2))
            throw IllegalArgumentException("G에 X의 학생이 없습니다.")
        i++
    }

//    G에 Y의 이름이 있는지 유효성 검사
    i = 0
    while (i < diffGroup.size) {
        if (!groups.containsKey(diffGroup[i].person1) || !groups.containsKey(diffGroup[i].person2))
            throw IllegalArgumentException("G에 Y의 학생이 없습니다.")
        i++
    }

    val sameGroupViolations = sameGroup.count { pair -> groups[pair.person1] != groups[pair.person2] }
    val diffGroupViolations = diffGroup.count { pair -> groups[pair.person1] == groups[pair.person2] }

    println(sameGroupViolations + diffGroupViolations)
}