package util;

import controller.AnimalBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet(name = "FileServlet", urlPatterns = {"/image/*"})
public class FileServlet extends HttpServlet {

    @Inject
    private AnimalBean animalBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getPathInfo();
        File f=new File(animalBean.getUploadTo()+file);
        Files.copy(f.toPath(), resp.getOutputStream());
    }
}
