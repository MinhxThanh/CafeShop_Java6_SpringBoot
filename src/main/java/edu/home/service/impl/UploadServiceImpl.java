package edu.home.service.impl;

import edu.home.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;


@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    ServletContext app;

    @Autowired
    private HttpServletRequest request;

    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File(System.getProperty("user.dir") + "/src/main/resources/static/assets/" + folder);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File saveFile = new File(dir, name);
            file.transferTo(saveFile);
            System.out.println("path: " + saveFile.getAbsolutePath());
            return saveFile;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public File save1(MultipartFile file, String folder){
        if (!file.isEmpty()){
            String uploadsDir = "/assets/" + folder;
            try {
                String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }

                String s = System.currentTimeMillis() + file.getOriginalFilename();
                String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
                String filePath = realPathtoUploads + name;
                File saveFile = new File(filePath);
                file.transferTo(saveFile);

                System.out.println("saved");
                System.out.println("path: " + saveFile.getAbsolutePath());
                return saveFile;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
