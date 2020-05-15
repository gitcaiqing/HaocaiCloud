package com.haocai.base.cloudbase.util;

import java.util.UUID;

public class UuidUtil {

	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
