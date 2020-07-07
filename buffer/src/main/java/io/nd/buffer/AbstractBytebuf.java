package io.nd.buffer;

import io.nd.util.IllegalReferenceCountException;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/6 14:08
 * @description：
 */
public abstract class AbstractBytebuf extends Bytebuf {

    private static final boolean checkAccessible = true;

    int readerIndex;

    int writerIndex;

    private int markedReaderIndex;

    private int markedWriterIndex;

    private int maxCapacity;

    private SwappedBytebuf swappedBytebuf;

    protected AbstractBytebuf(int capacity) throws IllegalAccessException {
        if (capacity < 0) {
            throw new IllegalAccessException(" init capacity must not be null ");
        }
        this.maxCapacity = capacity;
    }


    protected final void maxCapacity(int capacity) {
        this.maxCapacity = capacity;
    }

    @Override
    public int readerIndex() {
        return this.readerIndex;
    }


    @Override
    public Bytebuf readerIndex(int readerIndex) {
        if (readerIndex < 0 || readerIndex > writerIndex) {
            throw new IndexOutOfBoundsException(String.format(
                    "readerIndex: %d (expected: 0 <= readerIndex <= writerIndex(%d))", readerIndex, writerIndex));
        }
        this.readerIndex = readerIndex;
        return this;
    }

    @Override
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override
    public Bytebuf writerIndex(int writeIndex) {
        if (writeIndex < 0 || writeIndex > capacity()) {
            throw new IndexOutOfBoundsException(String.format(
                    "writerIndex: %d (expected: readerIndex(%d) <= writerIndex <= capacity(%d))",
                    writerIndex, readerIndex, capacity()));
        }
        this.writerIndex = writeIndex;
        return this;
    }

    @Override
    public Bytebuf setIndex(int readIndex, int writeIndex) {
        if (readIndex < 0 || readIndex > writeIndex || writeIndex > capacity()) {
            throw new IndexOutOfBoundsException(String.format(
                    "readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))",
                    readerIndex, writerIndex, capacity()));
        }
        setIndex0(readerIndex, writerIndex);
        return this;
    }

    @Override
    public int maxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public Bytebuf clear() {
        this.readerIndex = this.writerIndex = 0;
        return this;
    }


    @Override
    public boolean isReadable() {
        return this.readerIndex > 0 && this.readerIndex < this.writerIndex;
    }

    @Override
    public boolean isReadable(int size) {
        return this.writerIndex - this.readerIndex >= size;
    }

    @Override
    public boolean isWriteable() {
        return this.writerIndex < capacity();
    }

    @Override
    public boolean isWriteable(int size) {
        return capacity() - this.writerIndex >= size;
    }

    @Override
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override
    public int writeableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override
    public int maxWriteableIndex() {
        return maxCapacity() - this.writerIndex;
    }

    @Override
    public Bytebuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    @Override
    public Bytebuf markWriteIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    @Override
    public Bytebuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override
    public Bytebuf resetWriteindex() {
        writerIndex(this.markedWriterIndex);
        return this;
    }

    @Override
    public Bytebuf discardReadBytes() {
        ensureAccessible();
        if (this.readerIndex == 0) {
            return this;
        }
        if (this.readerIndex != this.writerIndex) {
            setBytes(0, this, this.readerIndex, this.writerIndex - this.readerIndex);
            this.writerIndex -= this.readerIndex;
            adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
        } else {
            adjustMarkers(this.readerIndex);
            this.writerIndex = this.readerIndex = 0;
        }
        return this;
    }

    /**
     * 每次对buffer 数据释放前调用，如果相对的引用计数为0 那么认为有错
     */
    protected final void ensureAccessible() {
        if (checkAccessible && refCnt() == 0) {
            throw new IllegalReferenceCountException(0);
        }
    }

    /**
     * 释放（缩减）部分长度的buffer
     */
    protected final void adjustMarkers(int decrement) {
        int markedReadIndex = this.markedReaderIndex;
        if (markedReadIndex <= decrement) {
            this.markedReaderIndex = 0;
            int markedWriteIndex = this.markedWriterIndex;
            if (markedWriteIndex <= decrement) {
                this.markedWriterIndex = 0;
            } else {
                this.markedWriterIndex = markedWriteIndex - decrement;
            }
        } else {
            this.markedReaderIndex = markedReadIndex - decrement;
            this.markedWriterIndex -= decrement;
        }
    }

    final void setIndex0(int readerIndex, int writerIndex) {
        this.readerIndex = readerIndex;
        this.writerIndex = writerIndex;
    }

}

