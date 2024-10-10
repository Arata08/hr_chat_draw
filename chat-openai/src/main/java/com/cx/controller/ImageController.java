package com.cx.controller;


import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenXing
 * 2024/6/27 下午3:44
 * describe：
 */
@RestController()
@RequestMapping("aiimage")
public class ImageController {
    @Resource
    private OpenAiImageModel openAiImageModel;

    @RequestMapping("/openaiImage")
    public Object openaiImage(String msg){
        final ImageResponse call = openAiImageModel.call(new ImagePrompt(msg));
        return call.getResult().getOutput();
    }

    @RequestMapping("/openaiImage2")
    public String  openaiImage2(@RequestParam("msg") String msg){
        final ImageResponse call = openAiImageModel.call(new ImagePrompt(msg, OpenAiImageOptions.builder()
                .withQuality("hd")//清晰度
                .withN(1)
                .withHeight(1024)
                .withWidth(1024)
                .build()
        ));
        System.out.println(call.getResult().getOutput());
        return call.getResult().getOutput().toString();
    }
}
