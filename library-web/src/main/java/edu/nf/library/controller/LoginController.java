package edu.nf.library.controller;

import edu.nf.library.controller.BaseController;
import edu.nf.library.controller.vo.ResponseVO;
import edu.nf.library.entity.StaffMessage;
import edu.nf.library.service.StaffMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author dwd
 * @date 2019/12/2
 */
@RestController
public class LoginController extends BaseController {
    private static final long serialVersionUID = 1L;

    // 设置字母的大小,大小
    private Font mFont = new Font("Times New Roman", Font.PLAIN, 17);

    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    @RequestMapping("/code.jpg")
    public void verify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置头信息:设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 表明生成的响应是图片
        response.setContentType("image/jpeg");

        //在内存中创建图象
        int width = 100, height = 18;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();
        //实例化随机类对象
        Random random = new Random();

        // 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width - 1, height - 1);

        // 画边框
        g.setColor(new Color(102, 102, 102));
        g.drawRect(0, 0, width - 1, height - 1);

        // 设置字体、颜色
        g.setFont(mFont);
        g.setColor(getRandColor(160, 200));

        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl, y + yl);
        }

        // 从另一方向画随机线
        for (int i = 0; i < 70; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x, y, x - xl, y - yl);
        }

        // 生成随机数,并将随机数字转换为字母
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
            g.setColor(new Color(20 + random.nextInt(110),
                    20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(ctmp), 15 * i + 10, 16);
        }

        //把随机产生的六位字符设置在会话中
        HttpSession session = request.getSession(true);
        session.setAttribute("rand", sRand);

        // 图象生效
        g.dispose();
        // 输出图象到页面
        ImageIO.write(image, "JPEG", response.getOutputStream());

    }

    @Autowired
    private StaffMessageService service;

    @PostMapping("/staffLogin")
    public ResponseVO login(Integer id, String password, String code, HttpSession session) {
        String sRand = (String) session.getAttribute("rand");
        //if (code!=null&&sRand.equalsIgnoreCase(code)) {
        StaffMessage message = service.login(id, password);

        session.setAttribute("staffMessage", message);
        return success("index.html");
        //}
        //return fail(500,"验证码错误！请重新输入");
    }

    @PostMapping("/forGet.do")
    public ResponseVO forGet(Integer id, String phone) {
        return success(service.forGet(id, phone));
    }

    @PostMapping("/updatePassword")
    public ResponseVO updatePassword(Integer id, String passwrod) {
        service.updatePassword(id, passwrod);
        return success("密码修改成功！");
    }
    @GetMapping("/close")
    public ResponseVO close(HttpSession session){
        session.setAttribute("staffMessage",null);
        return success("退出成功");
    }
    @PostMapping("/verify")
    public ResponseVO verify(String password,HttpSession session){
       StaffMessage message=(StaffMessage) session.getAttribute("staffMessage");
       service.login(message.getStaffId(),password);
       return success("成功");
    }
}