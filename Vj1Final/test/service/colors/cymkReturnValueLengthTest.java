package service.colors;

import org.junit.Test;

import static org.junit.Assert.*;

public class cymkReturnValueLengthTest {
    @Test
    public void isReturnedValueLengthEgualFour() {

        var cymkNum = myColor.rgbToCmyk(255,255,255);

        assertEquals(4,cymkNum.length);
    }
}