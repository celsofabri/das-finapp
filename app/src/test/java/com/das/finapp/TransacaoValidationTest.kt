package com.das.finapp

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal

class TransacaoValidationTest {

    /**
     * Helper function to parse currency value (simulates the parsing logic)
     * Accepts both comma and dot as decimal separator
     */
    private fun parseCurrencyValue(input: String): BigDecimal? {
        return try {
            val normalized = input.trim().replace(",", ".")
            BigDecimal(normalized)
        } catch (e: NumberFormatException) {
            null
        }
    }

    @Test
    fun testParseValidDecimalWithComma() {
        val result = parseCurrencyValue("20,50")
        assertNotNull("Should parse valid decimal with comma", result)
        assertEquals("Should equal 20.50", BigDecimal("20.50"), result)
    }

    @Test
    fun testParseValidDecimalWithDot() {
        val result = parseCurrencyValue("20.50")
        assertNotNull("Should parse valid decimal with dot", result)
        assertEquals("Should equal 20.50", BigDecimal("20.50"), result)
    }

    @Test
    fun testParseInvalidValueLetters() {
        val result = parseCurrencyValue("abc")
        assertNull("Should return null for invalid letters", result)
    }

    @Test
    fun testParseEmptyString() {
        val result = parseCurrencyValue("")
        assertNull("Should return null for empty string", result)
    }

    @Test
    fun testParseNegativeValue() {
        val result = parseCurrencyValue("-10,50")
        assertNotNull("Should parse negative value", result)
        assertEquals("Should equal -10.50", BigDecimal("-10.50"), result)
        assertTrue("Should be negative", result!! < BigDecimal.ZERO)
    }

    @Test
    fun testParseZeroValue() {
        val result = parseCurrencyValue("0")
        assertNotNull("Should parse zero", result)
        assertEquals("Should equal 0", BigDecimal.ZERO, result)
    }

    @Test
    fun testParseZeroWithDecimals() {
        val result = parseCurrencyValue("0,00")
        assertNotNull("Should parse zero with decimals", result)
        assertEquals("Should equal 0.00", BigDecimal("0.00"), result)
    }

    @Test
    fun testParseVeryLargeValue() {
        val result = parseCurrencyValue("999999999,99")
        assertNotNull("Should parse very large value", result)
        assertEquals("Should equal 999999999.99", BigDecimal("999999999.99"), result)
    }

    @Test
    fun testParseIntegerWithoutDecimals() {
        val result = parseCurrencyValue("100")
        assertNotNull("Should parse integer without decimals", result)
        assertEquals("Should equal 100", BigDecimal("100"), result)
    }

    @Test
    fun testParseWithMultipleCommas() {
        val result = parseCurrencyValue("1,000,50")
        // This will fail to parse correctly as it becomes "1.000.50"
        // which is not a valid BigDecimal format
        assertNull("Should return null for multiple commas", result)
    }

    @Test
    fun testParseWithSpaces() {
        val result = parseCurrencyValue("  20,50  ")
        assertNotNull("Should parse value with spaces (trimmed)", result)
        assertEquals("Should equal 20.50", BigDecimal("20.50"), result)
    }

    @Test
    fun testValidationPositiveValue() {
        val value = parseCurrencyValue("50,00")
        assertNotNull("Should parse positive value", value)
        assertTrue("Should be greater than zero", value!! > BigDecimal.ZERO)
    }

    @Test
    fun testValidationNegativeValueShouldFail() {
        val value = parseCurrencyValue("-50,00")
        assertNotNull("Should parse negative value", value)
        assertFalse("Should not be greater than zero", value!! > BigDecimal.ZERO)
    }

    @Test
    fun testValidationZeroValueShouldFail() {
        val value = parseCurrencyValue("0,00")
        assertNotNull("Should parse zero", value)
        assertFalse("Should not be greater than zero", value!! > BigDecimal.ZERO)
    }
}
