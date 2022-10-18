package service.colors;

import org.junit.Test;

import static org.junit.Assert.*;

public class myColorTest {
    @Test
    public void isGetRedEgualRed() {
        var hexColor = "0x1FF0FF";
        myColor x = myColor.decode(hexColor);
        assertEquals(31,x.getRed());
    }
}