package enums

enum Subsystem {
    IMAGE_SYSTEM_UNKNOWN(0 as short),
    IMAGE_SUBSYSTEM_NATIVE(1 as short),
    IMAGE_SUBSYSTEM_WINDOWS_GUI(2 as short),
    IMAGE_SUBSYSTEM_WINDOWS_CUI(3 as short),
    IMAGE_SUBSYSTEM_POSIX_CUI(7 as short),
    IMAGE_SUBSYSTEM_WINDOWS_CE_GUI(9 as short),
    IMAGE_SUBSYSTEM_EFI_APPLICATION(10 as short),
    IMAGE_SUBSYSTEM_EFI_BOOT_SERVICE_DRIVER(11 as short),
    IMAGE_SUBSYSTEM_EFI_RUNTIME_DRIVER(12 as short),
    IMAGE_SUBSYSTEM_EFI_ROM(13 as short),
    IMAGE_SUBSYSTEM_XBOX(14 as short)

    private final short subsystem
    private static Map map = new HashMap<>();

    Subsystem(short value) {
        subsystem = value
    }

    static {
        for (Subsystem subsystem : values()) {
            map.put(subsystem.subsystem, subsystem);
        }
    }

    public static Subsystem valueOf(short subsystem) {
        return (Subsystem) map.get(subsystem);
    }

    short getSubsystem() {
        return subsystem
    }
}