package io.nd.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/6 16:00
 * @description：
 */
public class SwappedBytebuf extends Bytebuf {

    private Bytebuf buf;

    private ByteOrder order;

    public SwappedBytebuf(Bytebuf buf) {
        if (buf == null) {
            throw new NullPointerException("buf");
        }
        this.buf = buf;
        if (buf.order() == ByteOrder.BIG_ENDIAN) {
            this.order = ByteOrder.LITTLE_ENDIAN;
        } else if (buf.order() == ByteOrder.LITTLE_ENDIAN) {
            this.order = ByteOrder.BIG_ENDIAN;
        }
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public int capacity(int newCapacity) {
        return 0;
    }

    @Override
    public int maxCapacity() {
        return 0;
    }

    @Override
    public ByteBufAllocator allocator() {
        return null;
    }

    @Override
    public ByteOrder order() {
        return order;
    }


    @Override
    public Bytebuf order(ByteOrder endianness) {
        if (null == endianness) {
            throw new NullPointerException("endianness");
        }
        if (endianness == order) {
            return this;
        }
        return buf;
    }

    @Override
    public Bytebuf unwrap() {
        return null;
    }

    @Override
    public boolean isDirect() {
        return false;
    }

    @Override
    public int readerIndex() {
        return 0;
    }

    @Override
    public Bytebuf readerIndex(int readerIndex) {
        return null;
    }


    @Override
    public int writerIndex() {
        return 0;
    }

    @Override
    public Bytebuf writerIndex(int writeIndex) {
        return null;
    }

    @Override
    public Bytebuf setIndex(int readIndex, int writeIndex) {
        return null;
    }

    @Override
    public int readableBytes() {
        return 0;
    }

    @Override
    public int writeableBytes() {
        return 0;
    }

    @Override
    public int maxWriteableIndex() {
        return 0;
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isReadable(int size) {
        return false;
    }

    @Override
    public boolean isWriteable() {
        return false;
    }

    @Override
    public boolean isWriteable(int size) {
        return false;
    }

    @Override
    public Bytebuf clear() {
        return null;
    }

    @Override
    public Bytebuf markReaderIndex() {
        return null;
    }

    @Override
    public Bytebuf resetReaderIndex() {
        return null;
    }

    @Override
    public Bytebuf markWriteIndex() {
        return null;
    }

    @Override
    public Bytebuf resetWriteindex() {
        return null;
    }

    @Override
    public Bytebuf discardReadBytes() {
        return null;
    }

    @Override
    public Bytebuf discardSomeReadBytes() {
        return null;
    }

    @Override
    public boolean getBoolean(int index) {
        return false;
    }

    @Override
    public byte getByte(int index) {
        return 0;
    }

    @Override
    public short getUnsignedByte(int index) {
        return 0;
    }

    @Override
    public short getShort(int index) {
        return 0;
    }

    @Override
    public int getUnsignedShort(int index) {
        return 0;
    }

    @Override
    public int getMedium(int index) {
        return 0;
    }

    @Override
    public int getUnsignedMedium(int index) {
        return 0;
    }

    @Override
    public int getInt(int index) {
        return 0;
    }

    @Override
    public long getUnsignedInt(int index) {
        return 0;
    }

    @Override
    public long getLong(int index) {
        return 0;
    }

    @Override
    public long getUnsignedLong(int index) {
        return 0;
    }

    @Override
    public char getChar(int index) {
        return 0;
    }

    @Override
    public float getFloat(int index) {
        return 0;
    }

    @Override
    public double getDouble(int index) {
        return 0;
    }

    @Override
    public Bytebuf getBytes(int index, Bytebuf dst) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, Bytebuf dst, int length) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, Bytebuf dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, byte[] dst) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, ByteBuffer dst) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, ByteBuffer dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf getBytes(int index, OutputStream out, int length) throws IOException {
        return null;
    }

    @Override
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return 0;
    }

    @Override
    public Bytebuf setBoolean(int index, boolean value) {
        return null;
    }

    @Override
    public Bytebuf setByte(int index, int value) {
        return null;
    }

    @Override
    public Bytebuf setShort(int index, int value) {
        return null;
    }

    @Override
    public Bytebuf setMedium(int index, int value) {
        return null;
    }

    @Override
    public Bytebuf setInt(int index, int value) {
        return null;
    }

    @Override
    public Bytebuf setLong(int index, long value) {
        return null;
    }

    @Override
    public Bytebuf setChar(int index, int value) {
        return null;
    }

    @Override
    public Bytebuf setFloat(int index, float value) {
        return null;
    }

    @Override
    public Bytebuf setDouble(int index, double value) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, Bytebuf src) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, Bytebuf src, int length) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, Bytebuf src, int srcIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, byte[] src) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, byte[] src, int srcIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf setBytes(int index, ByteBuffer src) {
        return null;
    }

    @Override
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return 0;
    }

    @Override
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        return 0;
    }

    @Override
    public Bytebuf setZero(int index, int length) {
        return null;
    }

    @Override
    public boolean readBoolean() {
        return false;
    }

    @Override
    public byte readByte() {
        return 0;
    }

    @Override
    public short readUnsignedByte() {
        return 0;
    }

    @Override
    public short readShort() {
        return 0;
    }

    @Override
    public int readUnsignedShort() {
        return 0;
    }

    @Override
    public int readMedium() {
        return 0;
    }

    @Override
    public int readUnsignedMedium() {
        return 0;
    }

    @Override
    public int readInt() {
        return 0;
    }

    @Override
    public long readUnsingedInt() {
        return 0;
    }

    @Override
    public long readLong() {
        return 0;
    }

    @Override
    public char readChar() {
        return 0;
    }

    @Override
    public float readFloat() {
        return 0;
    }

    @Override
    public Bytebuf readBytes(int length) {
        return null;
    }

    @Override
    public Bytebuf readSlice(int length) {
        return null;
    }

    @Override
    public Bytebuf readBytes(Bytebuf dst) {
        return null;
    }

    @Override
    public Bytebuf readBytes(Bytebuf dst, int length) {
        return null;
    }

    @Override
    public Bytebuf readBytes(Bytebuf dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf readBytes(byte[] dst) {
        return null;
    }

    @Override
    public Bytebuf readBytes(byte[] dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf readBytes(ByteBuffer byteBuffer) {
        return null;
    }

    @Override
    public Bytebuf readBytes(OutputStream outputStream, int length) {
        return null;
    }

    @Override
    public Bytebuf readBytes(GatheringByteChannel out, int length) {
        return null;
    }

    @Override
    public Bytebuf skipBytes(int length) {
        return null;
    }

    @Override
    public Bytebuf writeBoolean(boolean value) {
        return null;
    }

    @Override
    public Bytebuf writeByte(int value) {
        return null;
    }

    @Override
    public Bytebuf writeShort(int value) {
        return null;
    }

    @Override
    public Bytebuf writeMedium(int value) {
        return null;
    }

    @Override
    public Bytebuf writeInt(int value) {
        return null;
    }

    @Override
    public Bytebuf writeLong(long value) {
        return null;
    }

    @Override
    public Bytebuf writeChar(int value) {
        return null;
    }

    @Override
    public Bytebuf writeFloat(float value) {
        return null;
    }

    @Override
    public Bytebuf writeDouble(double value) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(Bytebuf src) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(Bytebuf src, int length) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(Bytebuf src, int srcIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(byte[] src) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(byte[] src, int srcIndex, int length) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(InputStream in, int length) {
        return null;
    }

    @Override
    public Bytebuf writeBytes(ScatteringByteChannel channel, int length) {
        return null;
    }

    @Override
    public Bytebuf writeZero(int length) {
        return null;
    }

    @Override
    public Bytebuf indexOf(int from, int to, byte value) {
        return null;
    }

    @Override
    public int bytesBefore(byte value) {
        return 0;
    }

    @Override
    public int bytesBefore(int length, byte value) {
        return 0;
    }

    @Override
    public int bytesBefore(int index, int length, byte value) {
        return 0;
    }

    @Override
    public int forEachByte(ByteBufProcessor processor) {
        return 0;
    }

    @Override
    public int forEachByte(int index, int length, ByteBufProcessor processor) {
        return 0;
    }

    @Override
    public int forEachByteDesc(ByteBufProcessor processor) {
        return 0;
    }

    @Override
    public int forEachByteDesc(int index, int length, ByteBufProcessor processor) {
        return 0;
    }

    @Override
    public Bytebuf copy() {
        return null;
    }

    @Override
    public Bytebuf copy(int index, int length) {
        return null;
    }

    @Override
    public Bytebuf slice() {
        return null;
    }

    @Override
    public Bytebuf slice(int index, int length) {
        return null;
    }

    @Override
    public Bytebuf duplicate() {
        return null;
    }

    @Override
    public int nioBufferCount() {
        return 0;
    }

    @Override
    public ByteBuffer nioBuffer() {
        return null;
    }

    @Override
    public ByteBuffer nioBuffer(int index, int length) {
        return null;
    }

    @Override
    public ByteBuffer internalNioBuffer(int index, int length) {
        return null;
    }

    @Override
    public ByteBuffer[] nioBuffers(int index, int length) {
        return new ByteBuffer[0];
    }

    @Override
    public boolean hasArray() {
        return false;
    }

    @Override
    public byte[] array() {
        return new byte[0];
    }

    @Override
    public int arrayOffset() {
        return 0;
    }

    @Override
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override
    public long memoryAddress() {
        return 0;
    }

    @Override
    public String toString(Charset charset) {
        return null;
    }

    @Override
    public String toString(int index, int length, Charset charset) {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int compareTo(Bytebuf buffer) {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Bytebuf retain(int increment) {
        return null;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int decrement) {
        return false;
    }

    @Override
    public int refCnt() {
        return 0;
    }

    @Override
    public Bytebuf retain() {
        return null;
    }
}
