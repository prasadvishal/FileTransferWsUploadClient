/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafiletransferwsclient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Vishal Prasad
 */
public class JavaFileTransferWsUploadClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "image.png";
        String filePath = "C:/Users/Vishal Prasad/Desktop/" + fileName;
        File file = new File(filePath);
         try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] imageBytes = new byte[(int) file.length()];
            inputStream.read(imageBytes);
             
            upload(file.getName(), imageBytes);
 
            inputStream.close();
            System.out.println("File uploaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }      
    }

//    private static byte[] download(java.lang.String arg0) {
//        com.mindfire.filetransfer.FileTransferWS_Service service = new com.mindfire.filetransfer.FileTransferWS_Service();
//        com.mindfire.filetransfer.FileTransferWS port = service.getFileTransferWSPort();
//        return port.download(arg0);
//    }

    private static void upload(java.lang.String arg0, byte[] arg1) {
        com.mindfire.filetransfer.FileTransferWS_Service service = new com.mindfire.filetransfer.FileTransferWS_Service();
        com.mindfire.filetransfer.FileTransferWS port = service.getFileTransferWSPort();
        port.upload(arg0, arg1);
    }


    
}
