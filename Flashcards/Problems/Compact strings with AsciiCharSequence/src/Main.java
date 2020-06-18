class AsciiCharSequence implements CharSequence {
    byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] bytes1 = new byte[end - start];
        for (int i = start; i < end; i++) {
            bytes1[i - start] = bytes[i];
        }
        return new AsciiCharSequence(bytes1);
    }

    @Override
    public String toString() {
        return new String(this.bytes);
    }
    // implementation

}
