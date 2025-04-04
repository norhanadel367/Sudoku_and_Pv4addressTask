import kotlin.math.sqrt

class Implementation {
    fun sudokuChecker(game: List<List<Char>>): Boolean {
        val size = game.size
        // check all rows have the same length as size
        for (row in game) {
            if (row.size != game.size) {
                return false
            }
        }
        val subBoxesSizeDouble= sqrt(size.toDouble())
        val subBoxesSize = subBoxesSizeDouble.toInt()
        // check Sudoku have square board
        if (subBoxesSizeDouble * subBoxesSizeDouble != size.toDouble()) return false

        for (r in 0 until size) {
            val rowSet = mutableListOf<Char>()
            val colSet = mutableListOf<Char>()

            for (c in 0 until size) {

                //check Duplicate in a row
                val rowChar = game[r][c]
                //  println(rowChar)
                if (rowChar != '-' && rowSet.contains(rowChar)) return false
                if (rowChar != '-') rowSet.add(rowChar)

                //check Duplicate in a col
                val colChar = game[c][r]
                //  println(colChar)
                if (colChar != '-' && colSet.contains(colChar)) return false
                if (colChar != '-') colSet.add(colChar)

            }

        }
        // Check dynamic sub boxes
        //pointer of row and col to know star of sub boxes
        for (r in 0 until size step subBoxesSize) {
            for (c in 0 until size step subBoxesSize) {
                val subSet = mutableSetOf<Char>()
                //iterate for item in sub boxes
                for (rSub in 0 until subBoxesSize) {
                    for (cSub in 0 until subBoxesSize) {
                        val row = r + rSub
                        val col = c + cSub
                        val charSub = game[row][col]
                       // print(charSub)
                        if (charSub != '-' && subSet.contains(charSub)) return false

                        if (charSub != '-') subSet.add(charSub)
                    }
                }
            }
        }

        return true
    }
    fun ipv4Checker(ip:String):Boolean{
        if (ip.isEmpty()) return false

        val ipSeg = ip.split('.')
        if (ipSeg.size != 4) return false

        for (seg in ipSeg) {

            if (seg.startsWith("0") && seg.length > 1) return false

            val segInteger = seg.toIntOrNull() ?: return false

            if (segInteger <0 || segInteger >255) return false
        }

        return true
    }
}



