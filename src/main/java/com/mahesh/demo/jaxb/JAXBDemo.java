package com.mahesh.demo.jaxb;

import com.maheshbandi.patient.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBDemo {

    public static void main(String[] args) throws JAXBException {

        // Create a JAXB Entry point
        JAXBContext context = JAXBContext.newInstance(Patient.class);
        Marshaller marshaller = context.createMarshaller();
        Patient patient = new Patient();
        patient.setId(123);
        patient.setName("Test Name");
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(patient, stringWriter);
        System.out.println(stringWriter.toString());
        Unmarshaller unMarshaler = context.createUnmarshaller();
        Patient Result1 = (Patient) unMarshaler.unmarshal(new StringReader(stringWriter.toString()));
        System.out.println(Result1.getName());
    }
}
