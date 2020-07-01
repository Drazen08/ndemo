package io.nd.boot;

import io.nd.channel.Channel;
import io.nd.util.ObjectUtil;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:17
 * @description：
 */
public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {

    protected final B bootstrap;

    public AbstractBootstrapConfig(B bootstrap) {
        this.bootstrap = ObjectUtil.checkNull(bootstrap, "bootstrap");
    }

}
