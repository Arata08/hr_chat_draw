package com.cx.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ChenXing
 * 2024/6/28 上午9:11
 * describe：
 */
@RestController("aitts")
public class TTSController {


    /*
    * 文字转音频大模型
    * */
    @Resource
    private OpenAiAudioSpeechModel  openAiAudioSpeechModel;

    @RequestMapping(value = "/tts")
    public Object tts(@RequestParam("text") String text) {
        final byte[] call = openAiAudioSpeechModel.call(text);
        boolean bool = savetoFile("D:\\java\\ollama_model\\openai.mp3",call);
        if (bool) {
            return "save success";
        }else {
            return "save fail";
        }
    }


    /*
    * 保存音频文件
    * */
    private static boolean savetoFile(String fileName, byte[] aduio) {
        FileOutputStream fos = null;
        try {
            File file = new File(fileName);
            File parent = file.getParentFile();
            if (!parent.exists() && !parent.mkdirs()) {
                return false;
            }
            fos =new FileOutputStream(file);
            fos.write(aduio);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
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
