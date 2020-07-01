package io.nd.channel;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:27
 * @description：
 */
public interface ChannelFactory<T extends Channel> {

    T newInstance();

}
