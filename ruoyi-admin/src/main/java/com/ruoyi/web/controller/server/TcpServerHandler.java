package com.ruoyi.web.controller.server;

import com.ruoyi.web.controller.transmessage.TransServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ruoyi.web.controller.transmessage.StringToHex;


public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {

    private static Logger log = LogManager.getLogger(TcpServerHandler.class);

    private final String OPENFAN ="01";
    private final String CLOSEFAN ="02";
    private final String OPENFANTWO ="03";
    private final String CLOSEFANTWO ="04";
    private final String OPENGUA ="05";
    private final String CLOSEGUA ="06";
    private final String OPENCHUANG ="07";
    private final String CLOSECHUANG ="08";
    private final String OPENTOU ="09";
    private final String CLOSETOU = "10";
    private final String OPENSHUI = "11";
    private final String CLOSESHUI = "12";
    private final String SUCCEED = "1";
    private final String FAILED = "0";
    private final String OPENGUAFENTWO = "13";
    private final String CLOSEGUATWO = "14";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg.toString().charAt(0) == 'T') {
            log.info("TCP Server收到温度设定范围指令：" + msg);
            ctx.channel().writeAndFlush(SUCCEED);
            TransServerHandler.sendMessage(msg.toString());
            return;
        }
        else if (msg.toString().charAt(0) == 'L'){
            log.info("TCP Server收到湿度设定范围指令：" + msg);
            ctx.channel().writeAndFlush(SUCCEED.trim());
            TransServerHandler.sendMessage(msg.toString());
            return;
        }
        else {
            switch (msg.toString()) {
                case OPENFAN:
                    log.info("TCP Server收到开启风扇1的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSEFAN:
                    log.info("TCP Server收到关闭风扇1的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED.trim());
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENFANTWO:
                    log.info("TCP Server收到开启风扇2的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSEFANTWO:
                    log.info("TCP Server收到关闭风扇2的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENGUA:
                    log.info("TCP Server收到开启刮粪板的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSEGUA:
                    log.info("TCP Server收到复位刮粪板的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENCHUANG:
                    log.info("TCP Server收到开启水帘的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSECHUANG:
                    log.info("TCP Server收到关闭水帘的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENTOU:
                    log.info("TCP Server收到开启投食的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSETOU:
                    log.info("TCP Server收到关闭投食的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENSHUI:
                    log.info("TCP Server收到开启喂水的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSESHUI:
                    log.info("TCP Server收到关闭喂水的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case OPENGUAFENTWO:
                    log.info("TCP Server收到开启刮粪板2的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                case CLOSEGUATWO:
                    log.info("TCP Server收到关闭刮粪板2的指令：" + msg);
                    ctx.channel().writeAndFlush(SUCCEED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
                    break;
                default:
                    log.info("不明指令：" + msg);
                    ctx.channel().writeAndFlush(FAILED);
                    TransServerHandler.sendMessage("S" + msg + "E\n");
            }

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught!cause:" + cause.toString());
        ctx.close();
    }

}
