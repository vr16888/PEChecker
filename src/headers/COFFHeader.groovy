package headers

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.sql.Timestamp

class COFFHeader {
    private static final int HEADER_LENGTH = 20

    /** The CPU that this file is intended for */
    public final short Machine

    /** The number of sections in the file. */
    public final short NumberOfSections

    /**
     * The time that the linker (or compiler for an OBJ file) produced this file. This field holds the number of seconds since December
     * 31st, 1969, at 4:00 P.M. (PST)
     */
    public final int TimeDateStamp

    /**
     * The file offset of the COFF symbol table. This field is only used in OBJ files and PE files with COFF debug information. PE files
     * support multiple debug formats, so debuggers should refer to the IMAGE_DIRECTORY_ENTRY_DEBUG entry in the data directory (defined
     * later).
     */
    public final int PointerToSymbolTable

    /** The number of symbols in the COFF symbol table. See above. */
    public final int NumberOfSymbols

    /**
     * The size of an optional header that can follow this structure. In OBJs, the field is 0. In executables, it is the size of the
     * IMAGE_OPTIONAL_HEADER structure that follows this structure.
     */
    public final short SizeOfOptionalHeader

    public COFFHeader(ByteArrayInputStream bytes) {
        DataInputStream dataInputStream = new DataInputStream(bytes)

        Machine = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        NumberOfSections = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        TimeDateStamp = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        PointerToSymbolTable = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        NumberOfSymbols = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SizeOfOptionalHeader = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
    }
}
