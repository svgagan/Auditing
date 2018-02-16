import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import javax.swing.JOptionPane;  
  
  
public class SplitFile {  
    int FRG_FSIZE=0;  
      
    public File[] splitFile(File source,int noFile,int lsize)  
    {  
        FRG_FSIZE = 1024*5;  
        File[] fileFragments = new File[noFile];  
        String[] frgfName = new String[noFile];  
            try{      
                String sourceFName = source.getName();  
                long sourceFSize = source.length();  
                FileInputStream fis = new FileInputStream(source);  
  
                String Fileinfo = new String(sourceFName + "," + String.valueOf(sourceFSize));  
                System.out.println(noFile);  
                if (lsize != 0) {  
                    noFile--;  
                }  
                System.out.println(noFile);  
                sourceFName = sourceFName.substring(0, sourceFName.lastIndexOf("."));  
                int j=0;  
                for (int i = 1; i<= noFile; i++) {  
                    frgfName[i-1] ="Owner\\cs1\\"+"temp\\"+sourceFName+ String.valueOf(i)+".txt";  
                    fileFragments[i-1] = new File(frgfName[i-1]);  
                     
                    FileOutputStream fos = new FileOutputStream(fileFragments[i - 1]);  
                    byte[] data = new byte[FRG_FSIZE];  
                    int count = fis.read(data);  
                    fos.write(data);  
                    fos.close();  
                    String frgFileInfo = new String(frgfName[i-1] +  String.valueOf(FRG_FSIZE));  
                }  
                if (lsize != 0) {                      
                    System.out.println(noFile);  
                    frgfName[noFile] ="Owner\\cs1\\"+"temp\\"+sourceFName + String.valueOf(noFile+1)+".txt";  
                    fileFragments[noFile] = new File(frgfName[noFile]);  
                    FileOutputStream fos = new FileOutputStream(fileFragments[noFile]);  
                    byte[] data = new byte[lsize];  
                    int count = fis.read(data);  
                    fos.write(data);  
                    fos.close();  
                    String frgFileInfo = new String(frgfName[noFile] +  String.valueOf(lsize));  
                }  
  
               } catch (Exception e) {  
                        
                   System.out.println("Error in Splitting"+e);  
                    JOptionPane.showMessageDialog(null, "Error in Splitting File \n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
                     return null;  
               }  
        return fileFragments;  
  }  
    
//  public static void main(String ar[])  
//  {  
//    SplitFile sf=new SplitFile();  
//    sf.splitFile(new File("ReceiverB.java"),5,1024);  
//  }  
  
  
}  
  