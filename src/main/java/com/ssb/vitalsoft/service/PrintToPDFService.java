package com.ssb.vitalsoft.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PrintToPDFService {
   void generatePDF() throws IOException;
}
