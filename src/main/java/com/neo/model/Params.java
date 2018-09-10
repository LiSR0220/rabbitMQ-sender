package com.neo.model;

public class Params {
    public String paramUrl; // 请求路径
    public String exchangeName; // 交互机名称
    public String queueName; // 路由名称
    public String massageContent; // 消息内容

    public String getParamUrl() {
        return paramUrl;
    }

    public void setParamUrl(String paramUrl) {
        this.paramUrl = paramUrl;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMassageContent() {
        return massageContent;
    }

    public void setMassageContent(String massageContent) {
        this.massageContent = massageContent;
    }
}
