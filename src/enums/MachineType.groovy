package enums

enum MachineType {
    IMAGE_FILE_MACHINE_UNKNOWN(0 as short),
    IMAGE_FILE_MACHINE_AM33(0x01d3 as short),
    IMAGE_FILE_MACHINE_AMD64(0x8664 as short),
    IMAGE_FILE_MACHINE_ARM(0x01c0 as short),
    IMAGE_FILE_MACHINE_ARMV7(0x1c4 as short),
    IMAGE_FILE_MACHINE_EBC(0x0ebc as short),
    IMAGE_FILE_MACHINE_I386(0x014c as short),
    IMAGE_FILE_MACHINE_IA64(0x0200 as short),
    IMAGE_FILE_MACHINE_M32R(0x9041 as short),
    IMAGE_FILE_MACHINE_MIPS16(0x0266 as short),
    IMAGE_FILE_MACHINE_MIPSFPU(0x0366 as short),
    IMAGE_FILE_MACHINE_MIPSFPU16(0x0466 as short),
    IMAGE_FILE_MACHINE_POWERPC(0x01f0 as short),
    IMAGE_FILE_MACHINE_POWERPCFP(0x01f1 as short),
    IMAGE_FILE_MACHINE_R4000(0x0166 as short),
    IMAGE_FILE_MACHINE_SH3(0x01a2 as short),
    IMAGE_FILE_MACHINE_SH3DSP(0x01a3 as short),
    IMAGE_FILE_MACHINE_SH4(0x01a6 as short),
    IMAGE_FILE_MACHINE_SH5(0x01a8 as short),
    IMAGE_FILE_MACHINE_THUMB(0x01c2 as short),
    IMAGE_FILE_MACHINE_WCEMIPSV2(0x0169 as short)

    private final short machineType
    private static Map map = new HashMap<>();

    MachineType(short value) {
        machineType = value
    }

    static {
        for (MachineType machineType : values()) {
            map.put(machineType.machineType, machineType);
        }
    }

    public static MachineType valueOf(short machineType) {
        return (MachineType) map.get(machineType);
    }
}