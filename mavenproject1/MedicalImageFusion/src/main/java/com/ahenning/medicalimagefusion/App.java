package com.ahenning.medicalimagefusion;

import ij.plugin.DICOM;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Opening DICOM file!");
        DICOM dcm = new DICOM();
        dcm.open("E:\\Projects\\MedicalImageFusion\\Dicom files\\dicom.dcm");
        System.out.println("Image height " + dcm.getHeight() + " width: " + dcm.getWidth() + "\nInfo\n" + dcm.getProperties());
    }
}
