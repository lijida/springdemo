package com.demo.mqtt.config;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import com.demo.utils.UuidUtil;

/**
 * @description:
 * @author: ynn
 * @create: 2020-10-22 13:51
 **/
@Configuration
@IntegrationComponentScan
@Slf4j
public class MqttConfig {

    /**
     * MQTT-用户名
     **/
    @Value("${spring.mqtt.username}")
    private String username;
    /**
     * MQTT-密码
     **/
    @Value("${spring.mqtt.password}")
    private String password;
    /**
     * MQTT-服务器连接地址，如果有多个，用逗号隔开
     **/
    @Value("${spring.mqtt.url}")
    private String hostUrl;
    /**
     * MQTT-默认的消息推送主题，实际可在调用接口时指定
     **/
    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;
    /**
     * MQTT-连接超时
     **/
    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout;
    /**
     * MQTT-连接服务器默认客户端ID
     **/
    private String clientId = UuidUtil.genUuidNoLine();

    private static String ON_LINE="iot/online/#";
    private static String ERROR="iot/error/#";
    private static String DEVICE_PUB="iot/devicePub/#";

    /**
     *  配置基本的链接信息
     * @return
     */
    private MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        //每隔30秒发送一次心跳包
        mqttConnectOptions.setKeepAliveInterval(30);
        return mqttConnectOptions;
    }

    /**
     *  初始化mqtt工厂
     * @return
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }

    /**
     * 配置Outbound出站，发布者发送的消息通道
     */
    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }


    /**
     *  配置Outbound出站，出站通道适配器
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        log.info("建立mqtt服务器连接，这次要连接的服务端ID为>>>"+clientId);
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
        // 设置异步发送，默认是false(发送时阻塞)
        messageHandler.setAsync(true);
        //只发送一次消息
        messageHandler.setDefaultQos(2);
        //不需要保留信息
        messageHandler.setDefaultRetained(false);
        messageHandler.setDefaultTopic(defaultTopic);
        return messageHandler;
    }


    /**
     * 配置Inbound入站，消费者订阅的消息通道
     */
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    /**
     * 配置Inbound入站，消费者基本连接配置
     * 1. 通过DefaultMqttPahoClientFactory 初始化入站通道适配器
     * 2. 配置超时时长，默认30000毫秒
     * 3. 配置Paho消息转换器
     * 4. 配置发送数据的服务质量 0~2
     * 5. 配置订阅通道
     */
    @Bean
    public MessageProducer inbound() {
        //监听topic为TOPIC_ONLINE的上下线主题
        String[] listenTopic ={ON_LINE,ERROR,DEVICE_PUB,"mqtt_receivedTopic"};
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(clientId + "_inbound", mqttClientFactory(),
                        listenTopic);
        // 设置连接超时时长(默认30000毫秒)
        adapter.setCompletionTimeout(completionTimeout);
        // 配置默认Paho消息转换器(qos=0, retain=false, charset=UTF-8)
        adapter.setConverter(new DefaultPahoMessageConverter());
        // 设置服务质量
        // 0 最多一次，数据可能丢失;1 至少一次，数据可能重复;2 只有一次，有且只有一次;最耗性能
        adapter.setQos(2);
        // 设置订阅通道
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    /**
     * 配置Inbound入站，消费者的消息处理器
     * 1. 使用@ServiceActivator注解，表明所修饰的方法用于消息处理
     * 2. 使用inputChannel值，表明从指定通道中取值
     */
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
            	String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            	System.out.println("============="+topic);
                String type = topic.substring(topic.lastIndexOf("/")+1, topic.length());
                if("hello".equalsIgnoreCase(topic)){
                    System.out.println("hello,fuckXX,"+message.getPayload().toString());
                }else if("hello1".equalsIgnoreCase(topic)){
                    System.out.println("hello1,fuckXX,"+message.getPayload().toString());
                }
            }
        };
    }

}
