fun main() {
    val implementation = ImplementationChecker()

    // Test case 1: IP address consists of less than four segments
    val invalid1 = "192.168.1"
    checkIPV4(
        name = "given an ip address with less than four segments, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid1),
        correctResult = false
    )

    // Test case 2: IP address consists of more than four numeric segments (more than 3 dots)
    val invalid2 = "192.168.1.1.1"
    checkIPV4(
        name = "given an ip address with more than four segments, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid2),
        correctResult = false
    )

    // Test case 3: IP address does not have dots
    val invalid3 = "19216811"
    checkIPV4(
        name = "given an ip address without dots, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid3),
        correctResult = false
    )

    // Test case 4: IP address segment higher than 255
    val invalid4 = "256.168.1.1"
    checkIPV4(
        name = "given an ip address with a segment higher than 255, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid4),
        correctResult = false
    )

    // Test case 5: IP address segment less than 0
    val invalid5 = "-1.168.1.1"
    checkIPV4(
        name = "given an ip address with a segment less than zero, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid5),
        correctResult = false
    )

    // Test case 6: IP address consists of a leading zero
    val invalid6 = "192.168.01.1"
    checkIPV4(
        name = "given an ip address with a leading zero, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid6),
        correctResult = false
    )

    // Test case 7: IP address consists of a non-numeric segment
    val invalid7 = "192.168.a.1"
    checkIPV4(
        name = "given an ip address with a non-numeric segment, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid7),
        correctResult = false
    )

    // Test case 8: IP address has extra space at the end
    val invalid8 = "192.168.1.1 "
    checkIPV4(
        name = "given an ip address with an extra space at the end, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid8),
        correctResult = false
    )

    // Test case 9: IP address has extra space at the beginning
    val invalid9 = " 192.168.1.1"
    checkIPV4(
        name = "given an ip address with an extra space at the start, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid9),
        correctResult = false
    )

    // Test case 10: Empty IP address
    val invalid10 = " "
    checkIPV4(
        name = "given an empty ip address, when checked by ipv4 checker, then it should return false",
        result = implementation.checkedIpv4(invalid10),
        correctResult = false
    )

    // Test case 11: IP address consists of zeros
    val valid1 = "0.0.0.0"
    checkIPV4(
        name = "given an ip address with zeros, when checked by ipv4 checker, then it should return true",
        result = implementation.checkedIpv4(valid1),
        correctResult = true
    )

    // Test case 12: IP address consists of 255
    val valid2 = "255.255.255.255"
    checkIPV4(
        name = "given an ip address with 255s, when checked by ipv4 checker, then it should return true",
        result = implementation.checkedIpv4(valid2),
        correctResult = true
    )

    // Test case 13: Valid IP address
    val valid3 = "192.168.1.1"
    checkIPV4(
        name = "given a valid ip address, when checked by ipv4 checker, then it should return true",
        result = implementation.checkedIpv4(valid3),
        correctResult = true
    )
}

fun checkIPV4(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}
