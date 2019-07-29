import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException;

public class Pack
{
    //////////////////////////////////////////////////////////////////////////////////////////////////
    ////        Name:           Pack(Constructor)
    ////        Input:          String,String
    ////        Output:         -(Call Back Function)
    ////        Description:    It Accept FileName and DirectoryName from User and pack all files from
    ////                        that directory into given FileName.
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Pack(String Dname,String FName) throws Exception
    {
        File folder = new File("/home/ravindra/"+Dname);
        File[] files = folder.listFiles();
        ArrayList<FileMetaData> fobj = new ArrayList<FileMetaData>();
        for (File file : files)
        {
                if (file.isFile())
                {
                    FileOutputStream fos1 = new FileOutputStream("MetaData.ser");
                    ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                    oos1.writeObject(fobj);
                    FileOutputStream fos2 = new FileOutputStream(FName,true);
                    FileInputStream fios3=new FileInputStream(file.getAbsolutePath());
                    byte b[]=new byte[1024];
                    int i=0;
                    while( (i=fios3.read(b))!=-1)
                    {
                        fos2.write(b,0,i);
                        
                    }
                    fobj.add(new FileMetaData(file.getName(),(int)file.length()));
                    
                    oos1.close();
                    fos1.close();
                    fos2.close();
                    fios3.close();
                }
        }
        //Add ChkSum
        FileMetaData.ChkSum=this.CheckSumCalculate(FName);
        System.out.println(FileMetaData.ChkSum);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
////        Name:           CheckSumCalculate
////        Input:          String
////        Output:         String
////        Description:    It Accept FileName from User and Return its Calculated ChekSum Value.
//////////////////////////////////////////////////////////////////////////////////////////////////////
    public String CheckSumCalculate(String fName) throws Exception
    {
        byte[] b = Files.readAllBytes(Paths.get(fName));
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(b);
        byte[] hash = md.digest();
        StringBuffer sb=new StringBuffer();
        for (byte b1  : hash)
        {
            sb.append(b1 & 0xff);
        }
        return sb.toString();
    }
}
