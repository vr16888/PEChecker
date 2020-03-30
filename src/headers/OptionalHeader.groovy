package headers

import types.ImageDataDir

import java.nio.ByteBuffer
import java.nio.ByteOrder

class OptionalHeader {

    private boolean IS_32_BIT

    /** Standard fields */
    public final short MAGIC_NUMBER
    public final byte MAJOR_LINKER_VERSION
    public final byte MINOR_LINKER_VERSION
    public final int SIZE_OF_CODE
    public final int SIZE_OF_INIT_DATA
    public final int SIZE_OF_UNINIT_DATA
    public final int ADDR_OF_ENTRY_POINT
    public final int BASE_OF_CODE
    public final int BASE_OF_DATA

    /** NT additional fields */
    public final long IMAGE_BASE
    public final int SECTION_ALIGNMENT
    public final int FILE_ALIGNMENT
    public final short MAJOR_OS_VERSION
    public final short MINOR_OS_VERSION
    public final short MAJOR_IMAGE_VERSION
    public final short MINOR_IMAGE_VERSION
    public final short MAJOR_SUBSYSTEM_VERSION
    public final short MINOR_SUBSYSTEM_VERSION
    public final int WIN32_VERSION_VALUE
    public final int SIZE_OF_IMAGE
    public final int SIZE_OF_HEADERS
    public final int CHECKSUM
    public final short SUBSYSTEM
    public final short DLL_CHARACTERISTICS

    public final long SIZE_OF_STACK_RESERVE
    public final long SIZE_OF_STACK_COMMIT
    public final long SIZE_OF_HEAP_RESERVE
    public final long SIZE_OF_HEAP_COMMIT
    public final int LOADER_FLAGS
    public final int NUMBER_OF_RVA_AND_SIZES

    /** Image data directories */
    public final ImageDataDir EXPORT_TABLE
    public final ImageDataDir IMPORT_TABLE
    public final ImageDataDir RESOURCE_TABLE
    public final ImageDataDir EXCEPTION_TABLE
    public final ImageDataDir CERTIFICATE_TABLE
    public final ImageDataDir BASE_RELOCATION_TABLE
    public final ImageDataDir DEBUG
    public final ImageDataDir COPYRIGHT
    public final ImageDataDir GLOBAL_PTR
    public final ImageDataDir TLS_TABLE
    public final ImageDataDir LOAD_CONFIG_TABLE
    public final ImageDataDir BOUND_IMPORT
    public final ImageDataDir IAT
    public final ImageDataDir DELAY_IMPORT_DESCRIPTOR
    public final ImageDataDir CLR_RUNTIME_HEADER

    public final byte[] Reserved

    public OptionalHeader(ByteArrayInputStream bytes) {
        DataInputStream dataInputStream = new DataInputStream(bytes)

        MAGIC_NUMBER = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MAJOR_LINKER_VERSION = dataInputStream.readByte()
        MINOR_LINKER_VERSION = dataInputStream.readByte()
        SIZE_OF_CODE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SIZE_OF_INIT_DATA = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SIZE_OF_UNINIT_DATA = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        ADDR_OF_ENTRY_POINT = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        BASE_OF_CODE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        BASE_OF_DATA = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()

        IS_32_BIT = MAGIC_NUMBER == 1234

        if (IS_32_BIT) {
            IMAGE_BASE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        } else {
            IMAGE_BASE = ByteBuffer.wrap(dataInputStream.readNBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong()
        }

        SECTION_ALIGNMENT = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        FILE_ALIGNMENT = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()

        MAJOR_OS_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MINOR_OS_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MAJOR_IMAGE_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MINOR_IMAGE_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MAJOR_SUBSYSTEM_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MINOR_SUBSYSTEM_VERSION = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()

        WIN32_VERSION_VALUE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SIZE_OF_IMAGE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SIZE_OF_HEADERS = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        CHECKSUM = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        SUBSYSTEM = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        DLL_CHARACTERISTICS = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()

        if (IS_32_BIT) {
            SIZE_OF_STACK_RESERVE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
            SIZE_OF_STACK_COMMIT = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
            SIZE_OF_HEAP_RESERVE = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
            SIZE_OF_HEAP_COMMIT = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        } else {
            SIZE_OF_STACK_RESERVE = ByteBuffer.wrap(dataInputStream.readNBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong()
            SIZE_OF_STACK_COMMIT = ByteBuffer.wrap(dataInputStream.readNBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong()
            SIZE_OF_HEAP_RESERVE = ByteBuffer.wrap(dataInputStream.readNBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong()
            SIZE_OF_HEAP_COMMIT = ByteBuffer.wrap(dataInputStream.readNBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong()
        }

        LOADER_FLAGS = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
        NUMBER_OF_RVA_AND_SIZES = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()

        EXPORT_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        RESOURCE_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        EXCEPTION_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        CERTIFICATE_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        BASE_RELOCATION_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())

        BASE_RELOCATION_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        COPYRIGHT = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        GLOBAL_PTR = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        TLS_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        LOAD_CONFIG_TABLE = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())

        BOUND_IMPORT = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        IAT = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        DELAY_IMPORT_DESCRIPTOR = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())
        CLR_RUNTIME_HEADER = new ImageDataDir(ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(),
                ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt())

        Reserved = dataInputStream.readNBytes(8)
    }
}
