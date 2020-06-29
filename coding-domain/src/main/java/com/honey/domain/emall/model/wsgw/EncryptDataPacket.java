package com.honey.domain.emall.model.wsgw;

import java.io.Serializable;

/**
 * 公共加解密报文
 * @author WSGW
 *
 */
public class EncryptDataPacket implements Serializable{

	private static final long serialVersionUID = 1L;
	private String skey;//加密key
	private String data;//加密业务报文
	private String sign;//验签信息
	private long timestamp;//时间戳

}
