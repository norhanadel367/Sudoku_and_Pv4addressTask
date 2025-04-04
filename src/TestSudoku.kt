fun main() {

    val imp = Implementation()

    // Test case 1: Valid 9x9 Sudoku board
    val valid1 = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "given a valid 9x9 sudoku board, when checked by sudoku checker, then it should return true",
        result = imp.sudokuChecker(valid1),
        correctResult = true
    )

    // Test case 2: Valid 4x4 Sudoku board
    val valid2 = listOf(
        listOf('1', '2', '-', '4'),
        listOf('3', '4', '1', '2'),
        listOf('2', '1', '4', '3'),
        listOf('4', '3', '2', '1')
    )
    check(
        name = "given a valid 4x4 sudoku board, when checked by sudoku checker, then it should return true",
        result = imp.sudokuChecker(valid2),
        correctResult = true
    )

    // Test case 3: Invalid Sudoku - Duplicate in a row
    val invalid1 = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '7'),
        listOf('-', '-', '-', '-', '5', '-', '-', '7', '5')  //5
    )
    check(
        name = "given a sudoku board with duplicate in a row, when checked by sudoku checker, then it should return false",
        result = imp.sudokuChecker(invalid1),
        correctResult = false
    )

    // Test case 4: Invalid Sudoku - Duplicate in a column
    val invalid2 = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('5', '-', '-', '-', '2', '-', '-', '-', '6'), //5
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '8', '-', '7', '9')
    )
    check(
        name = "given a sudoku board with duplicate in a column, when checked by sudoku checker, then it should return false",
        result = imp.sudokuChecker(invalid2),
        correctResult = false
    )

    // Test case 5: Invalid Sudoku - Duplicate in a sub-box
    val invalid3 = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '4', '8', '-'), // 4
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '4')
    )
    check(
        name = "Given an invalid Sudoku board with duplicate in a sub-box, when checked, then it should return false",
        result = imp.sudokuChecker(invalid3),
        correctResult = false
    )

    // Test case 6: Invalid Sudoku - Non-square board
    val invalid5 = listOf(
        listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
        listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
        listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
        listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
        listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
        listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
        listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
        listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
        listOf('3', '4', '5', '2', '8', '6', '1', '7', '9'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-') // Extra row
    )
    check(
        name = "Given an invalid Sudoku board with non-square shape, when checked, then it should return false",
        result = imp.sudokuChecker(invalid5),
        correctResult = false
    )
    // Test case 8: Board with inconsistent row lengths
    val invalidSize = listOf(
        listOf('-', '9', '8', '-', '-', '-'), // Len of Row < len of list
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "Given an invalid Sudoku board with inconsistent row length, when checked, then it should return false",
        result = imp.sudokuChecker(invalidSize),
        correctResult = false
    )
//    // Test case 7: Invalid characters in Sudoku board
//    val invalidChar = listOf(
//        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
//        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
//        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
//        listOf('8', '-', '-', 'A', '6', '-', '-', '-', '3'), // Invalid char 'A'
//        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
//        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
//        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
//        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
//        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
//    )
//    check(
//        name = "Given an invalid Sudoku board with non-numeric character, when checked, then it should return false",
//        result = imp.sudokuChecker(invalidChar),
//        correctResult = false
//    )
}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}
