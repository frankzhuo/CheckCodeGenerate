package com.frank.checkcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * 日期:2016年10月18日:下午6:01:53
 * 程序作用:带有干扰线
**/
public class VerifyCodeUtils5 {

    public static BufferedImage getCode() {
        // 生成图片
        int ImgWidth = 120;
        int ImgHeight = 30;
        BufferedImage img = new BufferedImage(ImgWidth, ImgHeight, BufferedImage.TYPE_INT_BGR);
        // 得到画笔
        Graphics g = img.getGraphics();
        // 灰色
        g.setColor(Color.GRAY);
        // 填充画布
        g.fillRect(0, 0, ImgWidth, ImgHeight);
        // 蓝色
        g.setColor(Color.BLUE);
        // 边框
        g.drawRect(0, 0, ImgWidth - 1, ImgHeight - 1);
        // 数据 4个字符
        String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        // 字的颜色
        g.setColor(Color.YELLOW);
        // 字体
        g.setFont(new Font("隶书", Font.BOLD, 20));
        // 随机获取下标
        Random random = new Random();
        int x = 20;
        int y = 20;
        for (int i = 0; i < 4; i++) {
            // 生成随机数
            int index = random.nextInt(words.length());
            char ch = words.charAt(index);
            // 画字符串
            g.drawString("" + ch, x, y);
            x += 20;
        }
        // 画干扰线
        int x1, y1, x2, y2;
        g.setColor(Color.RED);
        int lineNum=4;
        for (int i = 0; i < lineNum; i++) {
            x1=random.nextInt(ImgWidth/2);
            y1=random.nextInt(ImgHeight/2);
            x2=random.nextInt(ImgWidth);
            y2=random.nextInt(ImgHeight);
            g.drawLine(x1, y1, x2, y2);
        }
        return img;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = getCode();
        File dir = new File("D:/verifies/aa.jpg");
        ImageIO.write(img, "jpg",dir);
    }

}