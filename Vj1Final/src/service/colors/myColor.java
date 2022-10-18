package service.colors;


public class myColor {
    private int r;
    private int g;
    private int b;
    int value;

    public myColor(int r, int g, int b) {
        this(r, g, b, 255);
    }
    public myColor(int r, int g, int b, int a) {
        value = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
        //testColorValueRange(r,g,b,a);s
    }

    //getters
    public int getRGB() {return value;}

    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }
    public int getRed() {return (getRGB() >> 16) & 0xFF;}
    public int getBlue() {
        return (getRGB() >> 0) & 0xFF;
    }


    public static myColor decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new myColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    public static float[] RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        System.out.println("aaaaaaaaaaaa");
        return hsbvals;
    }


    //zad2 - HSl & cymk
    public static float[] convertRGBtoHSL(int r, int g, int b) {
        float varR = (r / 255f);
        float varG = (g / 255f);
        float varB = (b / 255f);

        float varMin = Math.min(varR, Math.min(varG, varB)); // Min value of RGB
        float varMax = Math.max(varR, Math.max(varG, varB)); // Max value of RGB
        float delMax = varMax - varMin; // Delta RGB value

        float h = 0;
        float s = 0;
        float l = (varMax + varMin) / 2;

        if (delMax == 0 || l == 0) {
            s = 0;
        } else if (l == 1) {
            s = 1;
        } else if (l <= 0.5) {
            s = delMax / (2 * (1 - l));
        } else if (l > 0.5) {
            s = delMax / (2 * l);
        }

        if (delMax == 0) {
            h = 0;
        } else if (varMax == varR && g >= b) {
            h = 60 * (varG - varB) / delMax + 0;
        } else if (varMax == varR && varG < b) {
            h = 60 * (varG - varB) / delMax + 360;
        } else if (varMax == varG) {
            h = 60 * (varB - varR) / delMax + 120;
        } else if (varMax == varB) {
            h = 60 * (varR - varG) / delMax + 240;
        }
        return new float[] { h, s, l };
    }

    public static int[] rgbToCmyk(int r, int g, int b) {
        double percentageR = r / 255.0 * 100;
        double percentageG = g / 255.0 * 100;
        double percentageB = b / 255.0 * 100;

        double k = 100 - Math.max(Math.max(percentageR, percentageG), percentageB);

        if (k == 100) {
            return new int[]{ 0, 0, 0, 100 };
        }

        int c = (int)((100 - percentageR - k) / (100 - k) * 100);
        int m = (int)((100 - percentageG - k) / (100 - k) * 100);
        int y = (int)((100 - percentageB - k) / (100 - k) * 100);

        return new int[]{ c, m, y, (int)k };
    }
}
