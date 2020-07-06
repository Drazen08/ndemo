package io.nd.buffer;

import io.nd.util.ReferenceCounted;

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
 * @date ：Created in 2020/7/2 16:09
 * @description：
 */
public abstract class Bytebuf implements ReferenceCounted, Comparable<Bytebuf> {


    /**
     * 返回 bytebuf 的字节量
     */
    public abstract int capacity();

    /**
     * 调整bytebuf 的字节长度至指定长度 {@param newCapacity}
     */
    public abstract int capacity(int newCapacity);


    /**
     * 返回此缓冲区允许的最大容量
     */
    public abstract int maxCapacity();


    public abstract ByteBufAllocator allocator();

    public abstract ByteOrder byteOrder();

    public abstract Bytebuf order(ByteOrder endianness);

    public abstract Bytebuf unwrap();

    public abstract boolean isDirect();

    public abstract int readIndex();

    /**
     * 设置读游标
     *
     * @param readIndex
     * @return
     */
    public abstract Bytebuf readIndex(int readIndex);

    public abstract int writeIndex();

    public abstract Bytebuf writeIndex(int writeIndex);

    public abstract Bytebuf setIndex(int readIndex, int writeIndex);

    /**
     * 可读字节数长度
     * this.writerindex - this.readindex
     */
    public abstract int readableBytes();

    /**
     * 可写字节数长度
     * this.capacity - this.writerIndex
     */
    public abstract int writeableBytes();


    /**
     * this.maxCapacity - this.writeableBytes
     */
    public abstract int maxWriteableIndex();

    /**
     * this.readableBytes() > 0
     */
    public abstract boolean isReadable();


    public abstract boolean isReadable(int size);

    /**
     * this.writeableBytes() > 0
     */
    public abstract boolean isWriteable();


    public abstract boolean isWriteable(int size);

    /**
     * 设置读写游标为0
     */
    public abstract Bytebuf clear();

    /**
     * 标记读游标位置
     */
    public abstract Bytebuf markReaderIndex();

    /**
     * 还原读游标位置
     */
    public abstract Bytebuf resetReaderIndex();


    public abstract Bytebuf markWriteIndex();

    public abstract Bytebuf resetWriteindex();

    /**
     * 丢弃 0 - this.readIndex 之间的byte数据
     * 并把 readindex ， writeindex 之间的byte数组移到最初位
     * 并把 readindex , writeindex 设置为 0
     */
    public abstract Bytebuf discardReadBytes();

    /**
     *
     */
    public abstract Bytebuf discardSomeReadBytes();


    public abstract boolean getBoolean(int index);

    public abstract byte getByte(int index);

    public abstract short getUnsignedByte(int index);

    public abstract short getShort(int index);

    public abstract int getUnsignedShort(int index);

    public abstract int getMedium(int index);

    public abstract int getUnsignedMedium(int index);

    public abstract int getInt(int index);

    public abstract long getUnsignedInt(int index);

    public abstract long getLong(int index);

    public abstract long getUnsignedLong(int index);

    public abstract char getChar(int index);

    public abstract float getFloat(int index);

    public abstract double getDouble(int index);


    /**
     * 把本bytebuf 的数据转换到入参 {@code dst} 中
     * 以 {@code} index 为起点
     *
     * @param index
     * @param dst
     */
    public abstract Bytebuf getBytes(int index, Bytebuf dst);

    public abstract Bytebuf getBytes(int index, Bytebuf dst, int length);


    /**
     * @param index    数据源 bytebuf 的游标起点
     * @param dst      目标bytebuf
     * @param dstIndex 目标bytebuf的游标起点
     * @param length   复制的byte 长度
     */
    public abstract Bytebuf getBytes(int index, Bytebuf dst, int dstIndex, int length);


    public abstract Bytebuf getBytes(int index, byte[] dst);

    public abstract Bytebuf getBytes(int index, byte[] dst, int dstIndex, int length);

    public abstract Bytebuf getBytes(int index, ByteBuffer dst);

    public abstract Bytebuf getBytes(int index, ByteBuffer dst, int dstIndex, int length);

    public abstract Bytebuf getBytes(int index, OutputStream out, int length) throws IOException;

    /**
     * 转发 bytebuf 的数据到特定的channel
     */
    public abstract int getBytes(int index, GatheringByteChannel out, int length) throws IOException;

    public abstract Bytebuf setBoolean(int index, boolean value);


    public abstract Bytebuf setByte(int index, int value);

    public abstract Bytebuf setShort(int index, int value);

    public abstract Bytebuf setMedium(int index, int value);

    public abstract Bytebuf setInt(int index, int value);

    public abstract Bytebuf setLong(int index, long value);

    public abstract Bytebuf setChar(int index, int value);

    public abstract Bytebuf setFloat(int index, float value);

    public abstract Bytebuf setDouble(int index, double value);

    public abstract Bytebuf setBytes(int index, Bytebuf src);

    public abstract Bytebuf setBytes(int index, Bytebuf src, int length);


    public abstract Bytebuf setBytes(int index, byte[] src);

    public abstract Bytebuf setBytes(int index, byte[] src, int srcIndex, int length);

    public abstract Bytebuf setBytes(int index, ByteBuffer src);

    public abstract int setBytes(int index, InputStream in, int length) throws IOException;

    public abstract int setBytes(int index, ScatteringByteChannel in, int length) throws IOException;

    public abstract Bytebuf setZero(int index, int length);

    /**
     * 当前游标的boolean 值
     */
    public abstract boolean readBoolean();

    public abstract byte readByte();

    public abstract short readUnsignedByte();

    public abstract short readShort();

    public abstract int readUnsignedShort();

    public abstract int readMedium();

    public abstract int readUnsignedMedium();

    public abstract int readInt();

    public abstract long readUnsingedInt();

    public abstract long readLong();

    public abstract char readChar();

    public abstract float readFloat();

    /**
     * 创建新bytebuf 把定长字节数组复制到新 bytebuf 中
     *
     * @param length
     * @return
     */
    public abstract Bytebuf readBytes(int length);

    /**
     * 分片读
     */
    public abstract Bytebuf readSlice(int length);

    public abstract Bytebuf readBytes(Bytebuf dst);

    public abstract Bytebuf readBytes(Bytebuf dst, int length);

    public abstract Bytebuf readBytes(Bytebuf dst, int dstIndex, int length);

    public abstract Bytebuf readBytes(byte[] dst);

    public abstract Bytebuf readBytes(byte[] dst, int dstIndex, int length);

    public abstract Bytebuf readBytes(ByteBuffer byteBuffer);

    public abstract Bytebuf readBytes(OutputStream outputStream, int length);

    public abstract Bytebuf readBytes(GatheringByteChannel out, int length);

    /**
     * 增加读游标
     */
    public abstract Bytebuf skipBytes(int length);

    public abstract Bytebuf writeBoolean(boolean value);

    public abstract Bytebuf writeByte(int value);

    public abstract Bytebuf writeShort(int value);

    public abstract Bytebuf writeMedium(int value);

    public abstract Bytebuf writeInt(int value);

    public abstract Bytebuf writeLong(long value);

    public abstract Bytebuf writeChar(int value);

    public abstract Bytebuf writeFloat(float value);

    public abstract Bytebuf writeDouble(double value);

    public abstract Bytebuf writeBytes(Bytebuf src);

    public abstract Bytebuf writeBytes(Bytebuf src, int length);

    public abstract Bytebuf writeBytes(Bytebuf src, int srcIndex, int length);

    public abstract Bytebuf writeBytes(byte[] src);

    public abstract Bytebuf writeBytes(byte[] src, int srcIndex, int length);

    public abstract Bytebuf writeBytes(InputStream in, int length);

    public abstract Bytebuf writeBytes(ScatteringByteChannel channel, int length);

    public abstract Bytebuf writeZero(int length);

    public abstract Bytebuf indexOf(int from, int to, byte value);

    public abstract int bytesBefore(byte value);

    public abstract int bytesBefore(int length, byte value);

    public abstract int bytesBefore(int index, int length, byte value);

    public abstract int forEachByte(ByteBufProcessor processor);

    public abstract int forEachByte(int index, int length, ByteBufProcessor processor);

    public abstract int forEachByteDesc(ByteBufProcessor processor);

    public abstract int forEachByteDesc(int index, int length, ByteBufProcessor processor);

    /**
     * 复制 bytebuf 的可读数组
     *
     * @return
     */
    public abstract Bytebuf copy();

    public abstract Bytebuf copy(int index, int length);

    public abstract Bytebuf slice();

    public abstract Bytebuf slice(int index, int length);

    public abstract Bytebuf duplicate();

    public abstract int nioBufferCount();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int index, int length);

    public abstract ByteBuffer internalNioBuffer(int index, int length);

    public abstract ByteBuffer[] nioBuffers(int index, int length);

    public abstract boolean hasArray();

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasMemoryAddress();

    /**
     * 返回内存地址
     *
     * @return
     */
    public abstract long memoryAddress();

    public abstract String toString(Charset charset);

    public abstract String toString(int index, int length, Charset charset);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int compareTo(Bytebuf buffer);


    @Override
    public abstract String toString();

    @Override
    public abstract Bytebuf retain(int increment);

    @Override
    public abstract Bytebuf retain();




}
