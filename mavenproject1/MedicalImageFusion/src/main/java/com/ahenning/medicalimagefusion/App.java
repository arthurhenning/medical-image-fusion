package com.ahenning.medicalimagefusion;

import ij.plugin.DICOM;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String processingFolder
            = "images/";
    private static final String sourceFolder
            = "E:\\Projects\\MedicalImageFusion\\Dicom files\\";
    public static void main( String[] args )
    {
        //opening DICOM file
        DICOM dcm = new DICOM();
        dcm.open(sourceFolder + "dicom.dcm");

        //extract image data from DICOM file
        BufferedImage bf = dcm.getBufferedImage();
        PrintWriter writer = null;
        String currentImageFolder
                = String.valueOf(System.currentTimeMillis()) + "/";
        File outputfile = new File(processingFolder + currentImageFolder + "image.jpg");
        outputfile.mkdirs();
        try {
            ImageIO.write(bf, "jpg", outputfile);
            writer = new PrintWriter(processingFolder + currentImageFolder + "imageInfo.txt", "UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        writer.println(dcm.getProperties());
        writer.close();
    }
}
