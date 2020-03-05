package com.ssb.vitalsoft.service.impl;
//import com.ssb.vitalsoft.service.PrintToPDFService;
//
//
//import static java.awt.Desktop.getDesktop;
//import static java.awt.Desktop.isDesktopSupported;
//import static java.nio.file.Files.createTempFile;
//import static java.nio.file.Files.write;
//
//import java.io.IOException;
//import java.nio.file.Path;
//
//import io.webfolder.cdp.Launcher;
//import io.webfolder.cdp.Options;
//import io.webfolder.cdp.session.Session;
//import io.webfolder.cdp.session.SessionFactory;
//import org.springframework.stereotype.Service;
//
//@Service("printToPDFService")
//public class PrintToPDFServiceImpl implements PrintToPDFService {
//   public void generatePDF() throws IOException {
//       Path file = createTempFile("cdp4j", ".pdf");
//
//       Options options = Options.builder()
//               .headless(true)
//               .build();
//
//       Launcher launcher = new Launcher(options);
//
//       try (SessionFactory factory = launcher.launch()) {
//
//           String context = factory.createBrowserContext();
//           try (Session session = factory.create(context)) {
//
//               session.navigate("https://webfolder.io/cdp4j.html");
//               session.waitDocumentReady();
//
//               byte[] content = session.printToPDF();
//               write(file, content);
//           }
//
//           factory.disposeBrowserContext(context);
//       }
//
//       if (isDesktopSupported()) {
//           getDesktop().open(file.toFile());
//       }
//
//       launcher.kill();
//   }
//}
//
//
