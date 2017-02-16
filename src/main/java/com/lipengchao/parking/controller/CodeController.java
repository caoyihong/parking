package com.lipengchao.parking.controller;

import com.lipengchao.parking.common.Param;
import com.lipengchao.parking.util.TwoDimensionCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by teli on 2017/2/14.
 */
@Controller
@RequestMapping("/code")
public class CodeController {

    /**
     * 获取停车场信息二维码
     * @param request
     */
    @RequestMapping("/parkcode")
    public void parkCode(HttpServletRequest request, HttpServletResponse response){
        TwoDimensionCodeUtil codeUtil = new TwoDimensionCodeUtil();
        String content = Param.URL+"park/parkInfo";
        String path = request.getSession().getServletContext().getRealPath("static/file/");
        String filePath = path+"cc.png";
        System.out.println(filePath);
        codeUtil.encoderQRCode(content,filePath);
        File file = new File(filePath);
        if (file.exists()){
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition","attachment;fileName="+"cc.png");//设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1){
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (bis != null){
                    try {
                        bis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if (fis != null){
                    try {
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
//        System.out.println("success.");
    }
    /**
     * 获取指定车位信息二维码
     * @param request
     */
    @RequestMapping("/carportcode")
    public void carPortCode(HttpServletRequest request, HttpServletResponse response){
        String carportcodeno = request.getParameter("carportno");
        TwoDimensionCodeUtil codeUtil = new TwoDimensionCodeUtil();
        String content = "www.baidu.com";
        String path = request.getSession().getServletContext().getRealPath("static/file/");
        String filePath = path+"cw"+carportcodeno+".png";
        System.out.println(filePath);
        codeUtil.encoderQRCode(content,filePath);
        File file = new File(filePath);
        if (file.exists()){
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition","attachment;fileName="+"cw"+carportcodeno+".png");//设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1){
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (bis != null){
                    try {
                        bis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if (fis != null){
                    try {
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
//        System.out.println("success.");
    }
}
