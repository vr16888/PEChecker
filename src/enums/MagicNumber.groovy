package enums

enum MagicNumber {
    NONE(0 as short),
    PE32(0x010b as short),
    PE32_PLUS(0x020b as short),
    ROM(0x0107 as short)

    private final short magicNumber
    private static Map map = new HashMap<>();

    MagicNumber(short value) {
        magicNumber = value
    }

    static {
        for (MagicNumber magicNumber : values()) {
            map.put(magicNumber.magicNumber, magicNumber);
        }
    }

    public static MagicNumber valueOf(short magicNumber) {
        return (MagicNumber) map.get(magicNumber);
    }
}