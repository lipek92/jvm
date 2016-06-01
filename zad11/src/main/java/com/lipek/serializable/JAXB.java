package com.lipek.serializable;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB extends BaseSerial {
	
	static String FILE_NAME = "jaxb.xml";

	@Override
	public void serialize(List<Login> logins) {
		LoginList loginList = new LoginList();
		loginList.setLogins(logins);
		
		JAXBContext context = null;
        Marshaller marshaller = null;

		try {
			context = JAXBContext.newInstance(LoginList.class);
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(loginList, new FileWriter(FILE_NAME));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Login> deserialize() {
		LoginList loginList = new LoginList();
		try {
			JAXBContext context = JAXBContext.newInstance(LoginList.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        loginList = (LoginList) unmarshaller.unmarshal(new FileReader(FILE_NAME));
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		 return loginList.getLogins();
	}

}
