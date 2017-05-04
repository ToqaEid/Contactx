/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.entitiy.utilityclasses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lenovo
 */
@XmlRootElement
public class ReturnObject {
    private String status;
    private String msg;
    private Object result;

    public ReturnObject(String status, String msg, Object result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    
    
}
