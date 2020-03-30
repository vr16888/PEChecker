package headers

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
    public final short[] Reserved

    /** OEM identifier (for OEMinfo) */
    public final short OEMid

    /** OEM information; OEMid specific */
    public final short OEMinfo

    /** Reserved words */
    public final short[] Reserved2

    /** NtHeader Offset */
    public final int AddressOfNewExeHeader

    public DOSHeader(Byte[] bytes) {
        if (bytes.length == HEADER_LENGTH) {

        }
    }
}
