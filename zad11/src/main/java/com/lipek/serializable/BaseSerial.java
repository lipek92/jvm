package com.lipek.serializable;

import java.util.List;

public abstract class BaseSerial {
	
	public long testSerialization(List<Login> logins) {
		long t1 = System.currentTimeMillis();
		serialize(logins);
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}
	
	public long testDeserialization(List<Login> logins) {
		long t1 = System.currentTimeMillis();
		deserialize();
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}
	
	public abstract void serialize(List<Login> logins);
	public abstract List<Login> deserialize();
}
