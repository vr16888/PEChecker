import headers.COFFHeader
import headers.DOSHeader
import headers.OptionalHeader

class PE {
    /** Constants */
    private static final int IMAGE_DOS_SIGNATURE = 0x5A4D            // MZ
    private static final int IMAGE_NT_SIGNATURE = 0x00004550         // PE00
    private static final int IMAGE_FILE_MACHINE_I386 = 0x014C        // Intel 386
    private static final int IMAGE_FILE_MACHINE_IA64 = 0x0200        // Intel 64
    private static final int IMAGE_FILE_MACHINE_AMD64 = 0x8664       // AMD64
    private static final int IMAGE_NT_OPTIONAL_HDR32_MAGIC = 0x10B   // PE32
    private static final int IMAGE_NT_OPTIONAL_HDR64_MAGIC = 0x20B   // PE32+6
    private static final int IMAGE_FILE_DLL = 0x2000                 // DLL bit
    private static final int PE_OFFSET_LOCATION = 0x3c               // PE header offset

    /** Headers */
    private DOSHeader dosHeader
    private COFFHeader coffHeader
    private OptionalHeader optionalHeader
}
