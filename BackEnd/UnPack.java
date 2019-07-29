import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.io.IOException;

public class UnPack
{
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    ////        Name:           UnPack(Constructor)
    ////        Input:          String
    ////        Output:         -(Call Back Function)
    ////        Description:    It Accept FileName from User and Perform unpacking of object and FileName 
    ////                        Data.                  
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public UnPack(String FName) throws Exception
    { 
        String ChkSum=this.CheckSumCalculate(FName);
        if (ChkSum.compareTo(FileMetaData.ChkSum)!=0)
        {
            System.out.println(ChkSum);
            return ;
        }
    // Deserialization    
            ArrayList<FileMetaData> InputList=new ArrayList<FileMetaData>();
            FileInputStream fios = new FileInputStream("MetaData.ser");
            FileInputStream fiosD = new FileInputStream(FName);
            BufferedInputStream bisD=new BufferedInputStream(fiosD);
            ObjectInputStream ois = new ObjectInputStream(fios);

            InputList=(ArrayList)ois.readObject();

        //Verify list data
            for (FileMetaData i : InputList) 
            {
           
                System.out.println("FileName"+i.FileName+"iSize:"+i.iSize);
                System.out.println("FileName"+i.FileName+"iSize:"+i.iSize);
                FileOutputStream fout =new FileOutputStream(i.FileName);
                int j=0;
                for(j=1;j<=i.iSize;j++)
                {
                    fout.write(fiosD.read());
                }
                fout.close();
            }
          
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
    