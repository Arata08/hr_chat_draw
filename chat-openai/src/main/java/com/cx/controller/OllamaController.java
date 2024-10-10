package com.cx.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ChenXing
 * 2024/6/27 下午1:48
 * describe：
 */

@RestController()
@RequestMapping("ai")
public class OllamaController {
     @Resource
    private OllamaChatModel ollamaChatModel;

     @RequestMapping(value = "/ollama")
     public Object ollama(@RequestParam("msg") String message) {
         System.out.println("ai/ollama");
         return ollamaChatModel.call(message);
     }

     /*
     * 指定大模型版本
     * 指定创新性
     * */
    @RequestMapping(value = "/ollama2")
    public Object ollama2(@RequestParam("msg") String message) {
        System.out.println("指定创新性");
        ollamaChatModel.call(new Prompt(message, OllamaOptions.create()
                .withModel("qwen2:0.5b")
                .withTemperature(0.5F)
            )
        );
        System.out.println("版本：qwen2:0.5b--------温度：0.5");
        System.out.println(ollamaChatModel.call(message));
        return ollamaChatModel.call(message);
    }



    /*
     * 使用流式信息返回数据
     * */
    @RequestMapping(value = "/ollama3")
    public Object ollama3(@RequestParam("msg") String message) {
        System.out.println("指定创新性");
        Flux<ChatResponse> strem = ollamaChatModel.stream(new Prompt(message, OllamaOptions.create()
                .withModel("qwen2:0.5b")
                .withTemperature(0.5F))
        );
        return strem.collectList();
    }
}
