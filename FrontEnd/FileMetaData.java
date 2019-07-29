import java.io.Serializable;

public class FileMetaData implements Serializable
{
    String FileName;
    int iSize;
    public static String ChkSum;
    public FileMetaData(String FileName1,int iSize) throws Exception
    {
        this.FileName=FileName1;
        this.iSize=iSize;
    }
}