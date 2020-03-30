package headers

import java.nio.ByteBuffer
import java.nio.ByteOrder

class DOSHeader {
    private static final int HEADER_LENGTH = 64

    /** IMAGE_DOS_SIGNATURE = 0x5A4D */
    public final short MZSignature

    /** Bytes on last page of file */
    public final short UsedBytesInTheLastPage

    /** Pages in file */
    public final short FileSizeInPages

    /** Relocations */
    public final short NumberOfRelocationItems

    /** Size of header in paragraphs */
    public final short HeaderSizeInParagraphs

    /** Minimum extra paragraphs needed*/
    public final short MinimumExtraParagraphs

    /** Maximum extra paragraphs needed */
    public final short MaximumExtraParagraphs

    /** Initial (relative) SS value */
    public final short InitialRelativeSS

    /** Initial SP value */
    public final short InitialSP

    /** Checksum */
    public final short Checksum

    /** Initial IP value */
    public final short InitialIP

    /** Initial (relative) CS value */
    public final short InitialRelativeCS

    /** File address of relocation table */
    public final short AddressOfRelocationTable

    /** Overlay number */
    public final short OverlayNumber

    /** Reserved words */
    public final byte[] Reserved

    /** OEM identifier (for OEMinfo) */
    public final short OEMid

    /** OEM information; OEMid specific */
    public final short OEMinfo

    /** Reserved words */
    public final byte[] Reserved2

    /** NtHeader Offset */
    public final int AddressOfNewExeHeader

    public DOSHeader(ByteArrayInputStream bytes) {
        DataInputStream dataInputStream = new DataInputStream(bytes)

        MZSignature = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        UsedBytesInTheLastPage = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        FileSizeInPages = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        NumberOfRelocationItems = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        HeaderSizeInParagraphs = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MinimumExtraParagraphs = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        MaximumExtraParagraphs = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        InitialRelativeSS = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        InitialSP = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        Checksum = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        InitialIP = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        InitialRelativeCS = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        AddressOfRelocationTable = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        OverlayNumber = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        Reserved = dataInputStream.readNBytes(8)
        OEMid = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        OEMinfo = ByteBuffer.wrap(dataInputStream.readNBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort()
        Reserved2 = dataInputStream.readNBytes(20)
        AddressOfNewExeHeader = ByteBuffer.wrap(dataInputStream.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
    }
}
