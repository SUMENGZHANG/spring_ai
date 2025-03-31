package spring.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sumengzhang <zhangsumeng.zsm@alibaba-inc.com>
 * @version 1.0
 * @since 2025/3/31
 */

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }
    @GetMapping("/hello")
    public String sayHello() {
        return this.chatClient.prompt("hello").call().content();
    }
}

