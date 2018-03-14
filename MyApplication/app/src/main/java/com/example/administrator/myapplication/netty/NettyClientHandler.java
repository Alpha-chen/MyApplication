package com.example.administrator.myapplication.netty;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Title: NettyClientHandler
 * Description:
 * 客户端业务逻辑实现
 * Version:1.0.0
 *
 * @author pancm
 * @date 2017-8-31
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {

    private CallBack callBack;

    public NettyClientHandler(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端接受的消息: " + msg);
        callBack.serverMessage(msg);
    }

    //
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("正在连接... ");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接关闭! ");
        super.channelInactive(ctx);
    }

    public interface CallBack {
        public void serverMessage(String message);
    }
}

