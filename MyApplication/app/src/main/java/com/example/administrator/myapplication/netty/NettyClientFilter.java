package com.example.administrator.myapplication.netty;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Title: NettyClientFilter
 * Description:
 * Netty客户端 过滤器
 * Version:1.0.0
 *
 * @author pancm
 * @date 2017-8-31
 */
public class NettyClientFilter extends ChannelInitializer<SocketChannel> {
    private NettyClientHandler.CallBack callBack;

    public NettyClientFilter(NettyClientHandler.CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception {
        ChannelPipeline ph = socketChannel.pipeline();
        /*
         * 解码和编码，应和服务端一致
         * */
        ph.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        ph.addLast("decoder", new StringDecoder());
        ph.addLast("encoder", new StringEncoder());
        ph.addLast("handler", new NettyClientHandler(callBack)); //客户端的逻辑
    }
}