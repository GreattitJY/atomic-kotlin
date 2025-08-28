package weeks.week3

fun crci06p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val BARD = 1

    val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid N")
    if (N < 2 || N > 100) throw Throwable("out of range 2..100 N: $N")
    val E = input.readLine().toIntOrNull() ?: throw Throwable("invalid E")
    if (E < 1 || E > 50) throw Throwable("out of range 1..50 E: $E")

    val vSongs = mutableMapOf<Int, MutableSet<Int>>()
    for (v in 2..N) {
        vSongs[v] = mutableSetOf()
    }

    var bardSongCount = 0

    var e = 1
    while (e <= E) {
        var K = input.readLine()
        if (K.isNullOrBlank()) throw Throwable("isNullOrBlank K")

        val villagers = mutableSetOf<Int>()
        var spaceCount = 0
        val maxSpaceCount = K[0].digitToIntOrNull() ?: throw Throwable("invalid maxSpaceCount: ${K[0]}")
        var kIndex = 1

        // K 유효성 검사
        while (kIndex < K.length) {
            val k = K[kIndex]

            if (kIndex % 2 == 1) {
                if (k == ' ') spaceCount++
                else throw Throwable("k must be space: ${k}")
            } else {
                val v = k.digitToIntOrNull() ?: throw Throwable("invalid k: ${k}")
                if (v < 1 || v > N) throw Throwable("out of range: ${v}")

                if (villagers.contains(v)) throw Throwable("v appear twice in one night")
                villagers.add(v)
            }
            kIndex++
        }

        // 바드 존재 여부 확인
        val bardPresent = villagers.contains(BARD)
        if (bardPresent) {
            bardSongCount++
            villagers.remove(BARD)
        }

        if (bardPresent) {
            for (v in villagers) {
                vSongs[v]?.add(e)
            }
        } else {
            // villagers 끼리 아는 노래 교환
            if (villagers.size >= 2) {
                val combinedSongs = mutableSetOf<Int>()

                // 노래 수집
                for (villager in villagers) {
                    val songs = vSongs[villager]
                    if (songs != null) {
                        combinedSongs.addAll(songs)
                    }
                }

                // 노래 배분
                for (villager in villagers) {
                    val songs = vSongs[villager]
                    if (songs != null) {
                        songs.addAll(combinedSongs)
                    }
                }
            }
        }

        e++
    }

    output.write("1\n")
    for (v in 2..N) {
        val songs = vSongs[v]
        if (songs != null && songs.size == bardSongCount) {
            output.write("$v\n")
        }
    }

    output.flush()
}