package com.frank.checkcode;


/**
* @author 作者 E-mail:
* @version 创建时间：2017年10月24日 上午11:14:33
* 类说明
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import java.util.Random;

import javax.imageio.ImageIO;


/**
 * 扭曲验证码
 * 
 * @return
 */
public class VerifyCodeUtils4 {

   public static BufferedImage getCode() {
        // 生成图片
        int ImgWidth = 120;
        int ImgHeight = 30;
        BufferedImage img = new BufferedImage(ImgWidth, ImgHeight, BufferedImage.TYPE_INT_BGR);
        // 转成可以画扭曲字符的画笔
        Graphics2D g = (Graphics2D) img.getGraphics();
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
        // random对象
        Random random = new Random();
        // void rotate(double,theta,double x,double y)
        // theta 弧度=jiaodu*Math.PI/180
        // 

        
        // 字的颜色
        g.setColor(Color.YELLOW);
        // 字体
        g.setFont(new Font("隶书", Font.BOLD, 20));
        // 随机获取下标 随机写字体
        int x = 20;
        int y = 20;
        for (int i = 0; i < 4; i++) {
            // 生成随机数得到随机字符
            int index = random.nextInt(words.length());
            char ch = words.charAt(index);
            // 生成随机弧度
            int jiaodu=random.nextInt(60)-30;// 角度正负30度
            double hudu=jiaodu*Math.PI/180;// 弧度
            // 
            g.rotate(hudu,x,y);
            // 画字符串
            g.drawString("" + ch, x, y);
            // 会累计旋转 所以要转回去
            g.rotate(-hudu,x,y);
            x += 20;
        }

        return img;
    }

	    
    public static void main(String[] args) throws IOException{  
        File dir = new File("D:/verifies");  
        for(int i = 0; i < 50; i++){  
            VerifyCodeUtils4 instance = new VerifyCodeUtils4();             
            BufferedImage image = instance.getCode();  
            File file = new File(dir, i + ".jpg");  
            ImageIO.write(image, "jpg", file);
        }  
    }
    
}