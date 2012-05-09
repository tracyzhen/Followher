package com.followher.service;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MyMarshaller implements MessageBodyWriter {

	@Context
	protected Providers providers;

	@Override
	public long getSize(Object arg0, Class arg1, Type arg2, Annotation[] arg3,
			MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isWriteable(Class arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return arg0.isAnnotationPresent(XmlRootElement.class);
	}

	@Override
	public void writeTo(Object arg0, Class arg1, Type arg2, Annotation[] arg3,
			MediaType arg4, MultivaluedMap headers, OutputStream arg6)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub

//		try {
//			JAXBContext ctx = null;
//			ContextResolver<JAXBContext> resolver = providers
//					.getContextResolver(JAXBContext.class, arg4);
//			if (resolver != null) {
//				ctx = resolver.getContext(arg1);
//			}
//			if (ctx == null) {
//				// create one ourselves
//				ctx = JAXBContext.newInstance(arg1);
//			}
//			System.out.println("here");
			headers.putSingle("Access-Control-Allow-Origin", "*");
			headers.putSingle("Access-Control-Allow-Methods", "POST, GET");
//			ctx.createMarshaller().marshal(arg0, arg6);
			JsonGenerator jsonGenerator = null;
		    ObjectMapper objectMapper  = new ObjectMapper();
		    jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(arg6, JsonEncoding.UTF8);
		    jsonGenerator.writeObject(arg0);
		    
//		} catch (JAXBException ex) {
//			throw new RuntimeException(ex);
//		}

		// arg6.write(arg0.toString().getBytes());

	}

}
