import service.colors.myColor;

public class ColorConverter {
    public static void main(String[] args) {

        var hexColor = "0x1FF0FF";

        //find method decode - done
        var c = myColor.decode(hexColor);

        float[] hsbCode = new float[3];

        //find method RGBtoHSB - also getRed,etc - done
        myColor.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);

        //find method toHexString -or not?
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));

        //this methods are getred getblue getgreen
        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());

        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");

        //zad 2
        var hslcolor = myColor.convertRGBtoHSL(c.getRed(), c.getGreen(), c.getGreen());
        System.out.println("Boja u HSl formatu: " + hslcolor[0] + "°, " +
                hslcolor[1] * 100 + "%, " + hslcolor[2] * 100 + "%");

        var cymkColor = myColor.rgbToCmyk(c.getRed(),c.getGreen(),c.getBlue());
        System.out.println("Boja u CYMK formatu: " + cymkColor[0]+ " " +
                cymkColor[1] + " " + cymkColor[2]  + " " + cymkColor[3]);

        //for testing
        System.out.println("red: "+ c.getRed());
        System.out.println("Green: " + c.getGreen());
        System.out.println("Blue: "+c.getBlue());
    }


}
