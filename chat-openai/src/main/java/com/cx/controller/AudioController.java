package com.cx.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ChenXing
 * 2024/6/28 上午10:22
 * describe：
 */
@RequestMapping("ai")
public class AudioController {

    /*
    *  @Resource
    * 音频转文本
    * */
    @Resource
    private OpenAiAudioTranscriptionModel  openAiAudioTranscriptionModel;

    @RequestMapping(value = "/audioText")
    public Object audioText() {
        //获取音频文件，到resource下加载opaenai.mp3文件
        org.springframework.core.io.Resource resource = new ClassPathResource("opaenai.mp3");
        //将音频文件传递给大模型进行转换成文本
        String call = openAiAudioTranscriptionModel.call(resource);
        System.out.println("转化后文本：" + call);

        //boolean save = saveFile("D:\\java\\ollama_model\\openai.txt",call);
        //if (save) {
        //    System.out.println("保存成功");
        //}else {
        //    System.out.println("保存失败");
        //}
        return call;
    }

    private static  boolean saveFile( String fileName,byte[] aduio)  {
        FileOutputStream fos=null;
        try {
            File file=new File(fileName);
            File parent=  file.getParentFile();

            if(!parent.exists()&& !parent.mkdir()){
                return false;
            }else {
                fos=new FileOutputStream(file);
                fos.write(aduio);
                fos.flush();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

