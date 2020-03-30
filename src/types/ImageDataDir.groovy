package types

class ImageDataDir {
    private int virtualAddress;
    private int size;

    ImageDataDir(int virtualAddress, int size) {
        this.virtualAddress = virtualAddress
        this.size = size
    }
}
