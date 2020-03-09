/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Gustavo
 */

@Component
public class FileSaver {
    
    @Autowired
    private HttpServletRequest request;
    
    private String baseFolder = "c:\\tmp\\casadocodigo\\";
    
    public String write(String folder, MultipartFile file) {
        
        try {
            //String realPath = request.getServletContext().getRealPath("/" + baseFolder);
            String relPath = folder + "\\" + file.getOriginalFilename();
            file.transferTo(new File(baseFolder + relPath));
            
            return relPath;
        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
