package com.websocket.chat.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.websocket.chat.websocket.model.Greeting;
import com.websocket.chat.websocket.model.Message;

@Controller
public class GreetingController {


    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        return new Greeting(HtmlUtils.htmlEscape(message.getName()) + " : " + HtmlUtils.htmlEscape(message.getMessage()));

    }
    

}