import enums.MachineType
import headers.COFFHeader
import headers.DOSHeader
import headers.OptionalHeader

import java.nio.ByteBuffer
import java.nio.ByteOrder

class PE {
    /** Constants */
    private static final short IMAGE_DOS_SIGNATURE = 0x5A4D            // MZ
    private static final int IMAGE_NT_SIGNATURE = 0x00004550           // PE00
    private static final short IMAGE_NT_OPTIONAL_HDR32_MAGIC = 0x10B   // PE32
    private static final short IMAGE_NT_OPTIONAL_HDR64_MAGIC = 0x20B   // PE32+6
    private static final short IMAGE_FILE_DLL = 0x2000                 // DLL bit

    /** Headers */
    private DOSHeader dosHeader
    private int signature
    private COFFHeader coffHeader
    private OptionalHeader optionalHeader

    PE(String fileName) {
        File file = new File(fileName)
        ByteArrayInputStream bytes = new ByteArrayInputStream(file.getBytes())

        dosHeader = new DOSHeader(bytes)
        bytes.reset()
        bytes.skip(dosHeader.AddressOfNewExeHeader)

        signature = ByteBuffer.wrap(bytes.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        coffHeader = new COFFHeader(bytes)
        optionalHeader = new OptionalHeader(bytes)
    }

    public boolean IsPE() {
        if (dosHeader.MZSignature != IMAGE_DOS_SIGNATURE) {
            return false
        }

        if (signature != IMAGE_NT_SIGNATURE) {
            return false
        }

        if (coffHeader.Characteristics & IMAGE_FILE_DLL) {
            return false
        }

        switch (coffHeader.Machine) {
            case MachineType.IMAGE_FILE_MACHINE_I386:
                return optionalHeader.MAGIC_NUMBER.getMagicNumber() == IMAGE_NT_OPTIONAL_HDR32_MAGIC

            case MachineType.IMAGE_FILE_MACHINE_AMD64:
            case MachineType.IMAGE_FILE_MACHINE_IA64:
                return optionalHeader.MAGIC_NUMBER.getMagicNumber() == IMAGE_NT_OPTIONAL_HDR64_MAGIC
        }

        return true
    }
}
