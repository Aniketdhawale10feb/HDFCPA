package Utility;

import java.io.File;
import java.sql.SQLOutput;

public class FolderOperations
{

    public File CreateSSFolder()
    {
        String Path= "/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/"+ java.time.LocalDateTime.now();
        File SSfolder= new File(Path);
        SSfolder.mkdir();
        // System.out.println(SSfolder.getPath());
        return SSfolder;
    }

    public String GetPath()
    {
        FolderOperations FO= new FolderOperations();
        String SSFolderPath= String.valueOf(FO.CreateSSFolder());
        return SSFolderPath;
    }


    public static void main(String[] args)
    {
        FolderOperations FO= new FolderOperations();
        FO.GetPath();
        System.out.println(FO.GetPath());
    }






}
