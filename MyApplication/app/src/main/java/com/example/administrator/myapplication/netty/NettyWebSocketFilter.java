package com.example.administrator.myapplication.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by xupangen on 2018/3/12.
 */

public class NettyWebSocketFilter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline  = socketChannel.pipeline();

    }
}
